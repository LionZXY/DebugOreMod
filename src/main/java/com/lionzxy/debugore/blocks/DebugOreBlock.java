package com.lionzxy.debugore.blocks;

import com.lionzxy.debugore.tile.DebugOreTileEntity;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by nikit on 06.08.2015.
 */
public class DebugOreBlock extends BlockContainer {


    public DebugOreBlock() {
        super(Material.iron);

    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new DebugOreTileEntity();
    }
}
