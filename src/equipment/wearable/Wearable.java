package equipment.wearable;

import equipment.Item;

public abstract class Wearable implements Item {
  
  public int getArmorClassModifer() {
    return getMaterialType().acValue * getMaterialArmorClassMultiplier();
  }
  
  public int getMovementModifer() {
    return getMaterialType().movementModifier * getMaterialMovementMultiplier();
  }
  
  public double getWeight() {
    return getMaterialType().weight * getWeightMultiplier();
  }
  
  public abstract ArmorType getMaterialType();
  
  public abstract int getMaterialArmorClassMultiplier();
  
  public abstract int getMaterialMovementMultiplier();
  
  public abstract int getWeightMultiplier();

  
}
