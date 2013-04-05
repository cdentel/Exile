package creatures;

import mechanics.Attributes;
import creatures.clazz.Clazz;
import equipment.Equipment;

public class Hero extends Creature {
  
  public String getName() {
    return "Hero";
  }  
  public Hero(Attributes attributes, Equipment equipment, Clazz clazz) {
    super(attributes, equipment, clazz);
  }

}
