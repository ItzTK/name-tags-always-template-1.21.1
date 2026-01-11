package com.itztk.nametagsalways;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = "nametagalways")
public class ModConfig implements ConfigData {

  @ConfigEntry.Gui.Excluded
  public static ModConfig INSTANCE;


  public static void init() {
    AutoConfig.register(ModConfig.class, GsonConfigSerializer::new);
    INSTANCE = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
  }

  @ConfigEntry.Gui.Tooltip()
  @Comment("If true, always show the names of nametagged entities")
  public boolean displayNamesEnabled = true;

  @ConfigEntry.Gui.Tooltip()
  @Comment("If true, will send message to player whenever they toggle display names")
  public boolean sendToggleNotifications = true;


}
