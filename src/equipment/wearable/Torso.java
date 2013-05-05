package equipment.wearable;

import equipment.EquipmentType;

public class Torso extends Wearable {

  private ArmorType armorType;
  
  public Torso(ArmorType armorType) {
    this.armorType = armorType;
  }
  @Override
  public ArmorType getArmorType() {
    return armorType;
  }

  @Override
  public double getMaterialArmorClassMultiplier() {
    return 1.0;
  }

  @Override
  public double getMaterialMovementMultiplier() {
    return 1.0;
  }

  @Override
  public double getWeightMultiplier() {
    return 1.0;
  }
  @Override
  public EquipmentType getEquipmentType() {
    return EquipmentType.TORSO;
  }
  


}
