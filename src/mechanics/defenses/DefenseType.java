package mechanics.defenses;

import static creatures.components.AttributeType.CHARISMA;
import static creatures.components.AttributeType.CONSTITUTION;
import static creatures.components.AttributeType.DEXTERITY;
import static creatures.components.AttributeType.INTELLIGENCE;
import static creatures.components.AttributeType.STRENGTH;
import mechanics.Attribute;
import creatures.components.AttributeType;

public enum DefenseType implements Attribute<Integer> {
  AC(DEXTERITY, INTELLIGENCE), 
  FORTITUDE(STRENGTH, CONSTITUTION), 
  REFLEX(DEXTERITY, INTELLIGENCE), 
  WILL(CHARISMA, CONSTITUTION);
  
  public final AttributeType first, second;
  
  private DefenseType(AttributeType first, AttributeType second) {
    this.first = first;
    this.second = second; 
  }
  
  @Override
  public String toString() {
    if(equals(AC)) {
      return super.toString();
    } else {
      return "" + name().charAt(0) + name().substring(1).toLowerCase();
    }
  }
    
  public String getAbbreviation() {
    if(equals(REFLEX)) {
      return name().substring(0, 3);
    } else if(name().length() > 4) {
      return name().substring(0, 4);
    } else {
      return name();
    }
  }
}
