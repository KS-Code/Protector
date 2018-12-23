package eu.kscode.protector.utils;

import net.minecraft.server.v1_8_R3.MinecraftServer;

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
public final class TPS {

    private static final DecimalFormat FORMAT = new DecimalFormat("##.##");

    public static String geTPS(int last) {
        return MinecraftServer.getServer().recentTps != null ? FORMAT.format(Math.min(20.0D, MinecraftServer.getServer().recentTps[last])) : "N/A";
    }
}