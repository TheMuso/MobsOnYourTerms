package com.themuso.mobsonyourterms.entity;

import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.world.World;

public class EntityWitherSkeleton extends EntitySkeleton
{
	public EntityWitherSkeleton(World world)
	{
		super(world);
		this.setSkeletonType(1);
	}
}
