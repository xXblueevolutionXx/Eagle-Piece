package me.yourname.onepiece;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class OnepieceHUD extends Gui {

    private final Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent
    public void onRenderExperienceBar(RenderGameOverlayEvent.Post event) {
        // We only want to draw text on the main game screen (not in menus)
        if (event.type != RenderGameOverlayEvent.ElementType.EXPERIENCE) return;

        int x = 10;
        int y = 10;
        int white = 0xFFFFFF;
        int gold = 0xFFD700;

        // 1. Draw Faction Name
        String factionText = "Side: " + Main.instance.myFactions.getSide().toString();
        this.drawString(mc.fontRendererObj, factionText, x, y, white);

        // 2. Draw Haki Status (Red if active, Gray if off)
        String hakiStatus = Main.instance.myHaki.isArmamentActive ? "Haki: ON" : "Haki: OFF";
        int hakiColor = Main.instance.myHaki.isArmamentActive ? 0xFF0000 : 0xAAAAAA;
        this.drawString(mc.fontRendererObj, hakiStatus, x, y + 10, hakiColor);

        // 3. Draw Berry Count
        String berryText = "Berries: ฿" + Main.instance.myFactions.getBerries();
        this.drawString(mc.fontRendererObj, berryText, x, y + 20, gold);
    }
}
