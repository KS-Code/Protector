package eu.kscode.protector.listeners;

import eu.kscode.protector.basic.Main;
import eu.kscode.protector.utils.A00Util;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

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
public class PlayerChatListener implements Listener {

    @EventHandler
    public void onChat(final AsyncPlayerChatEvent e) {
        if (Main.getInstance().getConfig().getBoolean("A00Protector.bad-message.enable")) {
            if (Main.getInstance().getConfig().getStringList("A00Protector.bad-message.list").contains(e.getMessage().toLowerCase())) {
                e.setCancelled(true);
                e.getPlayer().sendMessage(A00Util.fixColors("&8* &4A&C00&7Protector &8:|: &7" + Main.getInstance().getConfig().getString("A00Protector.bad-message.notification")));
            }
        }
    }

    @EventHandler
    public void onBadCommand(final PlayerCommandPreprocessEvent e) {
        if (Main.getInstance().getConfig().getBoolean("A00Protector.bad-command.enable")) {
            if (Main.getInstance().getConfig().getStringList("A00Protector.bad-command.list").contains(e.getMessage().toLowerCase())) {
                e.setCancelled(true);
                e.getPlayer().sendMessage(A00Util.fixColors("&8* &4A&C00&7Protector &8:|: &7" + Main.getInstance().getConfig().getString("A00Protector.bad-command.notification")));
            }

        }
    }
}
