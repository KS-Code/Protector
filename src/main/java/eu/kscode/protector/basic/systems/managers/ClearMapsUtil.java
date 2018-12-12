package eu.kscode.protector.basic.systems.managers;

import eu.kscode.protector.basic.Main;
import eu.kscode.protector.basic.systems.security.events.PlayerAnimationDetector;
import eu.kscode.protector.basic.systems.security.events.PlayerDropItemDetector;
import eu.kscode.protector.basic.systems.security.events.PlayerInteractDetector;
import eu.kscode.protector.basic.systems.security.exploits.PlayerRedStoneExploit;
import eu.kscode.protector.basic.systems.security.packets.*;
import eu.kscode.protector.basic.systems.security.payload.PlayerCustomPayLoadBlocker;
import org.bukkit.Bukkit;

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
public class ClearMapsUtil {
    public static void start() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), () -> {
            PlayerArmAnimationBlocker.PlayerArmAnimationMap.clear();
            PlayerBlockDigBlocker.PlayerBlockDigMap.clear();
            PlayerBlockPlaceBlocker.PlayerBlockPlaceMap.clear();
            PlayerCloseWindowBlocker.PlayerCloseWindowMap.clear();
            PlayerEnchantItemBlocker.PlayerEnchantItemMap.clear();
            PlayerEntityActionBlocker.PlayerEntityActionMap.clear();
            PlayerHeldItemSlotBlocker.PlayerHeldItemSlotMap.clear();
            PlayerLookBlocker.PlayerLookMap.clear();
            PlayerPostionBlocker.PlayerPositionMap.clear();
            PlayerResourcePackStatusBlocker.PlayerResourcePackStatusMap.clear();
            PlayerSetCreativeSlotBlocker.PlayerSetCreativeSlotMap.clear();
            PlayerSettingsBlocker.PlayerSettingsMap.clear();
            PlayerTabCompleteBlocker.PlayerTabCompleteMap.clear();
            PlayerTransactionBlocker.PlayerTransactionMap.clear();
            PlayerUpdateSignBlocker.PlayerUpdateSignMap.clear();
            PlayerWindowClickBlocker.PlayerWindowClickMap.clear();
            PlayerUseEntityBlocker.PlayerUseEntityMap.clear();
            PlayerCustomPayLoadBlocker.PlayerCustomPayLoadMap.clear();
            PlayerAnimationDetector.PlayerAnimationMap.clear();
            PlayerDropItemDetector.PlayerDropItemMap.clear();
            PlayerInteractDetector.PlayerInteractMap.clear();
        }, 20L, 20L);
    }

    public static void start2() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), () -> {
            PlayerRedStoneExploit.PlayerRedStoneMap.clear();
        }, 80L, 200L);
    }
}
