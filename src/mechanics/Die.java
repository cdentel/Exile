package mechanics;

import java.util.Random;

import com.google.common.base.Preconditions;

public enum Die implements Rollable {

  d4(4),
  d6(6),
  d8(8),
  d10(10),
  d12(12),
  d20(20),
  d100(100);
  
  public final int sides;
  private final Random r = new Random();
  
  private Die(int sides) {
    this.sides = sides;
  }
  
  public int roll() {
    return r.nextInt(sides) + 1;
  }
  
  
  public int critValue() {
    return sides;
  }
}
