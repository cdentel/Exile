package equipment.wearable;


public class Footwear extends Wearable {
  
  private WearableMaterialType materialType;
  
  public Footwear(WearableMaterialType materialType) {
    this.materialType = materialType;
  }

  @Override
  public WearableMaterialType getMaterialType() {
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
  public int getWeightMultiplier() {
    return 5;
  }

}
