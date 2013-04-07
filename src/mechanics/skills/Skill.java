package mechanics.skills;

import creatures.Creature;

public class Skill {
  
  private Creature creature;
  private SkillType type;
  
  public Skill(Creature creature, SkillType type) {
    this.creature = creature;
    this.type = type;
  }

}
