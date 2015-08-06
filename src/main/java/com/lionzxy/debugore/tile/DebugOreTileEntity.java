package com.lionzxy.debugore.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by nikit on 06.08.2015.
 */
public class DebugOreTileEntity extends TileEntity {

        private int radius = 0;
        public DebugOreTileEntity(){

        }

        public void readFromNBT(NBTTagCompound nbt){
            super.readFromNBT(nbt);
            radius = nbt.getInteger("Radius");
        }

        public void writeToNBT(NBTTagCompound nbt){
            super.writeToNBT(nbt);
            nbt.setInteger("Radius", radius);
            System.out.println(nbt);
        }

        /*@Override
        public Packet getDescriptionPacket(){
            NBTTagCompound tiletag = new NBTTagCompound();
            this.writeToNBT(tiletag);
            return  ;
        }*/

}
