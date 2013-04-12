package creatures;

import mechanics.skills.TrainedSkills;
import creatures.clazz.Clazz;
import creatures.race.Race;

public class Monster extends Creature {
  
  public String getName() {
    return "monster";
  }

  
  public Monster(Race race, Clazz clazz, TrainedSkills skills) {
    super(race, clazz, skills);
  }
  

}
