package mechanics.defenses;

import mechanics.modifier.Modifiable;
import mechanics.modifier.numeric.IntegerNumeric;

public class Defenses extends Modifiable<DefenseType, Integer> {

  public Defenses() {
    super(IntegerNumeric.INSTANCE());
    // TODO Auto-generated constructor stub
  }

}
