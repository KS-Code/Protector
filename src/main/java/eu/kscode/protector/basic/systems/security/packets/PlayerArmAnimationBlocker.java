package eu.kscode.protector.basic.systems.security.packets;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import eu.kscode.protector.basic.Main;
import eu.kscode.protector.basic.systems.managers.AKickManager;

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
public class PlayerArmAnimationBlocker extends PacketAdapter {
    public static Map<String, Integer> PlayerArmAnimationMap;

    static {
        PlayerArmAnimationBlocker.PlayerArmAnimationMap = new HashMap<>();
    }

    public PlayerArmAnimationBlocker(Main plugin) {
        super(plugin, PacketType.Play.Client.ARM_ANIMATION);
    }

    public void onPacketReceiving(PacketEvent e) {
        if (e.getPlayer() == null) {
            return;
        }
        if (Main.getInstance().getConfig().getBoolean("ServerLagAndCrashDetector.enable")) {
            if (PlayerArmAnimationBlocker.PlayerArmAnimationMap.containsKey(e.getPlayer().getName())) {
                PlayerArmAnimationBlocker.PlayerArmAnimationMap.put(e.getPlayer().getName(), PlayerArmAnimationBlocker.PlayerArmAnimationMap.get(e.getPlayer().getName()) + 1);
            } else {
                PlayerArmAnimationBlocker.PlayerArmAnimationMap.put(e.getPlayer().getName(), 1);
            }
            if (PlayerArmAnimationBlocker.PlayerArmAnimationMap.get(e.getPlayer().getName()) > Main.getInstance().getConfig().getInt("ServerLagAndCrashDetector.Blocker.ArmAnimation.limit")) {
                e.setCancelled(true);
                AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r &4A&C00&7Protector &8&m-)---\n&8>> &cYou have been kicked for likely server crashing/lagging\n&8>> &7Probably done using: &4(ArmAnimation)\n&8&m---(-&r &4A&C00&7Protector &8&m-)---");
            }
        }
    }
}
