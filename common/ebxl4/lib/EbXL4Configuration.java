package ebxl4.lib;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;

import com.google.common.base.Optional;

import ebxl4.lib.settingsupdates.TestSampleUpdate;

public abstract class EbXL4Configuration {
  
  public static void init(File configFile) {
    Optional<Configuration> optionalConfig = Optional.absent();
    Configuration config;
    
    try {
        optionalConfig = Optional.of(new Configuration(configFile));
        final Configuration configuration = optionalConfig.get();
        
        // Check to see if we need to update
        CheckVersion(configuration);
        
        LogHelper.info("Updates in queue %d", SettingsUpdates.updates.size());
        
    } catch (final Exception e) {
      //final Exception e
      LogHelper.log(Level.SEVERE, e, "%s had had a problem loading its configuration", ModInfo.MOD_NAME);
    } finally {
      if (optionalConfig.isPresent() && optionalConfig.get().hasChanged()) optionalConfig.get().save();
    }
  }
  
  private static void CheckVersion(Configuration configuration) {
    // Store the version of the configuration in the config file
    Property genVersion = configuration.get(Configuration.CATEGORY_GENERAL, "configuration_version", ModInfo.MOD_VERSION);
    genVersion.comment = "The version of " + ModInfo.MOD_NAME + " that was used to generate this configeration.";
    GeneralSettings.cfgVersion.setVersion(genVersion.getString());
    
    // If the config file is older than the mod we may need to update it.
    if(GeneralSettings.modVersion.compareTo(GeneralSettings.cfgVersion) > 0) {
      // Load the updates
      SettingsUpdates.init();
      
      // Run the updates
      for (SettingsUpdates update : SettingsUpdates.updates) {
        if(GeneralSettings.cfgVersion.compareTo(update.getVersion()) < 0) update.Update(configuration);
      }
        
      
      /*
      // This is the update test version
      Version test = new Version("0.0.1.7");
      int differance = GeneralSettings.cfgVersion.compareTo(test);
      boolean flag = GeneralSettings.cfgVersion.compareTo(test) < 0;
      if(GeneralSettings.cfgVersion.compareTo(new Version("0.0.1.7")) < 0) {
        LogHelper.info("We are updating the version.");
        
        genVersion.set("0.0.1.7");
        GeneralSettings.cfgVersion.setVersion(genVersion.getString());
      }
      */
    }
  }
}
