package eu.kscode.protector.basic;


import com.comphenix.protocol.ProtocolLibrary;
import eu.kscode.protector.basic.systems.antivpn.PlayerAddressChecker;
import eu.kscode.protector.basic.systems.antybot.PlayerConnectionListener;
import eu.kscode.protector.basic.systems.managers.ClearMapsUtil;
import eu.kscode.protector.basic.systems.security.events.PlayerAnimationDetector;
import eu.kscode.protector.basic.systems.security.events.PlayerChatDetector;
import eu.kscode.protector.basic.systems.security.events.PlayerDropItemDetector;
import eu.kscode.protector.basic.systems.security.events.PlayerInteractDetector;
import eu.kscode.protector.basic.systems.security.exploits.PlayerBookExploitListener;
import eu.kscode.protector.basic.systems.security.exploits.PlayerPexExploitListener;
import eu.kscode.protector.basic.systems.security.exploits.PlayerRedStoneExploit;
import eu.kscode.protector.basic.systems.security.exploits.PlayerWorldEditExploitListener;
import eu.kscode.protector.basic.systems.security.packets.*;
import eu.kscode.protector.basic.systems.security.payload.PlayerCustomPayLoadBlocker;
import eu.kscode.protector.basic.systems.security.payload.handshake.Forge;
import eu.kscode.protector.basic.systems.security.payload.handshake.WorldDownloader;
import eu.kscode.protector.commands.*;
import eu.kscode.protector.listeners.*;
import eu.kscode.protector.utils.Logger;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

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
public class Main extends JavaPlugin {
    private static Main main;

    public static Main getInstance() {
        return Main.main;
    }

    public void onEnable() {
        long start = System.currentTimeMillis();
        Logger.info("Started loading A00Protector");
        saveDefaultConfig();
        Main.main = this;
        Bukkit.getPluginManager().registerEvents(new PlayerChatDetector(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerDropItemDetector(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerChatListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerClickListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoinAndQuitListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerConnectionListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerAnimationDetector(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerInteractDetector(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerBookExploitListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerPexExploitListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerWorldEditExploitListener(), this);
        Bukkit.getPluginManager().registerEvents(new ScoreBoardListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerPingListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerRedStoneExploit(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerAddressChecker(), this);

        ProtocolLibrary.getProtocolManager().addPacketListener(new PlayerItemStackListener(this));
        ProtocolLibrary.getProtocolManager().addPacketListener(new PlayerArmAnimationBlocker(this));
        ProtocolLibrary.getProtocolManager().addPacketListener(new PlayerBlockDigBlocker(this));
        ProtocolLibrary.getProtocolManager().addPacketListener(new PlayerBlockPlaceBlocker(this));
        ProtocolLibrary.getProtocolManager().addPacketListener(new PlayerCloseWindowBlocker(this));
        ProtocolLibrary.getProtocolManager().addPacketListener(new PlayerEnchantItemBlocker(this));
        ProtocolLibrary.getProtocolManager().addPacketListener(new PlayerEntityActionBlocker(this));
        ProtocolLibrary.getProtocolManager().addPacketListener(new PlayerHeldItemSlotBlocker(this));
        ProtocolLibrary.getProtocolManager().addPacketListener(new PlayerLookBlocker(this));
        ProtocolLibrary.getProtocolManager().addPacketListener(new PlayerPostionBlocker(this));
        ProtocolLibrary.getProtocolManager().addPacketListener(new PlayerResourcePackStatusBlocker(this));
        ProtocolLibrary.getProtocolManager().addPacketListener(new PlayerSetCreativeSlotBlocker(this));
        ProtocolLibrary.getProtocolManager().addPacketListener(new PlayerSettingsBlocker(this));
        ProtocolLibrary.getProtocolManager().addPacketListener(new PlayerTabCompleteBlocker(this));
        ProtocolLibrary.getProtocolManager().addPacketListener(new PlayerTransactionBlocker(this));
        ProtocolLibrary.getProtocolManager().addPacketListener(new PlayerUpdateSignBlocker(this));
        ProtocolLibrary.getProtocolManager().addPacketListener(new PlayerWindowClickBlocker(this));
        ProtocolLibrary.getProtocolManager().addPacketListener(new PlayerUseEntityBlocker(this));

        ProtocolLibrary.getProtocolManager().addPacketListener(new PlayerCustomPayLoadBlocker(this));

        getCommand("Memory").setExecutor(new MemoryCommand());
        getCommand("Server").setExecutor(new ServerCommand());
        getCommand("Helpers").setExecutor(new HelpersCommand());
        getCommand("Protector").setExecutor(new ProtectorCommand());
        getCommand("ProtectorReload").setExecutor(new ProtectorReloadCommand());
        getCommand("ProtectorDevelopers").setExecutor(new ProtectorDevelopersCommand());

        getServer().getMessenger().registerIncomingPluginChannel(this, "FML|HS", new Forge());
        getServer().getMessenger().registerIncomingPluginChannel(this, "FML|MP", new Forge());
        getServer().getMessenger().registerIncomingPluginChannel(this, "WDL|INIT", new WorldDownloader());
        getServer().getMessenger().registerIncomingPluginChannel(this, "WDL|REQUEST", new WorldDownloader());
        getServer().getMessenger().registerOutgoingPluginChannel(this, "WDL|CONTROL");

        ClearMapsUtil.start();
        ClearMapsUtil.start2();

        long ra = System.currentTimeMillis() - start;
        Logger.info("Completed loading A00Protector in (" + ra + "ms)");
    }

}
