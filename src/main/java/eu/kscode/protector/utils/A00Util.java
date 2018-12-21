package eu.kscode.protector.utils;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;

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
public class A00Util {

    public static String fixColors(String msg) {
        return msg.replaceAll("&", "§").replaceAll(">>", "»");
    }

    public static void sendActionBar(Player player, String text) {
        PacketPlayOutChat bar = new PacketPlayOutChat(IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + text + "\"}"), (byte) 2);
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(bar);
    }

    public static void devgui(Player p) {
        ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
        ItemStack szymex = new ItemStack(Material.RED_ROSE, 1);
        ItemStack shadow = new ItemStack(Material.RED_ROSE, 1);
        ItemStack krafcig = new ItemStack(Material.BARRIER, 1);
        ItemMeta glass1 = glass.getItemMeta();
        ItemMeta szymex1 = szymex.getItemMeta();
        ItemMeta shadow1 = shadow.getItemMeta();
        ItemMeta krafcig1 = krafcig.getItemMeta();
        glass1.setDisplayName(A00Util.fixColors("  "));
        szymex1.setDisplayName(A00Util.fixColors("&8* &4&lDEV&8: &cSZYMEX73"));
        shadow1.setDisplayName(A00Util.fixColors("&8* &4&lBIG HELPER&8: &cSHADOW"));
        krafcig1.setDisplayName(A00Util.fixColors("&8* &4&lDEV&8: &cKrafciG"));
        szymex1.setLore(Collections.singletonList(A00Util.fixColors("&8>> &7Discord: &cszymex73#2107 ")));
        shadow1.setLore(Collections.singletonList(A00Util.fixColors("&8>> &7Discord: &cs৸ΛÐӨЩ#5519 ")));
        krafcig1.setLore(Collections.singletonList(A00Util.fixColors("&8>> &7Discord: &cKrafciGG#2926")));
        glass.setItemMeta(glass1);
        szymex.setItemMeta(szymex1);
        shadow.setItemMeta(shadow1);
        krafcig.setItemMeta(krafcig1);
        Inventory inventory = Bukkit.createInventory(p, 9, A00Util.fixColors("&8&m----(--&r &4A&C00&7Protector &8&m--)----"));
        inventory.setItem(0, glass);
        inventory.setItem(1, glass);
        inventory.setItem(2, glass);
        inventory.setItem(3, szymex);
        inventory.setItem(4, krafcig);
        inventory.setItem(5, shadow);
        inventory.setItem(6, glass);
        inventory.setItem(7, glass);
        inventory.setItem(8, glass);
        p.openInventory(inventory);
    }
}