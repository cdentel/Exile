package mechanics.defenses;

import static creatures.components.AttributeType.CHARISMA;
import static creatures.components.AttributeType.CONSTITUTION;
import static creatures.components.AttributeType.DEXTERITY;
import static creatures.components.AttributeType.INTELLIGENCE;
import static creatures.components.AttributeType.STRENGTH;
import creatures.components.AttributeType;

public enum DefenseType {
  AC(DEXTERITY, INTELLIGENCE), 
  FORTITUDE(STRENGTH, CONSTITUTION), 
  REFLEX(DEXTERITY, INTELLIGENCE), 
  WILL(CHARISMA, CONSTITUTION);
  
  public final AttributeType first, second;
  
  private DefenseType(AttributeType first, AttributeType second) {
    this.first = first;
    this.second = second; 
  }
  
}
