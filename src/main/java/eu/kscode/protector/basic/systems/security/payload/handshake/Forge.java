package eu.kscode.protector.basic.systems.security.payload.handshake;

import eu.kscode.protector.basic.Main;
import eu.kscode.protector.basic.systems.managers.AKickManager;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

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
public class Forge implements PluginMessageListener {
    public Forge() {
    }

    public void onPluginMessageReceived(String channel, Player player, byte[] value) {
        if (channel.equalsIgnoreCase("FML|MP") || channel.equalsIgnoreCase("FML|HS") || channel.startsWith("FML")) {
            AKickManager.AKickManager2(player.getPlayer(), "&8&m---(-&r " + Main.getMess().getMess().getString("A00Protector.prefix") + " &8&m-)---\n&7" + Main.getMess().getMess().getString("CustomPayLoad.Forge.kick-message"));
        }

    }
}