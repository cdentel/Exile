package creatures.components;

import mechanics.modifier.Modifiable;
import mechanics.modifier.numeric.IntegerNumeric;

public class Burden extends Modifiable<BurdenType, Integer> {

  public Burden() {
    super(IntegerNumeric.INSTANCE());
    // TODO Auto-generated constructor stub
  }

}
