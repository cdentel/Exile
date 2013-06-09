package mechanics.defenses;

import mechanics.modifier.Modifiable;
import mechanics.modifier.numeric.IntegerNumeric;
import event.AttributeBroadcaster;

public class Defenses extends Modifiable<DefenseType, Integer> {

  public Defenses(AttributeBroadcaster broadcaster) {
    super(IntegerNumeric.INSTANCE(), broadcaster);
    broadcaster.provide(DefenseType.class, this);
  }

}
