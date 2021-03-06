package eu.kscode.protector.commands;

import eu.kscode.protector.basic.Main;
import eu.kscode.protector.utils.A00Util;
import eu.kscode.protector.utils.TPS;
import net.minecraft.server.v1_8_R3.MinecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

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
public class ServerCommand implements CommandExecutor {
    /*
        -> NAD TYM MUSZE POPRACOWAC
     */
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        long usedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        sender.sendMessage("");
        sender.sendMessage(A00Util.fixColors("&8&m-----(--&r " + Main.getMess().getMess().getString("A00Protector.prefix") + " &8:|: &7Server &8&m--)-----"));
        sender.sendMessage("");
        sender.sendMessage(A00Util.fixColors("&8>> &7TPS &8(&7Current&8) &8(&75min ago&8) &8(&715min ago&8):   &c" + TPS.geTPS(0) + "  &8|  &c" + TPS.geTPS(1) + "  &8|  &c" + TPS.geTPS(2)));
        sender.sendMessage("");
        sender.sendMessage(A00Util.fixColors("&8>> &7Cores: &c" + Runtime.getRuntime().availableProcessors()));
        sender.sendMessage(A00Util.fixColors("&8>> &7Used Memory: &c" + usedMem / 1024L / 1024L + "MB"));
        sender.sendMessage(A00Util.fixColors("&8>> &7Version: &c" + MinecraftServer.getServer().getVersion()));
        sender.sendMessage(A00Util.fixColors("&8>> &7Bukkit version: &c" + Bukkit.getBukkitVersion()));
        sender.sendMessage(A00Util.fixColors("&8>> &7Git Bukkit version: &c" + Bukkit.getServer().getVersion()));
        sender.sendMessage("");
        sender.sendMessage(A00Util.fixColors("&8&m-----(--&r " + Main.getMess().getMess().getString("A00Protector.prefix") + " &8:|: &7Server &8&m--)-----"));
        sender.sendMessage("");
        return false;
    }
}
