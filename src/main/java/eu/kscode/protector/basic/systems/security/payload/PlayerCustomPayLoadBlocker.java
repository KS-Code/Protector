package eu.kscode.protector.basic.systems.security.payload;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import eu.kscode.protector.basic.Main;
import eu.kscode.protector.basic.systems.managers.AKickManager;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

/*
     A00Protector, Plugin which protects your server against crashes and lags.
   Copyright (C) 2018  KSCode.EU, KrafciG

   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <https://www.gnu.org/licenses/>.
    */
public class PlayerCustomPayLoadBlocker extends PacketAdapter {
    public static Map<String, Integer> PlayerCustomPayLoadMap;

    static {
        PlayerCustomPayLoadBlocker.PlayerCustomPayLoadMap = new HashMap<>();
    }

    public PlayerCustomPayLoadBlocker(Main plugin) {
        super(plugin, PacketType.Play.Client.CUSTOM_PAYLOAD);
    }

    public void onPacketReceiving(PacketEvent e) {
        if (e.getPlayer() == null) {
            return;
        }
        if (PlayerCustomPayLoadBlocker.PlayerCustomPayLoadMap.containsKey(e.getPlayer().getName())) {
            PlayerCustomPayLoadBlocker.PlayerCustomPayLoadMap.put(e.getPlayer().getName(), PlayerCustomPayLoadBlocker.PlayerCustomPayLoadMap.get(e.getPlayer().getName()) + 1);
        } else {
            PlayerCustomPayLoadBlocker.PlayerCustomPayLoadMap.put(e.getPlayer().getName(), 1);
        }
        if (PlayerCustomPayLoadBlocker.PlayerCustomPayLoadMap.get(e.getPlayer().getName()) > Main.getConf().getConf().getInt("CustomPayLoad.PacketLimit.limit")) {
            e.setCancelled(true);
            AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r " + Main.getMess().getMess().getString("A00Protector.prefix") + " &8&m-)---\n&8>> &cYou have been kicked for likely server crashing/lagging\n&8>> &7Probably done using: &4(CustomPayLoad)\n&8&m---(-&r " + Main.getMess().getMess().getString("A00Protector.prefix") + " &8&m-)---");
        }
        String channel = e.getPacket().getStrings().readSafely(0);
        if (Main.getConf().getConf().getBoolean("CustomPayLoad.Forge.enable") && channel.equalsIgnoreCase("FML|HS") || channel.equalsIgnoreCase("FML|MP") || channel.startsWith("FML")) {
            AKickManager.AKickManager2(e.getPlayer(), "&8&m---(-&r " + Main.getMess().getMess().getString("A00Protector.prefix") + " &8&m-)---\n&7" + Main.getMess().getMess().getString("CustomPayLoad.Forge.kick-message"));
        }
        if (Main.getConf().getConf().getBoolean("CustomPayLoad.Forge.enable") && channel.equalsIgnoreCase("WDL|CONTROL") || channel.equalsIgnoreCase("WDL|INIT") || channel.equalsIgnoreCase("WDL|REQUEST") || channel.startsWith("WDL")) {
            AKickManager.AKickManager2(e.getPlayer(), "&8&m---(-&r " + Main.getMess().getMess().getString("A00Protector.prefix") + " &8&m-)---\n&7" + Main.getMess().getMess().getString("CustomPayLoad.WorldDownloader.kick-message"));
        }
    }
}
