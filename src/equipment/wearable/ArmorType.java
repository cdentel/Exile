package equipment.wearable;

public enum ArmorType {
  CLOTH(  0,  0,  0, 4,  ArmorWeight.LIGHT), 
  LEATHER(2,  0,  0, 15, ArmorWeight.LIGHT),
  HIDE(   3, -1,  0, 25, ArmorWeight.MEDIUM),
  CHAIN(  6, -1, -1, 40, ArmorWeight.HEAVY),
  SCALE(  7,  0, -1, 45, ArmorWeight.HEAVY),
  PLATE(  8, -2, -1, 50, ArmorWeight.HEAVY);
  
  public final int armorBonus;
  public final int check;
  public final int weight;
  public final int speedModifier;
  public final ArmorWeight armorWeight;
  
  private ArmorType(int armorBonus, int check, int speedModifier, int weight, ArmorWeight armorWeight) {
    this.armorBonus = armorBonus;
    this.check = check;
    this.speedModifier = speedModifier;
    this.weight = weight;
    this.armorWeight = armorWeight;
    
  }
  public enum ArmorWeight {
    LIGHT, MEDIUM, HEAVY;
  }
}
