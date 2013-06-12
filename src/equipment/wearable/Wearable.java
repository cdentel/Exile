package equipment.wearable;

import mechanics.BonusSource;
import mechanics.defenses.DefenseType;
import mechanics.modifier.ImmutableModifier;
import creatures.Creature;
import creatures.components.BurdenType;
import equipment.Equippable;

public abstract class Wearable implements Equippable {
  
  @Override
  public void onEquip(Creature c) {
    c.defenses().add(getDefenseModifier());
    c.burden().add(getBurdenModifier());
  }
  
  @Override
  public void onUnequip(Creature c) {
    c.defenses().remove(getDefenseModifier());
    c.burden().remove(getBurdenModifier());
  }
  
  @Override
  public boolean canBeEquippedBy(Creature c) {
    return c.armorProficiencies().contains(getArmorType());
  }
  
  public ImmutableModifier<DefenseType, Integer> getDefenseModifier() {
    return ImmutableModifier.of(
        BonusSource.ARMOR, 
        DefenseType.AC, 
        (int) (getArmorType().armorBonus * getMaterialArmorClassMultiplier()));
  }
  
  @Override
  public ImmutableModifier<BurdenType, Integer> getBurdenModifier() {
    return ImmutableModifier.of(
          BonusSource.ARMOR, 
          BurdenType.MOVEMENT,
          (int) (getArmorType().check * getMaterialMovementMultiplier()))
        .and(
          BurdenType.WEIGHT,
          (int) Math.max(getArmorType().weight * getWeightMultiplier(), 1));
  }
  
  public abstract ArmorType getArmorType();
  
  public abstract double getMaterialArmorClassMultiplier();
  
  public abstract double getMaterialMovementMultiplier();
  
  public abstract double getWeightMultiplier();

  
}
