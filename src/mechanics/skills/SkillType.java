package mechanics.skills;

import static mechanics.Attribute.*;
import mechanics.Attribute;

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
  
  public final Attribute attribute;
  

  private SkillType(Attribute attribute) {
    this.attribute = attribute;
  }
}
