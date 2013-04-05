package mechanics;

public enum Die {

  d4(4),
  d6(6),
  d8(8),
  d10(10),
  d12(12),
  d20(20),
  d100(100);
  
  public final int sides;
  
  private Die(int sides) {
    this.sides = sides;
  }
}
