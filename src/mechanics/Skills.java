package mechanics;

import java.util.Map;
import java.util.TreeMap;

import creatures.Creature;

public class Skills {
  
  private Creature creature;
  private Map<SkillType, Skill> skills;
  
  public Skills(Creature creature) {
    this.creature = creature;
    skills = new TreeMap<>();
    for(SkillType type : SkillType.values()) {
      skills.put(type, new Skill(creature, type));
    }
  }
  
  public Skill getSkill(SkillType type) {
    return skills.get(type);
  }

}
