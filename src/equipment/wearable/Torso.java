package equipment.wearable;

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
  public int getMaterialArmorClassMultiplier() {
    return 3;
  }

  @Override
  public int getMaterialMovementMultiplier() {
    return 2;
  }

  @Override
  public double getWeightMultiplier() {
    return 1.0;
  }
  


}
