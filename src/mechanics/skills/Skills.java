package mechanics.skills;

import mechanics.BonusSource;
import mechanics.modifier.Modifiable;
import mechanics.modifier.Modifier;
import mechanics.modifier.numeric.IntegerNumeric;

public class Skills extends Modifiable<SkillType, Integer> {
  
  public Skills() {
    super(IntegerNumeric.INSTANCE());
    // TODO Auto-generated constructor stub
  }

  public boolean isTrainedIn(SkillType skill) {
    return collection.getTypeTotal(skill, BonusSource.TRAINED) > 0;
  }

  public void train(SkillType st) {
    add(Modifier.of(BonusSource.TRAINED, st, 5));
  }
  
  public void untrain(SkillType st) {
    remove(Modifier.of(BonusSource.TRAINED, st, 5));
  }

}
