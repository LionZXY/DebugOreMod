package com.lionzxy.debugore.blocks;

import com.lionzxy.debugore.tile.DebugOreTileEntity;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

/**
 * Created by nikit on 06.08.2015.
 */
public class DebugOreBlock extends BlockContainer {


    public DebugOreBlock() {
        super(Material.iron);

    }


    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {

            DebugOreTileEntity tileEntity = (DebugOreTileEntity) world.getTileEntity(x, y, z);
            tileEntity.letStart();
            if (player.isSneaking())
                tileEntity.removeRadius();
            else tileEntity.addRadius();
            if (!world.isRemote)
                player.addChatMessage(new ChatComponentText("Area for debug: " + tileEntity.getRadius() + "x" + tileEntity.getRadius()));

        return true;
    }

    @Override
    public boolean canProvidePower()
    {
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new DebugOreTileEntity();
    }
}
