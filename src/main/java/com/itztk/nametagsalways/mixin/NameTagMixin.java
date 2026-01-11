package com.itztk.nametagsalways.mixin;

import com.itztk.nametagsalways.ModConfig;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Entity.class)
public abstract class NameTagMixin {

  @Shadow
  public abstract boolean hasCustomName();

  @Overwrite
  public boolean isCustomNameVisible() {
    if (ModConfig.INSTANCE.displayNamesEnabled) {
      return this.hasCustomName();
    } else return false;
  }
}
