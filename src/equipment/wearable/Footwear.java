package equipment.wearable;

import equipment.EquipmentType;


public class Footwear extends Wearable {
  
  private ArmorType materialType;
  
  public Footwear(ArmorType materialType) {
    this.materialType = materialType;
  }

  @Override
  public ArmorType getArmorType() {
    return materialType;
  }

  @Override
  public double getMaterialArmorClassMultiplier() {
    return 0.25;
  }

  @Override
  public double getMaterialMovementMultiplier() {
    return 0.25;
  }

  @Override
  public double getWeightMultiplier() {
    return .25;
  }

  @Override
  public EquipmentType getEquipmentType() {
    return EquipmentType.FOOTWEAR;
  }

}
