package equipment.shield;

public enum ShieldType {
  LIGHT(1),
  HEAVY(1.5);
  
  public final double sizeModifier;
  
  private ShieldType(double sizeModifer) {
    this.sizeModifier = sizeModifer;
  }
}
