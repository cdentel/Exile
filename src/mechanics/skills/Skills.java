package mechanics.skills;

import mechanics.modifier.Modifiable;
import mechanics.modifier.ModifierType;
import mechanics.modifier.numeric.IntegerNumeric;

public class Skills extends Modifiable<SkillType, Integer> {
  
  public Skills() {
    super(IntegerNumeric.INSTANCE());
    // TODO Auto-generated constructor stub
  }

  public boolean isTrainedIn(SkillType skill) {
    return collection.getTypeTotal(skill, ModifierType.TRAINED) > 0;
  }

}
