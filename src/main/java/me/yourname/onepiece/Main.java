@SubscribeEvent
public void onBlockBreak(BlockEvent.BreakEvent event) {
    // 10% chance when breaking leaves
    if (event.state.getBlock() instanceof net.minecraft.block.BlockLeaves) {
        if (myFruit.rollTreeSpawn()) {
            // This drops the "Apple" named Gomu Gomu no Mi
            net.minecraft.entity.item.EntityItem drop = new net.minecraft.entity.item.EntityItem(
                event.world, event.pos.getX(), event.pos.getY(), event.pos.getZ(), 
                myFruit.getFruitItem("Gomu Gomu no Mi")
            );
            event.world.spawnEntityInWorld(drop);
        }
    }
}
