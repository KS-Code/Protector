package eu.kscode.protector.basic.systems.security.packets;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import eu.kscode.protector.basic.Main;
import eu.kscode.protector.basic.systems.managers.AKickManager;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

/*
     A00Protector, Plugin which protects your server against crashes and lags.
   Copyright (C) 2018-2019  KSCode.EU, KrafciG

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
public class PlayerSetCreativeSlotBlocker extends PacketAdapter {
    public static Map<String, Integer> PlayerSetCreativeSlotMap;

    static {
        PlayerSetCreativeSlotBlocker.PlayerSetCreativeSlotMap = new HashMap<>();
    }

    public PlayerSetCreativeSlotBlocker(Main plugin) {
        super(plugin, PacketType.Play.Client.SET_CREATIVE_SLOT);
    }

    public void onPacketReceiving(PacketEvent e) {
        if (e.getPlayer() == null) {
            return;
        }
        if (e.getPlayer().getGameMode() != GameMode.CREATIVE) {
            e.setCancelled(true);
            AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r " + Main.getMess().getMess().getString("A00Protector.prefix") + " &8&m-)---\n&8>> &cYou have been kicked for likely server crashing/lagging\n&8>> &7Probably done using: &4(SetCreativeSlot)\n&8&m---(-&r " + Main.getMess().getMess().getString("A00Protector.prefix") + " &8&m-)---");
        }
        if (PlayerSetCreativeSlotBlocker.PlayerSetCreativeSlotMap.containsKey(e.getPlayer().getName())) {
            PlayerSetCreativeSlotBlocker.PlayerSetCreativeSlotMap.put(e.getPlayer().getName(), PlayerSetCreativeSlotBlocker.PlayerSetCreativeSlotMap.get(e.getPlayer().getName()) + 1);
        } else {
            PlayerSetCreativeSlotBlocker.PlayerSetCreativeSlotMap.put(e.getPlayer().getName(), 1);
        }
        if (PlayerSetCreativeSlotBlocker.PlayerSetCreativeSlotMap.get(e.getPlayer().getName()) > Main.getConf().getConf().getInt("ServerLagAndCrashDetector.Blocker.SetCreativeSlot.limit")) {
            e.setCancelled(true);
            AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r " + Main.getMess().getMess().getString("A00Protector.prefix") + " &8&m-)---\n&8>> &cYou have been kicked for likely server crashing/lagging\n&8>> &7Probably done using: &4(SetCreativeSlot)\n&8&m---(-&r " + Main.getMess().getMess().getString("A00Protector.prefix") + " &8&m-)---");
        }
        // UWAGA BLOKOWANIE NBT NA SPOSOB YOONIKSA
        final ItemStack itemStack = e.getPacket().getItemModifier().readSafely(0);

        if (itemStack.getType() == Material.AIR || itemStack.getAmount() < 0 || itemStack.getType() == null) {
            return;
        }
        if (PlayerSetCreativeSlotBlocker.PlayerSetCreativeSlotMap.get(e.getPlayer().getName()) > 15 && itemStack.getType() == Material.BOOK_AND_QUILL || itemStack.getType() == Material.WRITTEN_BOOK) {
            e.setCancelled(true);
            itemStack.setAmount(0);
            itemStack.setType(Material.AIR);
            AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r " + Main.getMess().getMess().getString("A00Protector.prefix") + " &8&m-)---\n&8>> &cYour NBT is invalid\n&8&m---(-&r " + Main.getMess().getMess().getString("A00Protector.prefix") + " &8&m-)---");
        }

        if (PlayerSetCreativeSlotBlocker.PlayerSetCreativeSlotMap.get(e.getPlayer().getName()) > 50 && itemStack.getType() == Material.FIREWORK || itemStack.getType() == Material.FIREWORK_CHARGE || itemStack.getType() == Material.BEACON) {
            e.setCancelled(true);
            itemStack.setAmount(0);
            itemStack.setType(Material.AIR);
            AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r " + Main.getMess().getMess().getString("A00Protector.prefix") + " &8&m-)---\n&8>> &cYour NBT is invalid\n&8&m---(-&r " + Main.getMess().getMess().getString("A00Protector.prefix") + " &8&m-)---");
        }

    }
}
