package creatures;

import creatures.clazz.Clazz;
import creatures.race.Human;

public class Goblin extends Creature {
  
  public String getName() {
    return "Goblin";
  }

  
  public Goblin(Clazz clazz) {
    super(new Human(), clazz);
  }
  

}
