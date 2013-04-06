package equipment.wearable;

public class Torso extends Wearable {

  private ArmorType materialType;
  
  public Torso(ArmorType materialType) {
    this.materialType = materialType;
  }
  
  public ArmorType getMaterialType() {
    return materialType;
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
  public int getWeightMultiplier() {
    return 10;
  }
  


}
