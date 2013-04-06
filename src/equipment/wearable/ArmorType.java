package equipment.wearable;

public enum ArmorType {
  CLOTH(  0, 0, 1, ArmorWeight.LIGHT), 
  LEATHER(1, 0, 1, ArmorWeight.LIGHT),
  HIDE(   2, 1, 2, ArmorWeight.MEDIUM),
  CHAIN(  3, 2, 4, ArmorWeight.HEAVY),
  SCALE(  4, 3, 5, ArmorWeight.HEAVY);
  
  public final int acValue;
  public final int movementModifier;
  public final int weight;
  public final ArmorWeight armorWeight;
  
  private ArmorType(int acValue, int movementModifier, int weight, ArmorWeight armorWeight) {
    this.acValue = acValue;
    this.movementModifier = movementModifier;
    this.weight = weight;
    this.armorWeight = armorWeight;
    
  }
  public enum ArmorWeight {
    LIGHT, MEDIUM, HEAVY;
  }
}
