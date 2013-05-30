package creatures;

import creatures.clazz.Clazz;
import creatures.race.Race;

public class Hero extends Creature {
  
  public String getName() {
    return "Hero";
  }  
  public Hero(Race race, Clazz clazz) {
    super(race, clazz);
  }

}
