package equipment.wearable;

public class Torso extends Wearable {

  private WearableMaterialType materialType;
  
  public Torso(WearableMaterialType materialType) {
    this.materialType = materialType;
  }
  
  public WearableMaterialType getMaterialType() {
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
