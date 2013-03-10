package nurseangel.ColoredTools;

import java.util.logging.Level;

import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.Configuration;
import nurseangel.ColoredTools.proxy.CommonProxy;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class ColoredTools {
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;

	public static Config config;

	/**
	 * コンストラクタ的なもの
	 *
	 * @param event
	 */
	@Mod.PreInit
	public void myPreInitMethod(FMLPreInitializationEvent event) {
		Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());

		try {
			cfg.load();
			config = new Config(cfg);
		} catch (Exception e) {
			FMLLog.log(Level.SEVERE, Reference.MOD_NAME + " loadding configuration failure");
		} finally {
			cfg.save();
		}
	}

	/**
	 * load()
	 *
	 * @param event
	 */
	@Mod.Init
	public void myInitMethod(FMLInitializationEvent event) {
		// 木
		if (config.itemWoodToolIdStart > 1) {
			setColorTools(0, Config.itemWoodToolIdStart);
		}
		 //石
		 if (config.itemStoneToolIdStart > 1) {
		 setColorTools(1, Config.itemStoneToolIdStart);
		 }
		 //鉄
		 if (config.itemIronToolIdStart > 1) {
		 setColorTools(2, Config.itemIronToolIdStart);
		 }
		 //金
		 if (config.itemGoldToolIdStart > 1) {
		 setColorTools(3, Config.itemGoldToolIdStart);
		 }
		 //ダイヤ
		 if (config.itemDiamondToolIdStart > 1) {
		 setColorTools(4, Config.itemDiamondToolIdStart);
		 }

		proxy.registerRenderers();
	}

	/**
	 * 各素材のツールを追加
	 *
	 * @param 配列キー値
	 *            (素材)
	 * @param アイテムID開始値
	 */
	private void setColorTools(int arrayIndex, int itemIdStart) {
		// 剣
		int swordIndex = 0;
		for (int i = 0; i < config.itemNameArray[arrayIndex][swordIndex].length; i++) {
			// 染料でループ
			Item sword = new ItemSword(itemIdStart++, config.itemMaterial[arrayIndex]).setTextureFile(config.textureFile[arrayIndex])
					.setIconCoord(i, swordIndex).setItemName(config.itemNameArray[arrayIndex][swordIndex][i]);

			LanguageRegistry.addName(sword, config.itemNameArray[arrayIndex][swordIndex][i]);
			GameRegistry.addRecipe(new ItemStack(sword, 1), new Object[] { "XY", 'X', Config.itemDyes[i], 'Y', Config.itemTools[arrayIndex][swordIndex] });
		}
		// つるはし
		int pickaxeIndex = 1;
		for (int i = 0; i < config.itemNameArray[arrayIndex][pickaxeIndex].length; i++) {
			Item pickaxe = new ItemPickaxe(itemIdStart++, config.itemMaterial[arrayIndex]).setTextureFile(config.textureFile[arrayIndex])
					.setIconCoord(i, pickaxeIndex).setItemName(config.itemNameArray[arrayIndex][pickaxeIndex][i]);
			LanguageRegistry.addName(pickaxe, config.itemNameArray[arrayIndex][pickaxeIndex][i]);
			GameRegistry.addRecipe(new ItemStack(pickaxe, 1), new Object[] { "XY", 'X', Config.itemDyes[i], 'Y', Config.itemTools[arrayIndex][pickaxeIndex] });
		}
		// 斧
		int axeIndex = 2;
		for (int i = 0; i < config.itemNameArray[arrayIndex][axeIndex].length; i++) {
			Item axe = new ItemAxe(itemIdStart++, config.itemMaterial[arrayIndex]).setTextureFile(config.textureFile[arrayIndex])
					.setIconCoord(i, axeIndex).setItemName(config.itemNameArray[arrayIndex][axeIndex][i]);
			LanguageRegistry.addName(axe, config.itemNameArray[arrayIndex][axeIndex][i]);
			GameRegistry.addRecipe(new ItemStack(axe, 1), new Object[] { "XY", 'X', Config.itemDyes[i], 'Y', Config.itemTools[arrayIndex][axeIndex] });
		}
		// シャベル
		int shovelIndex = 3;
		for (int i = 0; i < config.itemNameArray[arrayIndex][shovelIndex].length; i++) {
			Item shovel = new ItemSpade(itemIdStart++, config.itemMaterial[arrayIndex]).setTextureFile(config.textureFile[arrayIndex])
					.setIconCoord(i, shovelIndex).setItemName(config.itemNameArray[arrayIndex][shovelIndex][i]);
			LanguageRegistry.addName(shovel, config.itemNameArray[arrayIndex][shovelIndex][i]);
			GameRegistry.addRecipe(new ItemStack(shovel, 1), new Object[] { "XY", 'X', Config.itemDyes[i], 'Y', Config.itemTools[arrayIndex][shovelIndex] });
		}

		//全く同じなのでどうにかしたいけどできるのか？

	}

}