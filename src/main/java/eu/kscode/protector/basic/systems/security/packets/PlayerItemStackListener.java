package eu.kscode.protector.basic.systems.security.packets;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.nbt.NbtCompound;
import com.comphenix.protocol.wrappers.nbt.NbtFactory;
import com.comphenix.protocol.wrappers.nbt.NbtList;
import eu.kscode.protector.basic.Main;
import eu.kscode.protector.basic.systems.managers.AKickManager;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

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
public class PlayerItemStackListener extends PacketAdapter {
    public PlayerItemStackListener(Main plugin) {
        super(plugin, PacketType.Play.Client.BLOCK_PLACE, PacketType.Play.Client.WINDOW_CLICK, PacketType.Play.Client.SET_CREATIVE_SLOT);
    }

    public void onPacketReceiving(final PacketEvent e) {
        if (e.getPlayer() == null) {
            return;
        }
        final ItemStack itemStack = e.getPacket().getItemModifier().readSafely(0);

        if (itemStack.getType() == Material.AIR || itemStack.getAmount() < 0 || itemStack.getType() == null) {
            return;
        }
        final NbtCompound nbt = (NbtCompound) NbtFactory.fromItemTag(itemStack);
        if (itemStack.getAmount() > 64) {
            e.setCancelled(true);
            itemStack.setAmount(0);
            itemStack.setType(Material.AIR);
            AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r " + Main.getMess().getMess().getString("A00Protector.prefix") + " &8&m-)---\n&8>> &cYour item stack it's too big\n&8>> &7Packet: &4(" + e.getPacket().getType().getPacketClass() + ")\n&8&m---(-&r " + Main.getMess().getMess().getString("A00Protector.prefix") + " &8&m-)---");
        }
        if (nbt.containsKey("pages")) {
            final NbtList<String> pages = nbt.getList("pages");
            if (pages.size() > Main.getConf().getConf().getInt("A00Protector.PagesLimiter.limit")) {
                e.setCancelled(true);
                itemStack.setAmount(0);
                itemStack.setType(Material.AIR);
                AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r " + Main.getMess().getMess().getString("A00Protector.prefix") + " &8&m-)---\n&8>> &cYour book has too many pages\n&8>> &7Pages limit: &4(" + Main.getConf().getConf().getInt("A00Protector.PagesLimiter.limit") + ")\n&8>> &7Packet: &4(" + e.getPacket().getType().getPacketClass() + ")\n&8&m---(-&r " + Main.getMess().getMess().getString("A00Protector.prefix") + " &8&m-)---");
            }
        }
        if (nbt.containsKey("Name")) {
            final NbtList<String> pages = nbt.getList("Name");
            if (pages.size() > Main.getConf().getConf().getInt("A00Protector.PagesLimiter.limit")) {
                e.setCancelled(true);
                itemStack.setAmount(0);
                itemStack.setType(Material.AIR);
                AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r " + Main.getMess().getMess().getString("A00Protector.prefix") + " &8&m-)---\n&8>> &cYour book has too many pages\n&8>> &7Pages limit: &4(" + Main.getConf().getConf().getInt("A00Protector.PagesLimiter.limit") + ")\n&8>> &7Packet: &4(" + e.getPacket().getType().getPacketClass() + ")\n&8&m---(-&r " + Main.getMess().getMess().getString("A00Protector.prefix") + " &8&m-)---");
            }
        }
        if (nbt.containsKey("Lore")) {
            final NbtList<String> pages = nbt.getList("Lore");
            if (pages.size() > Main.getConf().getConf().getInt("A00Protector.PagesLimiter.limit")) {
                e.setCancelled(true);
                itemStack.setAmount(0);
                itemStack.setType(Material.AIR);
                AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r " + Main.getMess().getMess().getString("A00Protector.prefix") + " &8&m-)---\n&8>> &cYour book has too many pages\n&8>> &7Pages limit: &4(" + Main.getConf().getConf().getInt("A00Protector.PagesLimiter.limit") + ")\n&8>> &7Packet: &4(" + e.getPacket().getType().getPacketClass() + ")\n&8&m---(-&r " + Main.getMess().getMess().getString("A00Protector.prefix") + " &8&m-)---");
            }
        }
        if (nbt.containsKey("CustomName")) {
            final NbtList<String> pages = nbt.getList("CustomName");
            if (pages.size() > Main.getConf().getConf().getInt("A00Protector.PagesLimiter.limit")) {
                e.setCancelled(true);
                itemStack.setAmount(0);
                itemStack.setType(Material.AIR);
                AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r " + Main.getMess().getMess().getString("A00Protector.prefix") + " &8&m-)---\n&8>> &cYour book has too many pages\n&8>> &7Pages limit: &4(" + Main.getConf().getConf().getInt("A00Protector.PagesLimiter.limit") + ")\n&8>> &7Packet: &4(" + e.getPacket().getType().getPacketClass() + ")\n&8&m---(-&r " + Main.getMess().getMess().getString("A00Protector.prefix") + " &8&m-)---");
            }
        }
        if (nbt.containsKey("END")) {
            final NbtList<String> pages = nbt.getList("END");
            if (pages.size() > Main.getConf().getConf().getInt("A00Protector.PagesLimiter.limit")) {
                e.setCancelled(true);
                itemStack.setAmount(0);
                itemStack.setType(Material.AIR);
                AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r " + Main.getMess().getMess().getString("A00Protector.prefix") + " &8&m-)---\n&8>> &cYour book has too many pages\n&8>> &7Pages limit: &4(" + Main.getConf().getConf().getInt("A00Protector.PagesLimiter.limit") + ")\n&8>> &7Packet: &4(" + e.getPacket().getType().getPacketClass() + ")\n&8&m---(-&r " + Main.getMess().getMess().getString("A00Protector.prefix") + " &8&m-)---");
            }
        }
        if (nbt.containsKey("ench")) {
            final NbtList<String> pages = nbt.getList("ench");
            if (pages.size() > Main.getConf().getConf().getInt("A00Protector.PagesLimiter.limit")) {
                e.setCancelled(true);
                itemStack.setAmount(0);
                itemStack.setType(Material.AIR);
                AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r " + Main.getMess().getMess().getString("A00Protector.prefix") + " &8&m-)---\n&8>> &cYour book has too many pages\n&8>> &7Pages limit: &4(" + Main.getConf().getConf().getInt("A00Protector.PagesLimiter.limit") + ")\n&8>> &7Packet: &4(" + e.getPacket().getType().getPacketClass() + ")\n&8&m---(-&r " + Main.getMess().getMess().getString("A00Protector.prefix") + " &8&m-)---");
            }
        }
        if (nbt.containsKey("title")) {
            final NbtList<String> pages = nbt.getList("title");
            if (pages.size() > 30 || pages.size() < 1) {
                e.setCancelled(true);
                itemStack.setAmount(0);
                itemStack.setType(Material.AIR);
                AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r " + Main.getMess().getMess().getString("A00Protector.prefix") + " &8&m-)---\n&8>> &cYour book has too many pages\n&8>> &7Pages limit: &4(" + Main.getConf().getConf().getInt("A00Protector.PagesLimiter.limit") + ")\n&8>> &7Packet: &4(" + e.getPacket().getType().getPacketClass() + ")\n&8&m---(-&r " + Main.getMess().getMess().getString("A00Protector.prefix") + " &8&m-)---");
            }
        }
        if (nbt.containsKey("author")) {
            final NbtList<String> pages = nbt.getList("author");
            if (pages.size() > 16 || pages.size() < 1) {
                e.setCancelled(true);
                itemStack.setAmount(0);
                itemStack.setType(Material.AIR);
                AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r " + Main.getMess().getMess().getString("A00Protector.prefix") + " &8&m-)---\n&8>> &cYour book has too many pages\n&8>> &7Pages limit: &4(" + Main.getConf().getConf().getInt("A00Protector.PagesLimiter.limit") + ")\n&8>> &7Packet: &4(" + e.getPacket().getType().getPacketClass() + ")\n&8&m---(-&r " + Main.getMess().getMess().getString("A00Protector.prefix") + " &8&m-)---");
            }
        }
    }
}
