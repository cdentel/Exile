package equipment.wearable;


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
  public int getMaterialArmorClassMultiplier() {
    return 1;
  }

  @Override
  public int getMaterialMovementMultiplier() {
    return 1;
  }

  @Override
  public double getWeightMultiplier() {
    return .25;
  }

}
