package com.itztk.nametagsalways.mixin;


import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Entity.class)
public class NameTagMixin {
  @Shadow
  public boolean hasCustomName() {
    return false;
  }

  @Overwrite
  public boolean isCustomNameVisible() {
    return this.hasCustomName();
  }
}
