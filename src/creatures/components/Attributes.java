package creatures.components;
import mechanics.modifier.Modifiable;
import mechanics.modifier.numeric.IntegerNumeric;

import com.google.common.base.Preconditions;


public class Attributes extends Modifiable<AttributeType, Integer> {

  public Attributes() {
    super(IntegerNumeric.INSTANCE());
  }

  public int getModifier(AttributeType attribute) {
    Preconditions.checkNotNull(attribute);
    return get(attribute) / 2 -5;
  }
}
