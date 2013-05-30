package creatures.race;

import mechanics.BonusSource;
import mechanics.defenses.DefenseType;
import mechanics.modifier.Modifier;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;

import creatures.components.AttributeType;
import creatures.components.CreatureSize;
import creatures.components.Language;
import creatures.components.Vision;


// Complete
public class Human extends Race {
  
  private Modifier<AttributeType, Integer> bonusAttribute;
  private Language languageChoice;
  
  public Human(Language choice, AttributeType bonus) {
    Preconditions.checkArgument(!choice.equals(Language.COMMON));
    this.languageChoice = choice;
    this.bonusAttribute = Modifier.of(BonusSource.RACE, bonus, 2);
  }

  @Override
  public Vision getVision() {
    return Vision.NORMAL;
  }

  @Override
  public CreatureSize getSize() {
    return CreatureSize.SMALL;
  }

  @Override
  public int getSpeed() {
    return 6;
  }

  @Override
  public Modifier<DefenseType, Integer> getDefenseModifier() {
    return Modifier
        .of(BonusSource.RACE, DefenseType.FORTITUDE, 1)
        .and(DefenseType.REFLEX, 1)
        .and(DefenseType.WILL, 1);
  }
  
  @Override
  public int getCreationClassSkillChoices() {
    return 1;
  }
  
  @Override
  public int getCreationExtraFeatChoices() {
    return 1;
  }
  
  @Override
  public int getCreationExtraAtWillPowerChoices() {
    return 1;
  }

  @Override
  public RaceType getRaceType() {
    return RaceType.HUMAN;
  }
  
  @Override
  public ImmutableSet<Language> getLanguages() {
    
    return ImmutableSet.of(languageChoice, Language.COMMON);
  }

  @Override
  public Modifier<AttributeType, Integer> getAbilityScoreModifier() {
    return bonusAttribute;
  }
}
