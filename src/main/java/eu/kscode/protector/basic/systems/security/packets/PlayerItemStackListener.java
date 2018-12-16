package eu.kscode.protector.basic.systems.security.packets;

import eu.kscode.protector.basic.*;
import com.comphenix.protocol.*;
import com.comphenix.protocol.events.*;
import org.bukkit.inventory.*;
import org.bukkit.*;
import eu.kscode.protector.basic.systems.managers.*;
import com.comphenix.protocol.wrappers.nbt.*;
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
        if (Main.getInstance().getConfig().getBoolean("A00Protector.PagesLimiter.enable")) {
            if (e.getPlayer() == null) {
                return;
            }
            final ItemStack itemStack = e.getPacket().getItemModifier().readSafely(0);
            if (itemStack.getType() == Material.AIR) {
                return;
            }
            if (e.getPacket().getNbtModifier() == null) {
                e.setCancelled(true);
                return;
            }
            if (itemStack.getType() == null) {
                e.setCancelled(true);
                return;
            }
            final NbtCompound nbt = (NbtCompound) NbtFactory.fromItemTag(itemStack);
            if (itemStack.getAmount() > 64) {
                e.setCancelled(true);
                AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r " + Main.getInstance().getConfig().getString("A00Protector.prefix") + " &8&m-)---\n&8>> &cYour item stack it's too big\n&8>> &7Packet: &4(" + e.getPacket().getType().getPacketClass() + ")\n&8&m---(-&r " + Main.getInstance().getConfig().getString("A00Protector.prefix") + " &8&m-)---");
            }
            if (itemStack.getType() == Material.WRITTEN_BOOK || itemStack.getType() == Material.BOOK || itemStack.getType() == Material.BOOK_AND_QUILL) {
                e.setCancelled(true);
                AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r " + Main.getInstance().getConfig().getString("A00Protector.prefix") + " &8&m-)---\n&8>> &cYour item it's INVAILD\n&8>> &7Packet: &4(" + e.getPacket().getType().getPacketClass() + ")\n&8&m---(-&r " + Main.getInstance().getConfig().getString("A00Protector.prefix") + " &8&m-)---");
            }
            if (e.getPlayer().getInventory() == null && itemStack.getType() != e.getPlayer().getItemInHand().getType()) {
                e.setCancelled(true);
                AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r " + Main.getInstance().getConfig().getString("A00Protector.prefix") + " &8&m-)---\n&8>> &cYour item it's INVAILD\n&8>> &7Packet: &4(" + e.getPacket().getType().getPacketClass() + ")\n&8&m---(-&r " + Main.getInstance().getConfig().getString("A00Protector.prefix") + " &8&m-)---");
            }
            if (nbt.containsKey("pages")) {
                final NbtList<String> pages = nbt.getList("pages");
                if (pages.size() > Main.getInstance().getConfig().getInt("A00Protector.PagesLimiter.limit")) {
                    e.setCancelled(true);
                    AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r " + Main.getInstance().getConfig().getString("A00Protector.prefix") + " &8&m-)---\n&8>> &cYour book has too many pages\n&8>> &7Pages limit: &4(" + Main.getInstance().getConfig().getInt("A00Protector.PagesLimiter.limit") + ")\n&8>> &7Packet: &4(" + e.getPacket().getType().getPacketClass() + ")\n&8&m---(-&r " + Main.getInstance().getConfig().getString("A00Protector.prefix") + " &8&m-)---");
                }
            }
            if (nbt.containsKey("Lore")) {
                final NbtList<String> pages = nbt.getList("Lore");
                if (pages.size() > Main.getInstance().getConfig().getInt("A00Protector.PagesLimiter.limit")) {
                    e.setCancelled(true);
                    AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r " + Main.getInstance().getConfig().getString("A00Protector.prefix") + " &8&m-)---\n&8>> &cYour book has too many pages\n&8>> &7Pages limit: &4(" + Main.getInstance().getConfig().getInt("A00Protector.PagesLimiter.limit") + ")\n&8>> &7Packet: &4(" + e.getPacket().getType().getPacketClass() + ")\n&8&m---(-&r " + Main.getInstance().getConfig().getString("A00Protector.prefix") + " &8&m-)---");
                }
            }
            if (nbt.containsKey("END")) {
                final NbtList<String> pages = nbt.getList("END");
                if (pages.size() > Main.getInstance().getConfig().getInt("A00Protector.PagesLimiter.limit")) {
                    e.setCancelled(true);
                    AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r " + Main.getInstance().getConfig().getString("A00Protector.prefix") + " &8&m-)---\n&8>> &cYour book has too many pages\n&8>> &7Pages limit: &4(" + Main.getInstance().getConfig().getInt("A00Protector.PagesLimiter.limit") + ")\n&8>> &7Packet: &4(" + e.getPacket().getType().getPacketClass() + ")\n&8&m---(-&r " + Main.getInstance().getConfig().getString("A00Protector.prefix") + " &8&m-)---");
                }
            }
            if (nbt.containsKey("ench")) {
                final NbtList<String> pages = nbt.getList("ench");
                if (pages.size() > Main.getInstance().getConfig().getInt("A00Protector.PagesLimiter.limit")) {
                    e.setCancelled(true);
                    AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r " + Main.getInstance().getConfig().getString("A00Protector.prefix") + " &8&m-)---\n&8>> &cYour book has too many pages\n&8>> &7Pages limit: &4(" + Main.getInstance().getConfig().getInt("A00Protector.PagesLimiter.limit") + ")\n&8>> &7Packet: &4(" + e.getPacket().getType().getPacketClass() + ")\n&8&m---(-&r " + Main.getInstance().getConfig().getString("A00Protector.prefix") + " &8&m-)---");
                }
            }
            if (nbt.containsKey("CustomName")) {
                final NbtList<String> pages = nbt.getList("CustomName");
                if (pages.size() > Main.getInstance().getConfig().getInt("A00Protector.PagesLimiter.limit")) {
                    e.setCancelled(true);
                    AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r " + Main.getInstance().getConfig().getString("A00Protector.prefix") + " &8&m-)---\n&8>> &cYour book has too many pages\n&8>> &7Pages limit: &4(" + Main.getInstance().getConfig().getInt("A00Protector.PagesLimiter.limit") + ")\n&8>> &7Packet: &4(" + e.getPacket().getType().getPacketClass() + ")\n&8&m---(-&r " + Main.getInstance().getConfig().getString("A00Protector.prefix") + " &8&m-)---");
                }
            }
            if (nbt.containsKey(String.valueOf(e.getPacket().getListNbtModifier()))) {
                final NbtList<String> pages = nbt.getList(String.valueOf(e.getPacket().getListNbtModifier()));
                if (pages.size() > Main.getInstance().getConfig().getInt("A00Protector.PagesLimiter.limit")) {
                    e.setCancelled(true);
                    AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r " + Main.getInstance().getConfig().getString("A00Protector.prefix") + " &8&m-)---\n&8>> &cYour book has too many pages\n&8>> &7Pages limit: &4(" + Main.getInstance().getConfig().getInt("A00Protector.PagesLimiter.limit") + ")\n&8>> &7Packet: &4(" + e.getPacket().getType().getPacketClass() + ")\n&8&m---(-&r " + Main.getInstance().getConfig().getString("A00Protector.prefix") + " &8&m-)---");
                }
            }
            if (nbt.containsKey(e.getPacket().getStrings().toString())) {
                final NbtList<String> pages = nbt.getList(e.getPacket().getStrings().toString());
                if (pages.size() > Main.getInstance().getConfig().getInt("A00Protector.PagesLimiter.limit")) {
                    e.setCancelled(true);
                    AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r " + Main.getInstance().getConfig().getString("A00Protector.prefix") + " &8&m-)---\n&8>> &cYour book has too many pages\n&8>> &7Pages limit: &4(" + Main.getInstance().getConfig().getInt("A00Protector.PagesLimiter.limit") + ")\n&8>> &7Packet: &4(" + e.getPacket().getType().getPacketClass() + ")\n&8&m---(-&r " + Main.getInstance().getConfig().getString("A00Protector.prefix") + " &8&m-)---");
                }
            }
            if (nbt.containsKey(String.valueOf(e.getPacket().getItemListModifier()))) {
                final NbtList<String> pages = nbt.getList(String.valueOf(e.getPacket().getItemListModifier()));
                if (pages.size() > Main.getInstance().getConfig().getInt("A00Protector.PagesLimiter.limit")) {
                    e.setCancelled(true);
                    AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r " + Main.getInstance().getConfig().getString("A00Protector.prefix") + " &8&m-)---\n&8>> &cYour book has too many pages\n&8>> &7Pages limit: &4(" + Main.getInstance().getConfig().getInt("A00Protector.PagesLimiter.limit") + ")\n&8>> &7Packet: &4(" + e.getPacket().getType().getPacketClass() + ")\n&8&m---(-&r " + Main.getInstance().getConfig().getString("A00Protector.prefix") + " &8&m-)---");
                }
            }
            if (nbt.containsKey("name")) {
                final NbtList<String> pages = nbt.getList("name");
                if (pages.size() > Main.getInstance().getConfig().getInt("A00Protector.PagesLimiter.limit")) {
                    e.setCancelled(true);
                    AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r " + Main.getInstance().getConfig().getString("A00Protector.prefix") + " &8&m-)---\n&8>> &cYour book has too many pages\n&8>> &7Pages limit: &4(" + Main.getInstance().getConfig().getInt("A00Protector.PagesLimiter.limit") + ")\n&8>> &7Packet: &4(" + e.getPacket().getType().getPacketClass() + ")\n&8&m---(-&r " + Main.getInstance().getConfig().getString("A00Protector.prefix") + " &8&m-)---");
                }
            }
            if (nbt.containsKey("Lock")) {
                final NbtList<String> pages = nbt.getList("Lock");
                if (pages.size() > Main.getInstance().getConfig().getInt("A00Protector.PagesLimiter.limit")) {
                    e.setCancelled(true);
                    AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r " + Main.getInstance().getConfig().getString("A00Protector.prefix") + " &8&m-)---\n&8>> &cYour book has too many pages\n&8>> &7Pages limit: &4(" + Main.getInstance().getConfig().getInt("A00Protector.PagesLimiter.limit") + ")\n&8>> &7Packet: &4(" + e.getPacket().getType().getPacketClass() + ")\n&8&m---(-&r " + Main.getInstance().getConfig().getString("A00Protector.prefix") + " &8&m-)---");
                }
            }
            final NbtCompound root = (NbtCompound) NbtFactory.fromItemTag(itemStack);
            if (root.containsKey(root.getName())) {
                final NbtList<String> pages2 = root.getList(root.getName());
                if (pages2.size() > Main.getInstance().getConfig().getInt("A00Protector.PagesLimiter.limit")) {
                    e.setCancelled(true);
                    AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r " + Main.getInstance().getConfig().getString("A00Protector.prefix") + " &8&m-)---\n&8>> &cYour book has too many pages\n&8>> &7Pages limit: &4(" + Main.getInstance().getConfig().getInt("A00Protector.PagesLimiter.limit") + ")\n&8>> &7Packet: &4(" + e.getPacket().getType().getPacketClass() + ")\n&8&m---(-&r " + Main.getInstance().getConfig().getString("A00Protector.prefix") + " &8&m-)---");
                }
            }
        }
    }
}
