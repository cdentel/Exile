package equipment.wearable;

public class Handwear extends Wearable {
  
  private WearableMaterialType materialType;
  
  public Handwear(WearableMaterialType materialType) {
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
    return 0;
  }

  @Override
  public int getWeightMultiplier() {
    return 3;
  }

}
