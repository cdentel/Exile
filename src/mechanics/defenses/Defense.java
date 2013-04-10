package mechanics.defenses;

import creatures.Creature;
import equipment.wearable.ArmorType.ArmorWeight;

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
        creature.equipment().getTorso().get().getArmorType().armorWeight.equals(ArmorWeight.LIGHT)) {
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
    int sum = getBase() + getAbility() + getHalfLevel() + getClassBonus();
    if(type.equals(DefenseType.AC)) {
      return sum + getArmor();
    } else {
      return sum;
    }
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
        " -- Ability:   %d\n" +
        " -- Armor:     %d\n",    
        getScore(),
        getBase(),
        getHalfLevel(),
        getClassBonus(),
        getAbility(),
        type.equals(DefenseType.AC) ? getArmor() : 0);
        
  }


}
