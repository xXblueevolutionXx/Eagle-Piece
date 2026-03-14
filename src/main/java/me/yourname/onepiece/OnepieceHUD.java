package me.yourname.onepiece;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class OnepieceHUD extends Gui {

    private final Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent
    public void onRenderHUD(RenderGameOverlayEvent.Post event) {
        // Only draw on the main game screen, not in the inventory or menus
        if (event.type != RenderGameOverlayEvent.ElementType.ALL) return;

        int x = 10;
        int y = 10;
        int berries = Main.instance.myFactions.getBerries();
        
        // --- RANK LOGIC ---
        String rank = "Rookie";
        int rankColor = 0xFFFFFF; // White

        if (berries > 100000) {
            rank = "Emperor";
            rankColor = 0xFF55FF; // Light Purple
        } else if (berries > 25000) {
            rank = "Warlord";
            rankColor = 0x55FFFF; // Aqua
        } else if (berries > 5000) {
            rank = "Supernova";
            rankColor = 0x55FF55; // Green
        }

        // --- DRAWING THE TEXT ---
        // Faction
        this.drawString(mc.fontRendererObj, "Side: " + Main.instance.myFactions.getSide(), x, y, 0xFFFFFF);
        
        // Rank
        this.drawString(mc.fontRendererObj, "Rank: " + rank, x, y + 10, rankColor);
        
        // Berries (Gold color)
        this.drawString(mc.fontRendererObj, "Berries: ฿" + berries, x, y + 20, 0xFFD700);
        
        // Haki Status
        boolean hakiOn = Main.instance.myHaki.isArmamentActive;
        String hakiText = hakiOn ? "Haki: ACTIVE" : "Haki: OFF";
        int hakiColor = hakiOn ? 0xFF0000 : 0xAAAAAA;
        this.drawString(mc.fontRendererObj, hakiText, x, y + 30, hakiColor);
    }
}
