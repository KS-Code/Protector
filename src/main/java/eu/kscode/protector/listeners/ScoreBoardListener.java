package eu.kscode.protector.listeners;

import eu.kscode.protector.basic.Main;
import eu.kscode.protector.utils.A00Util;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;

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
public class ScoreBoardListener implements Listener {
    /*
    -> TO CHYBA WYPIERDOLE
 */
    private void update(Player player) {
        int ping = ((CraftPlayer) player).getHandle().ping;
        long usedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        Objective o = Bukkit.getScoreboardManager().getNewScoreboard().registerNewObjective("A00Protector", "A00Protector");
        o.setDisplaySlot(DisplaySlot.SIDEBAR);
        o.setDisplayName(A00Util.fixColors("&8●&r " + Main.getInstance().getConfig().getString("A00Protector.prefix") + " &8●"));
        o.getScore(" §a§r ").setScore(11);
        o.getScore(" §8» §7Imformations §8:|: §cServer").setScore(10);
        o.getScore(" §3§r ").setScore(9);
        o.getScore(" §7Used memory: §c" + usedMem / 1024L / 1024L + "MB").setScore(8);
        o.getScore(" §7Cores: §c" + Runtime.getRuntime().availableProcessors()).setScore(7);
        o.getScore(" §7Your Ping: §c" + ping).setScore(6);
        o.getScore(" §6§r ").setScore(5);
        o.getScore(" §7Total memory: §c" + Runtime.getRuntime().totalMemory() / 1024L / 1024L + "MB").setScore(4);
        o.getScore(" §7Max memeory: §c" + Runtime.getRuntime().maxMemory() / 1024L / 1024L + "MB").setScore(3);
        o.getScore(" §7Free memory: §c" + Runtime.getRuntime().freeMemory() / 1024L / 1024L + "MB").setScore(2);
        o.getScore(" §f§r ").setScore(1);
        o.getScore(" §8» §4A§c00§7Protector §42.7§8-§cStable").setScore(0);
        player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
    }


    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        new BukkitRunnable() {
            public void run() {
                ScoreBoardListener.this.update(e.getPlayer());
            }
        }.runTaskTimer(Main.getInstance(), 130L, 180L);
    }
}
