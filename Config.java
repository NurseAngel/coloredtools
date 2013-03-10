package nurseangel.ColoredTools;

import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;

public class Config {
	/**
	 * 各ツールのアイテムID開始値
	 */
	public static int itemWoodToolIdStart, itemStoneToolIdStart, itemIronToolIdStart, itemGoldToolIdStart, itemDiamondToolIdStart;

	/**
	 * アイテム名 [素材][ツール種類][色] = "アイテム名"
	 */
	public static String[][][] itemNameArray = new String[5][4][16];

	/**
	 * カラーツールのコンフィグを作る
	 *
	 * @param cfg
	 * @return
	 */
	public Config(Configuration cfg) {
		int effectedItemId = 4096;

		int itemIdStart = 5100;
		String comment = "Use following 64 IDs. If you want to disable, set 0";

		// アイテムID
		itemWoodToolIdStart = cfg.getItem("itemWoodToolIdStart", itemIdStart).getInt();
		itemStoneToolIdStart = cfg.getItem("itemStoneToolIdStart", itemIdStart + 64).getInt();
		itemIronToolIdStart = cfg.getItem("itemIronToolIdStart", itemIdStart + 128).getInt();
		itemGoldToolIdStart = cfg.getItem("itemGoldToolIdStart", itemIdStart + 192).getInt();
		itemDiamondToolIdStart = cfg.getItem("itemDiamondToolIdStart", itemIdStart + 256, comment).getInt();

		// 各アイテム名
		for (int materialName = 0; materialName < materialNames.length; materialName++) {
			setItemName(cfg, materialName, materialNames[materialName]);
		}

	}

	/**
	 * アイテム名を取得する
	 *
	 * @param wood
	 * @param string
	 */
	private void setItemName(Configuration cfg, int index, String material) {
		for (int dyeName = 0; dyeName < dyeNames.length; dyeName++) {
			for (int toolName = 0; toolName < toolNames.length; toolName++) {
				// コンフィグのカテゴリ
				String defaultItemCategory = getDefaultCategory(material, toolNames[toolName], dyeNames[dyeName]);
				// コンフィグのキー値
				String defaultItemKey = getDefaultKey(material, toolNames[toolName], dyeNames[dyeName]);
				// デフォルト値
				String defaultItemName = getDefaultItemName(material, toolNames[toolName], dyeNames[dyeName]);
				// 取得
				itemNameArray[index][toolName][dyeName] = cfg.get(defaultItemCategory, defaultItemKey, defaultItemName).value;
			}
		}
	}

	/**
	 * カテゴリ名
	 *
	 * @param material
	 * @param toolName
	 * @param dyeName
	 * @return "Wooden Hoe"
	 */
	private String getDefaultCategory(String material, String toolName, String dyeName) {
		String ret = material + " " + toolName;
		return ret;
	}

	/**
	 * カテゴリ内でのアイテム名のキー
	 *
	 * @param material
	 * @param toolName
	 * @param dyeName
	 * @return "Red"
	 */
	private String getDefaultKey(String material, String toolName, String dyeName) {
		String ret = dyeName.replaceAll(" ", "");
		return ret;
	}

	/**
	 * デフォルトアイテム名
	 *
	 * @param material
	 * @param toolName
	 * @param dyeName
	 * @return "Wooden Red Hoe"
	 */
	private String getDefaultItemName(String material, String toolName, String dyeName) {
		String ret = dyeName + " " + material + " " + toolName;
		return ret;
	}

	/**
	 * ツール名に使う色名。 ItemDye.dyeColorNamesとはちょっと違う
	 */
	private static final String[] dyeNames = { "Black", "Red", "Green", "Brown", "Blue", "Purple", "Cyan", "Light Grey", "Grey", "Pink", "Lime", "Yellow",
			"Light Blue", "Magenta", "Orange", "White" };
	/**
	 * ツール種類に使う名前。
	 */
	private static final String[] toolNames = { "Sword", "Pickaxe", "Axe", "Shovel" };
	/**
	 * 素材種類に使う名前。
	 */
	private static final String[] materialNames = { "Wooden", "Stone", "Iron", "Golden", "Diamond" };

	/**
	 * ツールに使う色アイテム
	 */
	public static final ItemStack[] itemDyes = { new ItemStack(Item.dyePowder, 1, 0), new ItemStack(Item.dyePowder, 1, 1), new ItemStack(Item.dyePowder, 1, 2),
			new ItemStack(Item.dyePowder, 1, 3), new ItemStack(Item.dyePowder, 1, 4), new ItemStack(Item.dyePowder, 1, 5), new ItemStack(Item.dyePowder, 1, 6),
			new ItemStack(Item.dyePowder, 1, 7), new ItemStack(Item.dyePowder, 1, 8), new ItemStack(Item.dyePowder, 1, 9),
			new ItemStack(Item.dyePowder, 1, 10), new ItemStack(Item.dyePowder, 1, 11), new ItemStack(Item.dyePowder, 1, 12),
			new ItemStack(Item.dyePowder, 1, 13), new ItemStack(Item.dyePowder, 1, 14), new ItemStack(Item.dyePowder, 1, 15) };

	/**
	 * ツール
	 */
	public static final Item[][] itemTools = { { Item.swordWood, Item.pickaxeWood, Item.axeWood, Item.shovelWood, },
			{ Item.swordStone, Item.pickaxeStone, Item.axeStone, Item.shovelStone, }, { Item.swordSteel, Item.pickaxeSteel, Item.axeSteel, Item.shovelSteel, },
			{ Item.swordGold, Item.pickaxeGold, Item.axeGold, Item.shovelGold, },
			{ Item.swordDiamond, Item.pickaxeDiamond, Item.axeDiamond, Item.shovelDiamond } };

	/**
	 * 素材
	 */
	public static final EnumToolMaterial[] itemMaterial = { EnumToolMaterial.WOOD, EnumToolMaterial.STONE, EnumToolMaterial.IRON, EnumToolMaterial.GOLD,
			EnumToolMaterial.EMERALD };
	/**
	 * テクスチャファイル
	 */
	public static final String[] textureFile = { Reference.TEXTURE_WOOD, Reference.TEXTURE_STONE, Reference.TEXTURE_IRON, Reference.TEXTURE_GOLD,
			Reference.TEXTURE_DIAMOND };

}