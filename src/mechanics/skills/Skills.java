package mechanics.skills;

import mechanics.modifier.Modifiable;
import mechanics.modifier.ModifierType;

public class Skills extends Modifiable<SkillType> {
  
  public boolean isTrainedIn(SkillType skill) {
    return collection.getTypeTotal(skill, ModifierType.TRAINED) > 0;
  }

}
