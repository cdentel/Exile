package creatures.components;
import static creatures.components.AttributeType.CHARISMA;
import static creatures.components.AttributeType.CONSTITUTION;
import static creatures.components.AttributeType.DEXTERITY;
import static creatures.components.AttributeType.INTELLIGENCE;
import static creatures.components.AttributeType.STRENGTH;
import static creatures.components.AttributeType.WISDOM;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Preconditions;

import creatures.Creature;


public class Attributes {

  private Map<AttributeType, Attribute> attributes;
  private Creature creature;
  
  public Attributes(Creature c) {
    attributes = new HashMap<>();
    for(AttributeType attribute : AttributeType.values()) {
      attributes.put(attribute, new Attribute(c, attribute));
    }
  }
  

  public Attribute get(AttributeType attribute) {
    Preconditions.checkNotNull(attribute);
    return attributes.get(attribute);
  }
  
  public String toString() {
    return attributes.toString();
  }

  public void set(int charisma, 
      int constitution, 
      int dexterity, 
      int intelligence, 
      int strength, 
      int wisdom) {  
    get(CHARISMA).setBase(charisma);
    get(CONSTITUTION).setBase(constitution);
    get(DEXTERITY).setBase(dexterity);
    get(INTELLIGENCE).setBase(intelligence);
    get(STRENGTH).setBase(strength);
    get(WISDOM).setBase(wisdom);
    
    
  }
  
  

}
