package equipment.wearable;

import equipment.Item;

public abstract class Wearable implements Item {
  
  public int getArmorClassModifer() {
    return (int) (getArmorType().armorBonus * getMaterialArmorClassMultiplier());
  }
  
  public int getMovementModifer() {
    return getArmorType().check * getMaterialMovementMultiplier();
  }
  
  @Override
  public int getWeight() {
    return (int) Math.max(getArmorType().weight * getWeightMultiplier(), 1);
  }
  
  public abstract ArmorType getArmorType();
  
  public abstract double getMaterialArmorClassMultiplier();
  
  public abstract int getMaterialMovementMultiplier();
  
  public abstract double getWeightMultiplier();

  
}
