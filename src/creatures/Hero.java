package creatures;

import mechanics.Attributes;
import creatures.clazz.Clazz;

public class Hero extends Creature {
  
  public String getName() {
    return "Hero";
  }  
  public Hero(Attributes attributes, Clazz clazz) {
    super(attributes, clazz);
  }

}
