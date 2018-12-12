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
    /*
        -> TUTAJ JEST NAJWIEKSZY SYF W TYM CALYM PLUGINIE
     */
    public PlayerItemStackListener(final Main plugin) {
        super(plugin, PacketType.Play.Client.BLOCK_PLACE, PacketType.Play.Client.WINDOW_CLICK, PacketType.Play.Client.SET_CREATIVE_SLOT);
    }

    public void onPacketReceiving(final PacketEvent e) {
        if (Main.getInstance().getConfig().getBoolean("A00Protector.PagesLimiter.enable")) {
            if (e.getPlayer() == null) {
                return;
            }
            ItemStack itemStack = e.getPacket().getItemModifier().readSafely(0);
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
            if (e.getPacket().getBytes().size() > 200) {
                e.setCancelled(true);
                AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r &4A&C00&7Protector &8&m-)---\n&8>> &cYour NBT it's too big\n&8>> &7Packet: &4(" + e.getPacket().getType().getPacketClass() + ")\n&8&m---(-&r &4A&C00&7Protector &8&m-)---");
            }
            if (e.getPlayer().getItemInHand().getAmount() > 64) {
                e.setCancelled(true);
                AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r &4A&C00&7Protector &8&m-)---\n&8>> &cYour NBT it's too big\n&8>> &7Packet: &4(" + e.getPacket().getType().getPacketClass() + ")\n&8&m---(-&r &4A&C00&7Protector &8&m-)---");
            }
            if (e.getPacket().getNbtModifier().size() > 5) {
                e.setCancelled(true);
                AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r &4A&C00&7Protector &8&m-)---\n&8>> &cYour NBT it's too big\n&8>> &7Packet: &4(" + e.getPacket().getType().getPacketClass() + ")\n&8&m---(-&r &4A&C00&7Protector &8&m-)---");
            }
            if (e.getPacket().getModifier().size() > 200) {
                e.setCancelled(true);
                AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r &4A&C00&7Protector &8&m-)---\n&8>> &cYour NBT it's too big\n&8>> &7Packet: &4(" + e.getPacket().getType().getPacketClass() + ")\n&8&m---(-&r &4A&C00&7Protector &8&m-)---");
            }
            if (e.getPacket().getItemModifier().size() > 200) {
                e.setCancelled(true);
                AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r &4A&C00&7Protector &8&m-)---\n&8>> &cYour NBT it's too big\n&8>> &7Packet: &4(" + e.getPacket().getType().getPacketClass() + ")\n&8&m---(-&r &4A&C00&7Protector &8&m-)---");
            }
            if (e.getPacket().getListNbtModifier().size() > 5) {
                e.setCancelled(true);
                AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r &4A&C00&7Protector &8&m-)---\n&8>> &cYour NBT it's too big\n&8>> &7Packet: &4(" + e.getPacket().getType().getPacketClass() + ")\n&8&m---(-&r &4A&C00&7Protector &8&m-)---");
            }
            if (e.getPacket().getItemListModifier().size() > 5) {
                e.setCancelled(true);
                AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r &4A&C00&7Protector &8&m-)---\n&8>> &cYour NBT it's too big\n&8>> &7Packet: &4(" + e.getPacket().getType().getPacketClass() + ")\n&8&m---(-&r &4A&C00&7Protector &8&m-)---");
            }
            NbtCompound nbt = (NbtCompound) NbtFactory.fromItemTag(itemStack);
            if (itemStack.getAmount() > 200) {
                e.setCancelled(true);
                AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r &4A&C00&7Protector &8&m-)---\n&8>> &cYour NBT it's too big\n&8>> &7Packet: &4(" + e.getPacket().getType().getPacketClass() + ")\n&8&m---(-&r &4A&C00&7Protector &8&m-)---");
            }

            if (nbt.containsKey("pages")) {
                NbtList<String> pages = nbt.getList("pages");

                if (pages.size() > Main.getInstance().getConfig().getInt("A00Protector.PagesLimiter.limit")) {
                    e.setCancelled(true);
                    AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r &4A&C00&7Protector &8&m-)---\n&8>> &cYour book has too many pages\n&8>> &7Pages limit: &4(" + Main.getInstance().getConfig().getInt("A00Protector.PagesLimiter.limit") + ")\n&8>> &7Packet: &4(" + e.getPacket().getType().getPacketClass() + ")\n&8&m---(-&r &4A&C00&7Protector &8&m-)---");
                }
            }
            if (nbt.containsKey("Lore")) {
                NbtList<String> pages = nbt.getList("Lore");

                if (pages.size() > Main.getInstance().getConfig().getInt("A00Protector.PagesLimiter.limit")) {
                    e.setCancelled(true);
                    AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r &4A&C00&7Protector &8&m-)---\n&8>> &cYour book has too many pages\n&8>> &7Pages limit: &4(" + Main.getInstance().getConfig().getInt("A00Protector.PagesLimiter.limit") + ")\n&8>> &7Packet: &4(" + e.getPacket().getType().getPacketClass() + ")\n&8&m---(-&r &4A&C00&7Protector &8&m-)---");
                }
            }
            if (nbt.containsKey("END")) {
                NbtList<String> pages = nbt.getList("END");

                if (pages.size() > Main.getInstance().getConfig().getInt("A00Protector.PagesLimiter.limit")) {
                    e.setCancelled(true);
                    AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r &4A&C00&7Protector &8&m-)---\n&8>> &cYour book has too many pages\n&8>> &7Pages limit: &4(" + Main.getInstance().getConfig().getInt("A00Protector.PagesLimiter.limit") + ")\n&8>> &7Packet: &4(" + e.getPacket().getType().getPacketClass() + ")\n&8&m---(-&r &4A&C00&7Protector &8&m-)---");
                }
            }
            if (nbt.containsKey("ench")) {
                NbtList<String> pages = nbt.getList("ench");

                if (pages.size() > Main.getInstance().getConfig().getInt("A00Protector.PagesLimiter.limit")) {
                    e.setCancelled(true);
                    AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r &4A&C00&7Protector &8&m-)---\n&8>> &cYour book has too many pages\n&8>> &7Pages limit: &4(" + Main.getInstance().getConfig().getInt("A00Protector.PagesLimiter.limit") + ")\n&8>> &7Packet: &4(" + e.getPacket().getType().getPacketClass() + ")\n&8&m---(-&r &4A&C00&7Protector &8&m-)---");
                }
            }
            if (nbt.containsKey("CustomName")) {
                NbtList<String> pages = nbt.getList("CustomName");

                if (pages.size() > Main.getInstance().getConfig().getInt("A00Protector.PagesLimiter.limit")) {
                    e.setCancelled(true);
                    AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r &4A&C00&7Protector &8&m-)---\n&8>> &cYour book has too many pages\n&8>> &7Pages limit: &4(" + Main.getInstance().getConfig().getInt("A00Protector.PagesLimiter.limit") + ")\n&8>> &7Packet: &4(" + e.getPacket().getType().getPacketClass() + ")\n&8&m---(-&r &4A&C00&7Protector &8&m-)---");
                }
            }
            if (nbt.containsKey(String.valueOf(e.getPacket().getListNbtModifier()))) {
                NbtList<String> pages = nbt.getList(String.valueOf(e.getPacket().getListNbtModifier()));

                if (pages.size() > Main.getInstance().getConfig().getInt("A00Protector.PagesLimiter.limit")) {
                    e.setCancelled(true);
                    AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r &4A&C00&7Protector &8&m-)---\n&8>> &cYour book has too many pages\n&8>> &7Pages limit: &4(" + Main.getInstance().getConfig().getInt("A00Protector.PagesLimiter.limit") + ")\n&8>> &7Packet: &4(" + e.getPacket().getType().getPacketClass() + ")\n&8&m---(-&r &4A&C00&7Protector &8&m-)---");
                }
            }
            if (nbt.containsKey(e.getPacket().getStrings().toString())) {
                NbtList<String> pages = nbt.getList(e.getPacket().getStrings().toString());

                if (pages.size() > Main.getInstance().getConfig().getInt("A00Protector.PagesLimiter.limit")) {
                    e.setCancelled(true);
                    AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r &4A&C00&7Protector &8&m-)---\n&8>> &cYour book has too many pages\n&8>> &7Pages limit: &4(" + Main.getInstance().getConfig().getInt("A00Protector.PagesLimiter.limit") + ")\n&8>> &7Packet: &4(" + e.getPacket().getType().getPacketClass() + ")\n&8&m---(-&r &4A&C00&7Protector &8&m-)---");
                }
            }
            if (nbt.containsKey(String.valueOf(e.getPacket().getItemListModifier()))) {
                NbtList<String> pages = nbt.getList(String.valueOf(e.getPacket().getItemListModifier()));

                if (pages.size() > Main.getInstance().getConfig().getInt("A00Protector.PagesLimiter.limit")) {
                    e.setCancelled(true);
                    AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r &4A&C00&7Protector &8&m-)---\n&8>> &cYour book has too many pages\n&8>> &7Pages limit: &4(" + Main.getInstance().getConfig().getInt("A00Protector.PagesLimiter.limit") + ")\n&8>> &7Packet: &4(" + e.getPacket().getType().getPacketClass() + ")\n&8&m---(-&r &4A&C00&7Protector &8&m-)---");
                }
            }
            if (nbt.containsKey("name")) {
                NbtList<String> pages = nbt.getList("name");

                if (pages.size() > Main.getInstance().getConfig().getInt("A00Protector.PagesLimiter.limit")) {
                    e.setCancelled(true);
                    AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r &4A&C00&7Protector &8&m-)---\n&8>> &cYour book has too many pages\n&8>> &7Pages limit: &4(" + Main.getInstance().getConfig().getInt("A00Protector.PagesLimiter.limit") + ")\n&8>> &7Packet: &4(" + e.getPacket().getType().getPacketClass() + ")\n&8&m---(-&r &4A&C00&7Protector &8&m-)---");
                }
            }
            if (nbt.containsKey("Lock")) {
                NbtList<String> pages = nbt.getList("Lock");

                if (pages.size() > Main.getInstance().getConfig().getInt("A00Protector.PagesLimiter.limit")) {
                    e.setCancelled(true);
                    AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r &4A&C00&7Protector &8&m-)---\n&8>> &cYour book has too many pages\n&8>> &7Pages limit: &4(" + Main.getInstance().getConfig().getInt("A00Protector.PagesLimiter.limit") + ")\n&8>> &7Packet: &4(" + e.getPacket().getType().getPacketClass() + ")\n&8&m---(-&r &4A&C00&7Protector &8&m-)---");
                }
            }
            final NbtCompound root = (NbtCompound) NbtFactory.fromItemTag(itemStack);
            if (root.containsKey(root.getName())) {
                NbtList<String> pages = root.getList(root.getName());
                if (pages.size() > Main.getInstance().getConfig().getInt("A00Protector.PagesLimiter.limit")) {
                    e.setCancelled(true);
                    AKickManager.AKickManager1(e.getPlayer(), "&8&m---(-&r &4A&C00&7Protector &8&m-)---\n&8>> &cYour book has too many pages\n&8>> &7Pages limit: &4(" + Main.getInstance().getConfig().getInt("A00Protector.PagesLimiter.limit") + ")\n&8>> &7Packet: &4(" + e.getPacket().getType().getPacketClass() + ")\n&8&m---(-&r &4A&C00&7Protector &8&m-)---");
                }
            }
        }
    }
}
