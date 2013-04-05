package creatures;

import mechanics.Attributes;
import creatures.clazz.Clazz;
import equipment.Equipment;

public class Goblin extends Creature {
  
  public String getName() {
    return "Goblin";
  }

  
  public Goblin(Attributes attributes, Equipment equipment, Clazz clazz) {
    super(attributes, equipment, clazz);
  }
  

}
