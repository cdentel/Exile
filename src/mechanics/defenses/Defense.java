package mechanics.defenses;

import creatures.Creature;

public abstract class Defense {
  
  protected Creature creature;
  
  public Defense(Creature c) {
    this.creature = c;
  }
  
    
  public abstract int getAbility();
  
  public int getHalfLevel() {
    return creature.getLevel()/2;
  }
  
  public abstract int getClassBonus();
  
  public int getScore() {
    return getBase() + getAbility() + getHalfLevel() + getClassBonus();
  }
  
  public int getBase() {
    return 10;
  }
  
  @Override
  public String toString() {
    return String.format(
        "Total:         %d\n" + 
        " -- Base:      %d\n" +
        " -- 1/2 level: %d\n" +
        " -- Class:     %d\n" +
        " -- Ability:   %d\n",
        getScore(),
        getBase(),
        getHalfLevel(),
        getClassBonus(),
        getAbility());
        
  }


}
