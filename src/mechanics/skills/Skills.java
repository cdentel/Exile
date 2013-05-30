package mechanics.skills;

import java.util.Set;

import mechanics.BonusSource;
import mechanics.modifier.Modifiable;
import mechanics.modifier.Modifier;
import mechanics.modifier.numeric.IntegerNumeric;

import com.google.common.collect.Sets;

public class Skills extends Modifiable<SkillType, Integer> {
  
  public Set<SkillType> trainableSkills = Sets.newTreeSet();
  public int bonusSkillChoices = 0;
  public int classSkillChoices = 0;
  
  public Skills() {
    super(IntegerNumeric.INSTANCE());
  }

  public boolean isTrainedIn(SkillType skill) {
    return collection.getTypeTotal(skill, BonusSource.TRAINED) > 0;
  }

  public void train(SkillType st) {
    if(!trainableSkills.contains(st) && bonusSkillChoices > 0) {
      bonusSkillChoices--;
    } else if(trainableSkills.contains(st) && bonusSkillChoices > 0 || classSkillChoices > 0) {
      if (classSkillChoices > 0) 
        classSkillChoices--; 
      else 
        bonusSkillChoices--;
    } else {
      throw new IllegalArgumentException("This skill cannot be trained at this time");
    }
    addTrainedBonus(st);
  }

  public void addClassSkillChoices(int classSkillChoices) {
    this.classSkillChoices += classSkillChoices;
  }

  public void setTrainableSkills(Set<SkillType> trainableSkills) {
    this.trainableSkills = trainableSkills;
  }

  public void addBonusSkillChoices(int bonusSkillChoices) {
    this.bonusSkillChoices += bonusSkillChoices;
  }

  public void setStartingSkills(Set<SkillType> startingSkills) {
    for(SkillType st : startingSkills) {
      addTrainedBonus(st);
    }
  }
  
  private void addTrainedBonus(SkillType skill) {
    add(Modifier.of(BonusSource.TRAINED, skill, 5));
  }

}
