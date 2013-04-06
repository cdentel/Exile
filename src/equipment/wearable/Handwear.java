package equipment.wearable;

public class Handwear extends Wearable {
  
  private ArmorType materialType;
  
  public Handwear(ArmorType materialType) {
    this.materialType = materialType;
  }

  @Override
  public ArmorType getMaterialType() {
    return materialType;
  }

  @Override
  public int getMaterialArmorClassMultiplier() {
    return 1;
  }

  @Override
  public int getMaterialMovementMultiplier() {
    return 0;
  }

  @Override
  public int getWeightMultiplier() {
    return 3;
  }

}
