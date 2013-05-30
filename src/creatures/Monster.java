package creatures;

import creatures.clazz.Clazz;
import creatures.race.Race;

public class Monster extends Creature {
  
  public String getName() {
    return "monster";
  }

  
  public Monster(Race race, Clazz clazz) {
    super(race, clazz);
  }
  

}
