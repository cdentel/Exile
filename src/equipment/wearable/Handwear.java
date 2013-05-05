package equipment.wearable;

import equipment.EquipmentType;

public class Handwear extends Wearable {
  
  private ArmorType materialType;
  
  public Handwear(ArmorType materialType) {
    this.materialType = materialType;
  }

  @Override
  public ArmorType getArmorType() {
    return materialType;
  }

  @Override
  public double getMaterialArmorClassMultiplier() {
    return .15;
  }

  @Override
  public double getMaterialMovementMultiplier() {
    return 0.15;
  }

  @Override
  public double getWeightMultiplier() {
    return .15;
  }

  @Override
  public EquipmentType getEquipmentType() {
    return EquipmentType.HANDWEAR;
  }

}
