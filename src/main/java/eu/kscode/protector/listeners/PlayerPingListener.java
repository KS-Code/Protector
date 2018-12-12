package eu.kscode.protector.listeners;

import eu.kscode.protector.basic.Main;
import eu.kscode.protector.utils.A00Util;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

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
public class PlayerPingListener implements Listener {
    public void PlayerPing(final Player player) {
        if (Main.getInstance().getConfig().getBoolean("A00Protector.CheckPing.enable")) {
            int ping = ((CraftPlayer) player).getHandle().ping;
            if (ping > Main.getInstance().getConfig().getInt("A00Protector.CheckPing.limit")) {
                player.getPlayer().kickPlayer(A00Util.fixColors("&8&m---(-&r &4A&C00&7Protector &8&m-)---\n&7" + Main.getInstance().getConfig().getString("A00Protector.CheckPing.kick-message")));
            }
        }

    }
}
