package xyz.fluxinc.coloranvil;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.fluxinc.coloranvil.listeners.AnvilListener;

public final class ColorAnvil extends JavaPlugin {


    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new AnvilListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
