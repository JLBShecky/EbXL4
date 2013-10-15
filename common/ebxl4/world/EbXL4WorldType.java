package ebxl4.world;

import java.util.List;

import ebxl4.world.biome.EbXL4ChunkManager;
import ebxl4.world.chunk.EbXL4ChunkProvider;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.IChunkProvider;

public class EbXL4WorldType extends WorldType {
  public EbXL4WorldType(int id, String name) {
    super(id, name);
  }

  //Sets up the biome and WorldChunkManager.
  @Override
  public WorldChunkManager getChunkManager(World world) {
    return new EbXL4ChunkManager(world); //WorldChunkManager can be used but will
  }

  //Sets up the ChunkProvider. Use ChunkProviderHell for single biome worlds else use ChunkProviderGenerate or a custom provider.
  @Override
  public IChunkProvider getChunkGenerator(World world, String options) {
    return new EbXL4ChunkProvider(world, world.getSeed(), world.getWorldInfo().isMapFeaturesEnabled(), options); //
  }

  //Gets the spawn fuzz for players who join the world.
  @Override
  public int getSpawnFuzz() {
      return 100;
  }
}
