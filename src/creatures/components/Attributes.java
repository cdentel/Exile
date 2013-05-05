package creatures.components;
import mechanics.modifier.Modifiable;

import com.google.common.base.Preconditions;


public class Attributes extends Modifiable<AttributeType> {
  
  public int getModifier(AttributeType attribute) {
    Preconditions.checkNotNull(attribute);
    return get(attribute) / 2 -5;
  }
}
