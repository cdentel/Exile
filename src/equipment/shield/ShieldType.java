package equipment.shield;

public enum ShieldType {
  LIGHT(1,  0, 6),
  HEAVY(2, -2, 15);
  
  public final int armorBonus;
  public final int check;
  public final int weight;
  
  private ShieldType(int sizeModifer, int check, int weight) {
    this.armorBonus = sizeModifer;
    this.check = check;
    this.weight = weight;
  }
}
