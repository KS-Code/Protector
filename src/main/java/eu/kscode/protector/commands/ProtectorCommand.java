package eu.kscode.protector.commands;

import eu.kscode.protector.utils.A00Util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

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
        sender.sendMessage(A00Util.fixColors("&7 "));
        sender.sendMessage(A00Util.fixColors("&8&m---(-&r &4A&C00&7Protector &8&m-)---"));
        sender.sendMessage(A00Util.fixColors(" &7Version: &c2.7-Stable"));
        sender.sendMessage(A00Util.fixColors(" &7Autors: &cKSCode.eu"));
        sender.sendMessage(A00Util.fixColors(" &7Discord: &chttps://discord.gg/3gFPgQ8"));
        sender.sendMessage(A00Util.fixColors("&8&m---(-&r &4A&C00&7Protector &8&m-)---"));
        sender.sendMessage(A00Util.fixColors("&7 "));
        return false;
    }
}
