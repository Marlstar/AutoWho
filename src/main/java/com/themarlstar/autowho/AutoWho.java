package com.themarlstar.autowho;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.client.event.ClientChatReceivedEvent;

import java.io.File;


@Mod(
        modid = AutoWho.modID,
        name = AutoWho.modName,
        version = AutoWho.version,
        acceptedMinecraftVersions = "[1.8.9]",
        clientSideOnly = true
)
public class AutoWho
{
    public static final String modID = "autowho";
    public static final String modName = "AutoWho";
    public static final String version = "1.0";
    public static File jarFile;
    public static AutoWho INSTANCE;

    public AutoWho() {
        INSTANCE = this;
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        this.jarFile = event.getSourceFile();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onChat(ClientChatReceivedEvent event) {
        String msg = event.message.getUnformattedText();
        if (msg.contains("Protect your bed and destroy the enemy beds.")) {
            Minecraft.getMinecraft().thePlayer.sendChatMessage("/who");
        }
    }
}
