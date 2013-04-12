package mechanics.skills;

import creatures.Creature;

public class Skill {
  
  private Creature creature;
  private SkillType type;
  
  private boolean trained;
  
  public Skill(Creature creature, SkillType type, boolean trained) {
    this.creature = creature;
    this.type = type;
    this.trained = trained;
  }
  
  public int getScore() {
    return 
          getTrained()
        + getModifierPlusHalfLevel()
        + getArmorPenalty()
        + getRaceModifier();
  }
  
  public int getTrained() {
    return isTrained() ? 5 : 0;
  }
  
  public boolean isTrained() {
    return trained;
  }
  
  public int getModifierPlusHalfLevel() {
    return creature.attributes().get(type.attribute).getModifierPlusHalfLevel();
  }
  
  public int getArmorPenalty() {
    return creature.equipment().getMovementModifer();
  }
  
  public int getRaceModifier() {
    return creature.getRace().getSkillModifiers().get(type);
  }

}
