package mechanics.skills;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

public class StartingSkills {

  private final int numberOfSelections;
  private final ImmutableSet<SkillType> choices;
  private final ImmutableSet<SkillType> startingSkills;
  
  public StartingSkills(Set<SkillType> startingSkills, int numberOfChoices, Set<SkillType> choices) {
    this.numberOfSelections = numberOfChoices;
    this.startingSkills = ImmutableSet.copyOf(startingSkills);
    this.choices = ImmutableSet.copyOf(choices);
  }
  
  public ImmutableSet<SkillType> getChoices() {
    return choices;
  }
  
  public ImmutableSet<SkillType> getStartingSkills() {
    return startingSkills;
  }
  
  public int getNumberOfSelections() {
    return numberOfSelections;
  }
}
