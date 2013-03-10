package nurseangel.ColoredTools.proxy;

import net.minecraftforge.client.MinecraftForgeClient;
import nurseangel.ColoredTools.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy
{
    @Override
    public void registerRenderers()
    {
    	//TODO 不要なツールはプリロードしない

        MinecraftForgeClient.preloadTexture(Reference.TEXTURE_WOOD);
        MinecraftForgeClient.preloadTexture(Reference.TEXTURE_STONE);
        MinecraftForgeClient.preloadTexture(Reference.TEXTURE_IRON);
        MinecraftForgeClient.preloadTexture(Reference.TEXTURE_GOLD);
        MinecraftForgeClient.preloadTexture(Reference.TEXTURE_DIAMOND);
    }
}