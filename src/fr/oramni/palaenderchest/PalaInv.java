package fr.oramni.palaenderchest;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class PalaInv {

	public static String invbase64 = "CgAACAAEdHlwZQAGY3VzdG9tAwAHdmVyc2lvbgAAAAEJAAVpdGVtcwoAAAAJAgACaWQBdQEABUNvdW50AQIABkRhbWFnZUAEAAIAAmlkAXUBAAVDb3VudAECAAZEYW1hZ2VASQACAAJpZAFsAQAFQ291bnRAAgAGRGFtYWdlAAAAAgACaWQBQgEABUNvdW50QAIABkRhbWFnZQABAAIAAmlkARQBAAVDb3VudAEKAAN0YWcJAARlbmNoCgAAAAICAANsdmwABQIAAmlkABAAAgADbHZsAAICAAJpZAAUAAMAClJlcGFpckNvc3QAAAAEAAIABkRhbWFnZQAAAAIAAmlkATYBAAVDb3VudAEKAAN0YWcJAARlbmNoCgAAAAECAANsdmwABAIAAmlkAAAAAwAKUmVwYWlyQ29zdAAAAAIAAgAGRGFtYWdlAAAAAgACaWQBNwEABUNvdW50AQoAA3RhZwkABGVuY2gKAAAAAQIAA2x2bAAEAgACaWQAAAADAApSZXBhaXJDb3N0AAAAAgACAAZEYW1hZ2UAAAACAAJpZAE4AQAFQ291bnQBCgADdGFnCQAEZW5jaAoAAAABAgADbHZsAAQCAAJpZAAAAAMAClJlcGFpckNvc3QAAAACAAIABkRhbWFnZQAAAAIAAmlkATkBAAVDb3VudAEKAAN0YWcJAARlbmNoCgAAAAECAANsdmwABAIAAmlkAAAAAwAKUmVwYWlyQ29zdAAAAAIAAgAGRGFtYWdlAAAAAA==";
	
	
	public static void openEnder(Player p){
	Inventory inv = ItemSerialization.fromBase64(invbase64, p);
	p.playSound(p.getLocation(), Sound.CHEST_OPEN, 1, 1);
	p.updateInventory();
	p.openInventory(inv);
	
	}
}
