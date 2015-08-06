package com.lionzxy.debugore.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by nikit on 06.08.2015.
 */
public class DebugOreTileEntity extends TileEntity {
        /*
        Crash:
        [22:02:37] [Server thread/ERROR] [FML]: A TileEntity type com.lionzxy.debugore.tile.DebugOreTileEntity has throw an exception trying to write state. It will not persist. Report this to the mod author
                java.lang.RuntimeException: class com.lionzxy.debugore.tile.DebugOreTileEntity is missing a mapping! This is a bug!
	            at net.minecraft.tileentity.TileEntity.writeToNBT(TileEntity.java:96) ~[TileEntity.class:?]
	            at com.lionzxy.debugore.tile.DebugOreTileEntity.writeToNBT(DebugOreTileEntity.java:23) ~[DebugOreTileEntity.class:?]
	            at net.minecraft.world.chunk.storage.AnvilChunkLoader.writeChunkToNBT(AnvilChunkLoader.java:395) [AnvilChunkLoader.class:?]
	            at net.minecraft.world.chunk.storage.AnvilChunkLoader.saveChunk(AnvilChunkLoader.java:204) [AnvilChunkLoader.class:?]
	            at net.minecraft.world.gen.ChunkProviderServer.safeSaveChunk(ChunkProviderServer.java:287) [ChunkProviderServer.class:?]
	            at net.minecraft.world.gen.ChunkProviderServer.saveChunks(ChunkProviderServer.java:340) [ChunkProviderServer.class:?]
	            at net.minecraft.world.WorldServer.saveAllChunks(WorldServer.java:863) [WorldServer.class:?]
	            at net.minecraft.server.MinecraftServer.saveAllWorlds(MinecraftServer.java:370) [MinecraftServer.class:?]
	            at net.minecraft.server.integrated.IntegratedServer.tick(IntegratedServer.java:113) [IntegratedServer.class:?]
	            at net.minecraft.server.MinecraftServer.run(MinecraftServer.java:485) [MinecraftServer.class:?]
	            at net.minecraft.server.MinecraftServer$2.run(MinecraftServer.java:752) [MinecraftServer$2.class:?]
         */

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
