package eu.kscode.protector.listeners;

import eu.kscode.protector.basic.Main;
import eu.kscode.protector.utils.A00Util;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

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
public class PlayerChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        if (Main.getConf().getConf().getBoolean("A00Protector.chat.bad-message.enable")) {
            if (Main.getConf().getConf().getStringList("A00Protector.chat.bad-message.list").contains(e.getMessage().toLowerCase())) {
                e.setCancelled(true);
                e.getPlayer().sendMessage(A00Util.fixColors("&8* " + Main.getMess().getMess().getString("A00Protector.prefix") + " &8:|: &7" + Main.getMess().getMess().getString("A00Protector.bad-message.notification")));
            }
        }
    }

    @EventHandler
    public void onBadCommand(PlayerCommandPreprocessEvent e) {
        if (Main.getConf().getConf().getBoolean("A00Protector.chat.bad-command.enable")) {
            if (Main.getConf().getConf().getStringList("A00Protector.chat.bad-command.list").contains(e.getMessage().toLowerCase())) {
                e.setCancelled(true);
                e.getPlayer().sendMessage(A00Util.fixColors("&8* " + Main.getMess().getMess().getString("A00Protector.prefix") + " &8:|: &7" + Main.getMess().getMess().getString("A00Protector.bad-command.notification")));
            }

        }
    }
}
