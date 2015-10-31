package com.themuso.mobsonyourterms.reference;

import java.util.HashMap;

import com.themuso.mobsonyourterms.reference.MobSettings;

public class MobList
{
	public static HashMap<String, MobSettings> mobList = new HashMap<String, MobSettings>();

	public static String getKey(MobSettings value)
	{
		for (String key : mobList.keySet())
		{
			if (mobList.get(key).equals(value))
			{
				return key;
			}
		}

		return "";
	}
}
