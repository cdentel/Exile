package mechanics;
import static mechanics.Attribute.CHARISMA;
import static mechanics.Attribute.CONSTITUTION;
import static mechanics.Attribute.DEXTERITY;
import static mechanics.Attribute.INTELLIGENCE;
import static mechanics.Attribute.STRENGTH;
import static mechanics.Attribute.WISDOM;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Preconditions;


public class Attributes {

  private Map<Attribute, Integer> attributes;
  
  Attributes() {
    attributes = new HashMap<>();
    for(Attribute attribute : Attribute.values()) {
      attributes.put(attribute, 0);
    }
  }
  
  public Attributes(
      int charisma, 
      int constitution, 
      int dexterity, 
      int intelligence, 
      int strength, 
      int wisdom) {
    this();
    setAttribute(CHARISMA, charisma);
    setAttribute(CONSTITUTION, constitution);
    setAttribute(DEXTERITY, dexterity);
    setAttribute(INTELLIGENCE, intelligence);
    setAttribute(STRENGTH, strength);
    setAttribute(WISDOM, wisdom);
  }
  
  public void setAttribute(Attribute attribute, Integer value) {
    Preconditions.checkNotNull(attribute);
    Preconditions.checkNotNull(value);
    attributes.put(attribute, value);
  }
  
  public int getAttribute(Attribute attribute) {
    Preconditions.checkNotNull(attribute);
    return attributes.get(attribute);
  }
  
  public int getModifier(Attribute attribute) {
    return getAttribute(attribute) / 2 - 5;
  }
  
  public int getCharisma() {
    return getAttribute(CHARISMA);
  }
  
  public int getConstitution() {
    return getAttribute(CONSTITUTION);
  }
  
  public int getDexterity() {
    return getAttribute(DEXTERITY);
  }
  public int getIntelligence() {
    return getAttribute(INTELLIGENCE);
  }
  
  public int getStrength() {
    return getAttribute(STRENGTH);
  }
  
  public int getWisdom() {
    return getAttribute(WISDOM);
  }
  
  public String toString() {
    return attributes.toString();
  }
  
  

}
