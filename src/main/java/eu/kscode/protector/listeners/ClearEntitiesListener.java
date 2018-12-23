package eu.kscode.protector.listeners;

import eu.kscode.protector.basic.Main;
import eu.kscode.protector.utils.A00Util;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.event.Listener;

import java.util.List;

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
public class ClearEntitiesListener implements Listener {

    public static void clerEntities() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), () -> {
            World world = Bukkit.getServer().getWorld(Main.getConf().getConf().getString("A00Protector.ClearItemsOnGround.world"));
            final List<Entity> entList = world.getEntities();
            for (final Entity current : entList) {
                if (current instanceof Item && entList.size() > Main.getConf().getConf().getInt("A00Protector.ClearItemsOnGround.max-items")) {
                    current.remove();
                }
            }
        }, 400L, 400L);
        Bukkit.broadcastMessage(A00Util.fixColors("&8* " + Main.getMess().getMess().getString("A00Protector.prefix") + " " + Main.getMess().getMess().getString("A00Protector.ClearItemsOnGround.notify")));
    }
}
