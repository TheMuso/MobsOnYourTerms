package com.themuso.mobsonyourterms.utility;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;

public class EntityNBTHelper
{
	public static boolean hasTag(Entity entity, String keyName)
	{
		if (entity == null)
		{
			return false;
		}

		NBTTagCompound tagCompound = entity.getEntityData();

		return tagCompound.hasKey(keyName);
	}

	public static void removeTag(Entity entity, String keyName)
	{
		NBTTagCompound tagCompound = entity.getEntityData();

		tagCompound.removeTag(keyName);
	}

	public static void setLong(Entity entity, String keyName, long keyValue)
	{
		NBTTagCompound tagCompound = entity.getEntityData();

		tagCompound.setLong(keyName, keyValue);
	}

	// String
	public static String getString(Entity entity, String keyName)
	{
		NBTTagCompound tagCompound = entity.getEntityData();

		if (!tagCompound.hasKey(keyName))
		{
			setString(entity, keyName, "");
		}

		return tagCompound.getString(keyName);
	}

	public static void setString(Entity entity, String keyName, String keyValue)
	{
		NBTTagCompound tagCompound = entity.getEntityData();

		tagCompound.setString(keyName, keyValue);
	}

	// boolean
	public static boolean getBoolean(Entity entity, String keyName)
	{
		NBTTagCompound tagCompound = entity.getEntityData();

		if (!tagCompound.hasKey(keyName))
		{
			setBoolean(entity, keyName, false);
		}

		return tagCompound.getBoolean(keyName);
	}

	public static void setBoolean(Entity entity, String keyName, boolean keyValue)
	{
		NBTTagCompound tagCompound = entity.getEntityData();

		tagCompound.setBoolean(keyName, keyValue);
	}

	// byte
	public static byte getByte(Entity entity, String keyName)
	{
		NBTTagCompound tagCompound = entity.getEntityData();

		if (!tagCompound.hasKey(keyName))
		{
			setByte(entity, keyName, (byte) 0);
		}

		return tagCompound.getByte(keyName);
	}

	public static void setByte(Entity entity, String keyName, byte keyValue)
	{
		NBTTagCompound tagCompound = entity.getEntityData();

		tagCompound.setByte(keyName, keyValue);
	}

	// short
	public static short getShort(Entity entity, String keyName)
	{
		NBTTagCompound tagCompound = entity.getEntityData();

		if (!tagCompound.hasKey(keyName))
		{
			setShort(entity, keyName, (short) 0);
		}

		return tagCompound.getShort(keyName);
	}

	public static void setShort(Entity entity, String keyName, short keyValue)
	{
		NBTTagCompound tagCompound = entity.getEntityData();

		tagCompound.setShort(keyName, keyValue);
	}

	// int
	public static int getInt(Entity entity, String keyName)
	{
		NBTTagCompound tagCompound = entity.getEntityData();

		if (!tagCompound.hasKey(keyName))
		{
			setInteger(entity, keyName, 0);
		}

		return tagCompound.getInteger(keyName);
	}

	public static void setInteger(Entity entity, String keyName, int keyValue)
	{
		NBTTagCompound tagCompound = entity.getEntityData();

		tagCompound.setInteger(keyName, keyValue);
	}

	// long
	public static long getLong(Entity entity, String keyName)
	{
		NBTTagCompound tagCompound = entity.getEntityData();

		if (!tagCompound.hasKey(keyName))
		{
			setLong(entity, keyName, 0);
		}

		return tagCompound.getLong(keyName);
	}

	// float
	public static float getFloat(Entity entity, String keyName)
	{
		NBTTagCompound tagCompound = entity.getEntityData();

		if (!tagCompound.hasKey(keyName))
		{
			setFloat(entity, keyName, 0);
		}

		return tagCompound.getFloat(keyName);
	}

	public static void setFloat(Entity entity, String keyName, float keyValue)
	{
		NBTTagCompound tagCompound = entity.getEntityData();

		tagCompound.setFloat(keyName, keyValue);
	}

	// double
	public static double getDouble(Entity entity, String keyName)
	{
		NBTTagCompound tagCompound = entity.getEntityData();

		if (!tagCompound.hasKey(keyName))
		{
			setDouble(entity, keyName, 0);
		}

		return tagCompound.getDouble(keyName);
	}

	public static void setDouble(Entity entity, String keyName, double keyValue)
	{
		NBTTagCompound tagCompound = entity.getEntityData();

		tagCompound.setDouble(keyName, keyValue);
	}
}
