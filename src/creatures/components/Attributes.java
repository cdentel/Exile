package creatures.components;
import mechanics.modifier.Modifiable;
import mechanics.modifier.numeric.IntegerNumeric;

import com.google.common.base.Preconditions;

import event.AttributeBroadcaster;


public class Attributes extends Modifiable<AttributeType, Integer> {

  public Attributes(AttributeBroadcaster broadcaster) {
    super(IntegerNumeric.INSTANCE(), broadcaster);
    broadcaster.provide(AttributeType.class, this);
  }

  public int getModifier(AttributeType attribute) {
    Preconditions.checkNotNull(attribute);
    return getModifier(get(attribute));
  }
  
  public static int getModifier(int base) {
    return base / 2 -5;
  }
}
