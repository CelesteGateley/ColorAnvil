package xyz.fluxinc.coloranvil.listeners;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.sun.xml.internal.ws.api.message.Packet;
import org.bukkit.ChatColor;
import xyz.fluxinc.coloranvil.ColorAnvil;

public class PacketListener  {

    private ColorAnvil pluginInstance;

    public PacketListener(ColorAnvil instance) {
        pluginInstance = instance;
        initialise();
    }

    private void initialise() {
        pluginInstance.getProtocolManager().getAsynchronousManager()
                .registerAsyncHandler(new PacketAdapter(PacketAdapter.params(this.pluginInstance, PacketType.Play.Client.CUSTOM_PAYLOAD).clientSide()) {

                    @Override
                    public void onPacketReceiving(PacketEvent event) {
                        PacketContainer packet = event.getPacket();
                        if (packet.getStrings().getValues().get(0).equals("MC|ItemName")) {
                            final byte[] barray = packet.getByteArrays().getValues().get(0);
                            if (barray != null) {
                                packet.getByteArrays().write(0, removeColorCodes(barray).getBytes());
                            }
                        }
                    }

                    private String removeColorCodes(byte[] string) {
                        StringBuilder sb = new StringBuilder();
                        for (byte b : string) { sb.append((char) b); }
                        return ChatColor.stripColor(sb.toString());
                    }

                });
    }
}
