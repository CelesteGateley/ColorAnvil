package xyz.fluxinc.coloranvil;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.fluxinc.coloranvil.listeners.AnvilListener;
import xyz.fluxinc.coloranvil.listeners.PacketListener;

public final class ColorAnvil extends JavaPlugin {

    private ProtocolManager protocolManager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        protocolManager = ProtocolLibrary.getProtocolManager();
        getServer().getPluginManager().registerEvents(new AnvilListener(), this);

    }

    PacketListener p = new PacketListener(this);
    public ProtocolManager getProtocolManager() {
        return this.protocolManager;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        protocolManager.removePacketListeners(this);
        protocolManager = null;
        HandlerList.unregisterAll();
    }
}
