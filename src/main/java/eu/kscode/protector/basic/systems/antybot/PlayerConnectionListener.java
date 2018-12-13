package eu.kscode.protector.basic.systems.antybot;

import eu.kscode.protector.basic.Main;
import eu.kscode.protector.basic.systems.managers.AKickManager;
import eu.kscode.protector.utils.A00Util;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.server.ServerListPingEvent;

import java.net.InetAddress;
import java.util.ArrayList;

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
public class PlayerConnectionListener implements Listener {
    /*
        -> TUTAJ MOZE BYC DROBNY SYF
     */
    private ArrayList<InetAddress> pinged;


    public PlayerConnectionListener() {
        this.pinged = new ArrayList<>();
    }

    @EventHandler
    public void onConnect(AsyncPlayerPreLoginEvent e) {
        if (Main.getInstance().getConfig().getBoolean("A00Protector.antybot.ping-motd.enable")) {
            InetAddress ip = e.getAddress();
            if (!this.pinged.contains(ip)) {
                e.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, ChatColor.translateAlternateColorCodes('&', "&8&m---(-&r " + Main.getInstance().getConfig().getString("A00Protector.prefix") + " &8&m-)---\n&7" + Main.getInstance().getConfig().getString("A00Protector.antybot.ping-motd.kick-message")));
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void PlayerNickChecker(AsyncPlayerPreLoginEvent e) {
        if (Main.getInstance().getConfig().getBoolean("A00Protector.nick-check.enable")) {
            if (e.getName().toLowerCase().contains("bot") || e.getName().toLowerCase().contains("ploxy") ||
                    e.getName().toLowerCase().contains("pl0xy") || e.getName().toLowerCase().contains("pr0xy") ||
                    e.getName().toLowerCase().contains("Pr0ksi") || e.getName().toLowerCase().contains("b0t") ||
                    e.getName().toLowerCase().contains("proksi") || e.getName().toLowerCase().contains("proxy") ||
                    Main.getInstance().getConfig().getStringList("A00Protector.nick-check.list").contains(e.getName().toLowerCase())) {
                e.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, A00Util.fixColors("&8&m---(-&r " + Main.getInstance().getConfig().getString("A00Protector.prefix") + " &8&m-)---\n&7" + Main.getInstance().getConfig().getString("A00Protector.nick-check.kick-message")));
            }
        }
    }

    @EventHandler
    public void onPing(ServerListPingEvent e) {
        if (Main.getInstance().getConfig().getBoolean("A00Protector.antybot.ping-motd.enable")) {
            InetAddress ip = e.getAddress();
            this.pinged.add(ip);
            Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> PlayerConnectionListener.this.pinged.remove(ip), 400L);
        }
    }

    @EventHandler
    public void AntyBotDubbleJoin(PlayerJoinEvent e) {
        if (Main.getInstance().getConfig().getBoolean("A00Protector.antybot.dubble-join.enable")) {
            if (!e.getPlayer().hasPlayedBefore()) {
                AKickManager.AKickManager2(e.getPlayer(), "&8&m---(-&r " + Main.getInstance().getConfig().getString("A00Protector.prefix") + " &8&m-)---\n&7" + Main.getInstance().getConfig().getString("A00Protector.antybot.double-join.kick-message"));
            }
        }
    }
}
