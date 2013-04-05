package equipment.shield;

public enum ShieldSize {
  SMALL(1),
  MEDIUM(1.5),
  LARGE(2);
  
  public final double sizeModifier;
  
  private ShieldSize(double sizeModifer) {
    this.sizeModifier = sizeModifer;
  }
}
