package com.timelocked;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.Item.Properties;

public final class BatonItem extends Item {
   public BatonItem() {
      super(new Properties().durability(512).attributes(SwordItem.createAttributes(Tiers.IRON, 2, -2.2F)));
   }

   public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
      return true;
   }

   public void postHurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
      stack.hurtAndBreak(1, attacker, EquipmentSlot.MAINHAND);
   }

   public boolean isValidRepairItem(ItemStack stack, ItemStack ingredient) {
      return ingredient.is((Item)Content.STEEL.get());
   }
}
