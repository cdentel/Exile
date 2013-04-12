package mechanics.skills;

import static creatures.components.AttributeType.*;
import creatures.components.AttributeType;

public enum SkillType {
  
  ACROBATICS(DEXTERITY),
  ARCANA(INTELLIGENCE),
  ATHLETICS(STRENGTH),
  BLUFF(CHARISMA),
  DIPLOMACY(CHARISMA),
  DUNGEONEERING(WISDOM),
  ENDURANCE(CONSTITUTION),
  HEAL(WISDOM),
  HISTORY(INTELLIGENCE),
  INSIGHT(WISDOM),
  INTIMIDATE(CHARISMA),
  NATURE(WISDOM),
  PERCEPTION(WISDOM),
  RELIGION(INTELLIGENCE),
  STEALTH(DEXTERITY),
  STREETWISE(CHARISMA),
  THIEVERY(DEXTERITY);
  
  public final AttributeType attribute;
  

  private SkillType(AttributeType attribute) {
    this.attribute = attribute;
  }
  
  @Override
  public String toString() {
    return "" + name().charAt(0) + name().substring(1).toLowerCase();
  }
}
