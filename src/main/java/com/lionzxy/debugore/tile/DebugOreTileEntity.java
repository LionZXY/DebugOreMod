package com.lionzxy.debugore.tile;

import com.lionzxy.debugore.DebugOreMod;
import com.lionzxy.debugore.blocks.DebugOreBlock;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nikit on 06.08.2015.
 */
public class DebugOreTileEntity extends TileEntity {

        public static List<Block> onlyDigList = new ArrayList<Block>();
        private int radius = 1;
        private boolean start = false;
        private int startX, startY, startZ;
        private int progress;

        public int getRadius(){
            return radius;
        }

        public void addRadius(){
            radius = radius * 2;
        }

        public void removeRadius(){
            radius = radius / 2;
        }

        public void letStart(){
            start = true;
            startX = this.xCoord + radius;
            startY = this.yCoord - 1;
            startZ = this.zCoord + radius;
        }
        public DebugOreTileEntity(){

        }

        public void readFromNBT(NBTTagCompound nbt){
            super.readFromNBT(nbt);
            radius = nbt.getInteger("Radius");
            startX = nbt.getInteger("StartX");
            startY = nbt.getInteger("StartY");
            startZ = nbt.getInteger("StartZ");
        }

        public void writeToNBT(NBTTagCompound nbt){
            super.writeToNBT(nbt);
            nbt.setInteger("Radius", radius);
            nbt.setInteger("StartX",startX);
            nbt.setInteger("StartY",startY);
            nbt.setInteger("StartZ",startZ);
            System.out.println(nbt);
        }

        @Override
        public void updateEntity() {
            if(this.getWorldObj().getStrongestIndirectPower(this.xCoord, this.yCoord, this.zCoord) != 0 && !this.getWorldObj().isRemote){
                System.out.println("Start dig. X:" + startX + " Y:" + startY + " Z:" + startZ);
                World world = this.getWorldObj();
                digBlock(startX,startY,startZ);
                if(startX != this.xCoord - radius)
                    startX--;
                else {
                    startX = this.xCoord + radius;
                    if(startZ != this.zCoord - radius)
                        startZ --;
                    else {
                        startZ = this.zCoord + radius;
                        if(startY != 0)
                            startY--;
                        else start = false;
                    }}
            }
        }

        @Override
        public boolean canUpdate() {
            return true;
        }

        private void digBlock(int x, int y, int z){
            if(checkBlock(this.getWorldObj().getBlock(x,y,z))){
                this.getWorldObj().setBlockToAir(x,y,z);
            }
        }

        public boolean checkBlock(Block block) {

            if(block != null)
            if(DebugOreMod.smart){
                if(checkToOre(block))
                    return false;
                else return true;
            }
            else
            for(Block i : DebugOreTileEntity.onlyDigList)
                if(block == i)
                    return true;

            return false;
        }

        boolean checkToOre(Block block){
            for(int i : OreDictionary.getOreIDs(new ItemStack(block)))
                if(OreDictionary.getOreName(i).substring(0,3).equalsIgnoreCase("ore"))
                    return true;


            return false;
        }
        /*@Override
        public Packet getDescriptionPacket(){
            NBTTagCompound tiletag = new NBTTagCompound();
            this.writeToNBT(tiletag);
            return  ;
        }*/

}
