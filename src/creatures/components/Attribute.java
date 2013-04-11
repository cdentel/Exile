package creatures.components;

import creatures.Creature;

public class Attribute {
  
  private Creature creature;
  private AttributeType type;
  private int base;
  
  public Attribute(Creature c, AttributeType type) {
    this.creature = c;
    this.type = type;
  }
  
  public int getBase() {
    return base;
  }
  
  public void setBase(int amount) {
    base = amount;
  }
  
  public int getScore() {
    return getBase() + getRaceModifier();
  }
  
  public int getModifier() {
    return getScore() / 2 - 5;
  }
  
  public int getModifierPlusHalfLevel() {
    return getModifier() + creature.getLevel() / 2;
  }
  
  public int getRaceModifier() {
    return 
          creature.getRace().getAbilityScoreModifier().get(type) + 
        + creature.getRace().getAbilityScoreModifierChoice().modifier().get(type);
  }

}
