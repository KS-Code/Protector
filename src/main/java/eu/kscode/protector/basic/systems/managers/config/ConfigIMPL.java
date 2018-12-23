package eu.kscode.protector.basic.systems.managers.config;

import java.io.File;
import java.io.IOException;

import eu.kscode.protector.basic.Main;
import org.bukkit.configuration.file.YamlConfiguration;

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
public class ConfigIMPL implements ConfigManager {

    private YamlConfiguration mess;
    private YamlConfiguration conf;

    @Override
    public void loadMess() {
        File file = new File(Main.getInstance().getDataFolder(), "messages.yml");
        if (!file.exists()) {
            Main.getInstance().saveResource("messages.yml", true);
        }
        mess = YamlConfiguration.loadConfiguration(file);
    }

    @Override
    public YamlConfiguration getMess() {
        return mess;
    }

    @Override
    public void saveMess() {
        try {
            File file = new File(Main.getInstance().getDataFolder(), "messages.yml");
            mess.save(file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void loadConf() {
        File file = new File(Main.getInstance().getDataFolder(), "config.yml");
        if (!file.exists()) {
            Main.getInstance().saveResource("config.yml", true);
        }
        conf = YamlConfiguration.loadConfiguration(file);
    }

    @Override
    public YamlConfiguration getConf() {
        return conf;
    }

    @Override
    public void saveConf() {
        try {
            File file = new File(Main.getInstance().getDataFolder(), "config.yml");
            conf.save(file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
