package eu.kscode.protector.basic.systems.security.events;

import eu.kscode.protector.basic.Main;
import eu.kscode.protector.utils.A00Util;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
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

public class PlayerChatDetector implements Listener {
    /*
    -> TUTAJ TROCHE ZJEBALEM MATCHES
 */
    @EventHandler
    public void onPlayerChat(final AsyncPlayerChatEvent e) {
        if (e.getPlayer() == null) {
            return;
        }
        if (Main.getInstance().getConfig().getBoolean("ServerLagAndCrashDetector.enable")) {
            if (e.getMessage() == null || !e.getMessage().matches(" [a-zA-Z0-1]!@#$%^&*()-=_+~`; ' ':,.'\'/<>?|][}{'] ")) {
                e.setCancelled(true);
                e.getPlayer().sendMessage(A00Util.fixColors(" &8* &4A&C00&7Protector &8:|: &7Message has invalid characters"));
            }
        }
    }
}
