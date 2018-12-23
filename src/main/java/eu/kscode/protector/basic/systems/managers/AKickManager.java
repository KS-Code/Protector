package eu.kscode.protector.basic.systems.managers;

import eu.kscode.protector.basic.Main;
import eu.kscode.protector.utils.A00Util;
import eu.kscode.protector.utils.Logger;
import io.netty.channel.Channel;
import net.minecraft.server.v1_8_R3.NetworkManager;
import net.minecraft.server.v1_8_R3.PacketPlayOutExplosion;
import net.minecraft.server.v1_8_R3.Vec3D;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.Collections;

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
public class AKickManager {
    /*
        -> TUTAJ MALY SYF XD
     */
    public static void AKickManager1(Player player, String reason) {
        Main plugin = Main.getPlugin(Main.class);

        plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, () -> {
            if (player == null) {
                return;
            }
            if (Main.getConf().getConf().getBoolean("A00Protector.crash.ban.enable")) {
                Logger.warn("** A00Protector -> Player: (" + player.getPlayer().getName() + ") has been banned for crashing/lagging.");
                Bukkit.getServer().broadcastMessage(A00Util.fixColors("&8** " + Main.getMess().getMess().getString("A00Protector.prefix") + " &8-> &7Player: &c" + player.getPlayer().getName() + " &7has been banned for crashing/lagging."));
                player.setBanned(true);
            }
            if (player.isOnline()) {
                if (Main.getConf().getConf().getBoolean("A00Protector.crash.handle-disconnect.enable")) {
                    ((CraftPlayer) player).getHandle().playerConnection.disconnect(reason);
                }

                if (Main.getConf().getConf().getBoolean("A00Protector.crash.kick-player.enable")) {
                    player.kickPlayer(A00Util.fixColors(reason));
                }

                if (Main.getConf().getConf().getBoolean("A00Protector.crash.crash-player.enable")) {
                    ((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutExplosion(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Float.MAX_VALUE, Collections.EMPTY_LIST, new Vec3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE)));
                }
                }

            if (Main.getConf().getConf().getBoolean("A00Protector.crash.close-socket.enable")) {
                    NetworkManager netMan = ((CraftPlayer) player).getHandle().playerConnection.networkManager;
                    Channel channel = netMan.channel;
                    channel.close();
            }
        });
    }

    public static void AKickManager2(Player player, String reason) {
        Main plugin = Main.getPlugin(Main.class);
        plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, () -> {
            if (player == null) {
                return;
            }
            if (player.isOnline()) {
                player.kickPlayer(reason);
            }
        });
    }
}
