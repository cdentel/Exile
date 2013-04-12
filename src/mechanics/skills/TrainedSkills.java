package mechanics.skills;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import creatures.clazz.Clazz;
import creatures.race.Race;

public final class TrainedSkills {
  
  private final ImmutableSet<SkillType> skills;

  private TrainedSkills(Set<SkillType> skills) {
    this.skills = ImmutableSet.copyOf(skills);
  }
  
  public ImmutableSet<SkillType> getTrainedSkills() {
    return skills;
  }
  
  public static TrainedSkillBuilder getTrainedSkillBuilderFor(Race race, Clazz clazz) {
    return new TrainedSkillBuilder(race, clazz);
  }
  
  public final static class TrainedSkillBuilder {
    
    private Race race;
    private Clazz clazz;
    
    private final Set<SkillType> clazzSelections = new TreeSet<SkillType>();
    private final Set<SkillType> bonusSelections = new TreeSet<SkillType>();
        
    private TrainedSkillBuilder(Race race, Clazz clazz) {
      this.race = race;
      this.clazz = clazz;
    }
    
    public ImmutableSet<SkillType> getSkillsGrantedWithClass() {
      return ImmutableSet.copyOf(clazz.getStartingSkills());
    }
    
    public ImmutableSet<SkillType> getSkillsChosen() {
      return ImmutableSet.<SkillType>builder().addAll(clazzSelections).addAll(bonusSelections).build();
    }
    
    public ImmutableSet<SkillType> getSkillsChosenAndGranted() {
      return ImmutableSet.copyOf(Sets.union(getSkillsChosen(), getSkillsGrantedWithClass()));
    }
    
    public ImmutableSet<SkillType> getClazzSkillsChosen() {
      return ImmutableSet.copyOf(clazzSelections);
    }
    
    public ImmutableSet<SkillType> getBonusSkillsChosen() {
      return ImmutableSet.copyOf(bonusSelections);
    }
    
    public int numberOfClassSelectionsRemaining() {
      return clazz.getNumberOfSkillChoices() + race.getCreationClassSkillChoices() - clazzSelections.size();
    }
    
    public int numberOfBonusSkillSelectionsRemaining() {
      return race.getCreationBonusSkillChoices() - bonusSelections.size();
    }
    
    public ImmutableSet<SkillType> getRemainingClassChoices() {
      return ImmutableSet.copyOf(Sets.difference(clazz.getTrainableSkills(), clazzSelections));
    }
    
    public ImmutableSet<SkillType> getRemainingBonusChoices() {
      return ImmutableSet.copyOf(Sets.difference(Sets.newTreeSet(Arrays.asList(SkillType.values())), getSkillsChosenAndGranted()));
    }
    
    public boolean canChooseBonusSkill(SkillType skill) {
      return !getSkillsChosenAndGranted().contains(skill) && numberOfBonusSkillSelectionsRemaining() > 0;
    }
    
    public boolean canChooseClazzSkill(SkillType skill) {
      return !clazzSelections.contains(skill) && 
          clazz.getTrainableSkills().contains(skill) &&
          numberOfClassSelectionsRemaining() > 0;
    }
    
    public TrainedSkillBuilder chooseClazzSkill(SkillType skill) {
      if(!canChooseClazzSkill(skill)) {
        throw new IllegalArgumentException();
      } else {
        clazzSelections.add(skill);
      }
      return this;
    }
    
    public TrainedSkillBuilder chooseBonusSkill(SkillType skill) {
      if(!canChooseBonusSkill(skill)) {
        throw new IllegalArgumentException();
      } else {
        bonusSelections.add(skill);
      }
      return this;
    }
    
    public boolean canBuild() {
      return numberOfBonusSkillSelectionsRemaining() == 0 &&
          numberOfClassSelectionsRemaining() == 0;
    }
    
    public TrainedSkills build() {
      if(!canBuild()) {
        throw new IllegalStateException();
      } else {
        return new TrainedSkills(getSkillsChosenAndGranted());
      }
      
    }
    
  }
}
