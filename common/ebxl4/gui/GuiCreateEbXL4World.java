package ebxl4.gui;

import net.minecraft.client.gui.GuiCreateWorld;
import net.minecraft.client.gui.GuiScreen;

public class GuiCreateEbXL4World extends GuiScreen {
	
	private GuiCreateWorld createWorldGui;
	private String settings = "";
	
	public GuiCreateEbXL4World(GuiCreateWorld caller, String prams) {
        this.createWorldGui = caller;
        this.settings = prams;
    }

    public String getFlatGeneratorInfo()
    {
        return settings;
    }

    public void setFlatGeneratorInfo(String prams)
    {
        this.settings = prams;
    }
    
    
	public void initGui(){
		//this.
	}
}
