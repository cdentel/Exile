package creatures;

import mechanics.Attributes;
import creatures.clazz.Clazz;

public class Goblin extends Creature {
  
  public String getName() {
    return "Goblin";
  }

  
  public Goblin(Attributes attributes, Clazz clazz) {
    super(attributes, clazz);
  }
  

}
