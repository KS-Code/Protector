package eu.kscode.protector.commands;

import eu.kscode.protector.basic.Main;
import eu.kscode.protector.utils.A00Util;
import eu.kscode.protector.utils.TPS;
import net.minecraft.server.v1_8_R3.MinecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.text.DecimalFormat;

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
public class ProtectorCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        long usedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        if (!sender.hasPermission("a00protector.reload")) {
            sender.sendMessage(A00Util.fixColors("&8** &fA00Protector &7created by &fKSCode &8**"));
            sender.sendMessage(A00Util.fixColors("&7TPS: &c" + TPS.geTPS(0) + " &8:|: &7Usage memory: &c" + usedMem / 1024L / 1024L + "MB"));
            return false;
        }
        sender.sendMessage(A00Util.fixColors("&7TPS: &c" + TPS.geTPS(0) + " &8:|: &7Usage memory: &c" + usedMem / 1024L / 1024L + "MB"));
        sender.sendMessage(A00Util.fixColors(" "));
        sender.sendMessage(A00Util.fixColors("&cYou have op ore permission. Reloading config"));
        sender.sendMessage(A00Util.fixColors(" "));
        long start = System.currentTimeMillis();
        Main.getMess().saveMess();
        Main.getConf().saveConf();
        Main.getConf().loadConf();
        Main.getMess().loadMess();
        long ra = System.currentTimeMillis() - start;
        sender.sendMessage(A00Util.fixColors(" &8* " + Main.getMess().getMess().getString("A00Protector.prefix") + " &8:|: &7Config has &csuccessfully &7reloaded in &8(&c" + ra + "ms&8)"));
        return false;
    }
}
