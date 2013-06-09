package creatures.components;

import mechanics.modifier.Modifiable;
import mechanics.modifier.numeric.IntegerNumeric;
import event.AttributeBroadcaster;

public class Burden extends Modifiable<BurdenType, Integer> {

  public Burden(AttributeBroadcaster broadcaster) {
    super(IntegerNumeric.INSTANCE(), broadcaster);
    broadcaster.provide(BurdenType.class, this);
  }

}
