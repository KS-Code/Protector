package eu.kscode.protector.basic.systems.security.events;

import eu.kscode.protector.basic.Main;
import eu.kscode.protector.basic.systems.managers.AKickManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

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
public class PlayerInteractDetector implements Listener {
    public static Map<String, Integer> PlayerInteractMap;

    static {
        PlayerInteractDetector.PlayerInteractMap = new HashMap<>();
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        if (e.getPlayer() == null) {
            return;
        }
        if (PlayerInteractDetector.PlayerInteractMap.containsKey(e.getPlayer().getName())) {
            PlayerInteractDetector.PlayerInteractMap.put(e.getPlayer().getName(), PlayerInteractDetector.PlayerInteractMap.get(e.getPlayer().getName()) + 1);
        } else {
            PlayerInteractDetector.PlayerInteractMap.put(e.getPlayer().getName(), 1);
        }
        if (PlayerInteractDetector.PlayerInteractMap.get(e.getPlayer().getName()) > 600) {
            e.setCancelled(true);
            AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r " + Main.getMess().getMess().getString("A00Protector.prefix") + " &8&m-)---\n&8>> &cYou have been kicked for likely server crashing/lagging\n&8>> &7Probably done using: &4(Interact)\n&8&m---(-&r " + Main.getMess().getMess().getString("A00Protector.prefix") + " &8&m-)---");
        }
    }
}
