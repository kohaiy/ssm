package cn.gqxqd.util;

import java.util.UUID;

public class ShopUtil {

	public static String getKey() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
