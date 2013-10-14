package ebxl4;

import java.io.File;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import ebxl4.lib.ModInfo;
import ebxl4.proxy.CommonProxy;
import ebxl4.lib.LogHelper;

@Mod(modid = ModInfo.MOD_ID, name = ModInfo.MOD_NAME, version = ModInfo.MOD_VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class EbXL4 {
  @Instance(ModInfo.MOD_ID)
  public static EbXL4         instance;
  
  @SidedProxy(clientSide = ModInfo.CLIENT_PROXY, serverSide = ModInfo.SERVER_PROXY)
  public static CommonProxy         proxy;
  
  @Mod.EventHandler
  public static void preInit(FMLPreInitializationEvent event) throws Exception {
    LogHelper.info("Doing Pre Init Stuff.");
  }
  
  @Mod.EventHandler
  public static void init(FMLInitializationEvent event) throws InstantiationException, IllegalAccessException {
    LogHelper.info("Initializing.");
  }
  
  @Mod.EventHandler
  public static void postInit(FMLPostInitializationEvent event) {
    LogHelper.info("Doing post initilization stuff.");
  }
}
