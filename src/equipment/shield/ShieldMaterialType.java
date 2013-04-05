package equipment.shield;

public enum ShieldMaterialType {
  LEATHER(1, 10),
  WOOD(2, 15),
  IRON(3, 25);
  
  public final int acValue;
  public final int weight;
  
  private ShieldMaterialType(int acValue, int materialWeight) {
    this.acValue = acValue;
    this.weight = materialWeight;
    
  }
}
