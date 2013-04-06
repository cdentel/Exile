package mechanics.defenses;

import static mechanics.Attribute.CHARISMA;
import static mechanics.Attribute.CONSTITUTION;
import static mechanics.Attribute.DEXTERITY;
import static mechanics.Attribute.INTELLIGENCE;
import static mechanics.Attribute.STRENGTH;
import mechanics.Attribute;

public enum DefenseType {
  AC(DEXTERITY, INTELLIGENCE), 
  FORTITUDE(STRENGTH, CONSTITUTION), 
  REFLEX(DEXTERITY, INTELLIGENCE), 
  WILL(CHARISMA, CONSTITUTION);
  
  public final Attribute first, second;
  
  private DefenseType(Attribute first, Attribute second) {
    this.first = first;
    this.second = second; 
  }
}
