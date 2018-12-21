package eu.kscode.protector.basic.systems.security.events;

import eu.kscode.protector.basic.Main;
import eu.kscode.protector.basic.systems.managers.AKickManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

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
public class PlayerDropItemDetector implements Listener {

    public static Map<String, Integer> PlayerDropItemMap;

    static {
        PlayerDropItemDetector.PlayerDropItemMap = new HashMap<>();
    }

    @EventHandler
    public void PlayerDropItem(PlayerDropItemEvent e) {
        if (e.getPlayer() == null) {
            return;
        }
        if (PlayerDropItemDetector.PlayerDropItemMap.containsKey(e.getPlayer().getName())) {
            PlayerDropItemDetector.PlayerDropItemMap.put(e.getPlayer().getName(), PlayerDropItemDetector.PlayerDropItemMap.get(e.getPlayer().getName()) + 1);
        } else {
            PlayerDropItemDetector.PlayerDropItemMap.put(e.getPlayer().getName(), 1);
        }
        if (PlayerDropItemDetector.PlayerDropItemMap.get(e.getPlayer().getName()) > 64) {
            e.setCancelled(true);
            AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r " + Main.getInstance().getConfig().getString("A00Protector.prefix") + " &8&m-)---\n&8>> &cYou have been kicked for likely server crashing/lagging\n&8>> &7Probably done using: &4(ItemDrop)\n&8>> &7Limit: &4(64/2)\n&8&m---(-&r " + Main.getInstance().getConfig().getString("A00Protector.prefix") + " &8&m-)---");
        }
    }
}
