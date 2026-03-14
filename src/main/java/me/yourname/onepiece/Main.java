package me.yourname.onepiece;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraft.block.BlockLeaves;
import net.minecraft.inventory.IInventory;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.EntitySkeleton;

@Mod(modid = "eaglepiece", name = "Eagle Piece", version = "1.0")
public class Main {
    
    public static Main instance;

    public DevilFruit myFruit = new DevilFruit("Gomu Gomu");
    public Haki myHaki = new Haki();
    public Commands myCommands = new Commands();
    public Factions myFactions = new Factions();
    public MobManager myMobs = new MobManager();
    public KeyInputHandler myKeys;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        instance = this;

        // Client-side only setup (HUD and Keys)
        if (event.getSide().isClient()) {
            myKeys = new KeyInputHandler();
            MinecraftForge.EVENT_BUS.register(myKeys);
            
            OnepieceHUD myHUD = new OnepieceHUD();
            MinecraftForge.EVENT_BUS.register(myHUD);
        }

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(myMobs); 
        
        System.out.println("Eagle-Piece: All Systems Online!");
    }

    // 1. Berry Reward System
    @SubscribeEvent
    public void onEntityKill(LivingDeathEvent event) {
        if (event.source.getEntity() instanceof EntityPlayer) {
            Factions.Side side = myFactions.getSide();
            
            // Pirates earn Berries for killing Marines (Zombies)
            if (side == Factions.Side.PIRATE && event.entityLiving instanceof EntityZombie) {
                myFactions.addBerries(100);
            } 
            // Marines earn Berries for killing Pirates (Skeletons)
            else if (side == Factions.Side.MARINE && event.entityLiving instanceof EntitySkeleton) {
                myFactions.addBerries(100);
            }
        }
    }

    // 2. Fruit Spawning Logic
    @SubscribeEvent
    public void onBlockBreak(BlockEvent.BreakEvent event) {
        if (event.state.getBlock() instanceof BlockLeaves) {
            EntityItem fruitDrop = new EntityItem(event.world, event.pos.getX(), event.pos.getY(), event.pos.getZ(), myFruit.getFruitItem("Gomu Gomu no Mi"));
            event.world.spawnEntityInWorld(fruitDrop);
        }
    }

    @SubscribeEvent
    public void onChestOpen(PlayerInteractEvent event) {
        if (event.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) {
            if (event.world.getTileEntity(event.pos) instanceof IInventory) {
                IInventory chest = (IInventory) event.world.getTileEntity(event.pos);
                for (int i = 0; i < chest.getSizeInventory(); i++) {
                    if (chest.getStackInSlot(i) == null) {
                        chest.setInventorySlotContents(i, myFruit.getFruitItem("Gomu Gomu no Mi"));
                        break;
                    }
                }
            }
        }
    }

    // 3. Power and Faction Updates
    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (myFactions.getSide() == Factions.Side.PIRATE) {
            myFruit.applyPower(event.player);
            myFruit.checkWaterWeakness(event.player);
        } else if (myFactions.getSide() == F
