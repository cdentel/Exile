package mechanics.defenses;

import creatures.Creature;
import equipment.wearable.WearableMaterialType.ArmorWeight;

public class Defense {
  
  protected Creature creature;
  protected DefenseType type;
  
  public Defense(Creature c, DefenseType type) {
    this.creature = c;
    this.type = type;
  }
  
    
  public int getAbility() {
    if (!type.equals(DefenseType.AC) || 
        !creature.equipment().getTorso().isPresent() || 
        creature.equipment().getTorso().get().getMaterialType().armorWeight.equals(ArmorWeight.LIGHT)) {
      return Math.max(
          creature.attributes().getModifier(type.first),
          creature.attributes().getModifier(type.second));
    } else {
      return 0;
    }
  }
  
  public int getArmor() {
    if(type.equals(DefenseType.AC)) {
      return creature.equipment().getAmorClassModifier();
    } else {
      throw new UnsupportedOperationException("Only A Defense of type AC can have an armor modifier");
    }
  }
  
  public int getHalfLevel() {
    return creature.getLevel()/2;
  }
  
  public int getClassBonus() {
    return creature.getClazz().getDefenseModifier().get(type);
  }
  
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
