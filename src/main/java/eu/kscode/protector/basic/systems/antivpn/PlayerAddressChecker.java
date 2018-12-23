package eu.kscode.protector.basic.systems.antivpn;

import eu.kscode.protector.basic.Main;
import eu.kscode.protector.utils.A00Util;
import eu.kscode.protector.utils.Logger;
import org.apache.commons.io.IOUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.json.JSONObject;

import java.net.URL;

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
public class PlayerAddressChecker implements Listener {
    @EventHandler
    public void onLogin(final AsyncPlayerPreLoginEvent e) {
        if (Main.getConf().getConf().getBoolean("A00Protector.anti-vpn.checkip.enable") && this.isProxy(e.getAddress().getHostAddress())) {
            Logger.warn(e.getName() + "'s use vpn or proxy");
            e.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, A00Util.fixColors("&8&m---(-&r " + Main.getMess().getMess().getString("A00Protector.prefix") + " &8&m-)---\n&7" + Main.getMess().getMess().getString("A00Protector.anti-vpn.checkip.kick-message")));
        }
        if (Main.getConf().getConf().getBoolean("A00Protector.anti-vpn.country.enable") && this.Country(e.getAddress().getHostAddress())) {
            Logger.warn(e.getName() + "'s joined with blocked country");
            e.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, A00Util.fixColors("&8&m---(-&r " + Main.getMess().getMess().getString("A00Protector.prefix") + " &8&m-)---\n&7" + Main.getMess().getMess().getString("A00Protector.anti-vpn.country.kick-message")));
        }
        if (Main.getConf().getConf().getBoolean("A00Protector.anti-vpn.isocode.enable") && this.isoCode(e.getAddress().getHostAddress())) {
            Logger.warn(e.getName() + "'s joined with blocked isocode");
            e.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, A00Util.fixColors("&8&m---(-&r " + Main.getMess().getMess().getString("A00Protector.prefix") + " &8&m-)---\n&7" + Main.getMess().getMess().getString("A00Protector.anti-vpn.isocode.kick-message")));
        }
    }

    private boolean isProxy(final String address) {
        try {
            final String json = new String(IOUtils.toByteArray(new URL("http://proxycheck.io/v2/" + address).openStream()));
            final JSONObject obj = new JSONObject(json);
            if (obj.getJSONObject(address).get("proxy").equals("yes")) {
                return true;
            }
        } catch (Exception ignored) {
        }
        return false;
    }

    private boolean Country(final String address) {
        try {
            final String json = new String(IOUtils.toByteArray(new URL("http://proxycheck.io/v2/" + address + "&key=111111-222222-333333-444444&vpn=1&asn=1&node=1&time=1&tag=forum%20signup%20page").openStream()));
            final JSONObject obj = new JSONObject(json);
            if (!obj.getJSONObject(address).get("country").toString().toLowerCase().contains((CharSequence) Main.getConf().getConf().getStringList("A00Protector.anti-vpn.country.list"))) {
                return true;
            }
        } catch (Exception ignored) {
        }
        return false;
    }

    private boolean isoCode(final String address) {
        try {
            final String json = new String(IOUtils.toByteArray(new URL("http://proxycheck.io/v2/" + address + "&key=111111-222222-333333-444444&vpn=1&asn=1&node=1&time=1&tag=forum%20signup%20page").openStream()));
            final JSONObject obj = new JSONObject(json);
            if (!obj.getJSONObject(address).get("isocode").toString().toLowerCase().contains((CharSequence) Main.getConf().getConf().getStringList("A00Protector.anti-vpn.isocode.list"))) {
                return true;
            }
        } catch (Exception ignored) {
        }
        return false;
    }
}
