package me.yourname.onepiece;

import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MobManager {

    // 1. Give them names and gear when they spawn
    @SubscribeEvent
    public void onMobSpawn(LivingSpawnEvent.SpecialSpawn event) {
        if (event.entityLiving instanceof EntityZombie) {
            event.entityLiving.setCustomNameTag("Marine Ensign");
            // Give Marines a "Baton" (Stick) so they aren't empty-handed
            event.entityLiving.setCurrentItemOrArmor(0, new ItemStack(Items.stick));
        } 
        else if (event.entityLiving instanceof EntitySkeleton) {
            event.entityLiving.setCustomNameTag("Pirate Grunt");
            // Skeletons already have bows, which fits Pirates well
        }
    }

    // 2. Make them respect Factions
    @SubscribeEvent
    public void onMobTarget(LivingSetAttackTargetEvent event) {
        if (event.target instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.target;
            Factions.Side side = Main.instance.myFactions.getSide();

            // Marines don't hit Marines
            if (event.entityLiving instanceof EntityZombie && side == Factions.Side.MARINE) {
                ((EntityZombie) event.entityLiving).setAttackTarget(null);
            }

            // Pirates don't hit Pirates
            if (event.entityLiving instanceof EntitySkeleton && side == Factions.Side.PIRATE) {
                ((EntitySkeleton) event.entityLiving).setAttackTarget(null);
            }
        }
    }
}
