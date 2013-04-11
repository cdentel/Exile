package creatures.race;

import java.util.Arrays;

import mechanics.Choice;
import mechanics.Modifier;
import mechanics.ModifierChoice;
import mechanics.defenses.DefenseType;
import creatures.components.AttributeType;
import creatures.components.CreatureSize;
import creatures.components.Language;
import creatures.components.Vision;

public class Human extends Race {

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
  public Modifier<DefenseType> getDefenseModifier() {
    return Modifier
        .with(DefenseType.FORTITUDE, 1)
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
  public Choice<Language> getCreationLanguageChoice() {
    Choice<Language> lang = Choice.of(2, false, Language.values());
    lang.choose(Language.COMMON);
    return lang;
  }

  @Override
  public Modifier<AttributeType> getAbilityScoreModifier() {
    return Modifier.none();
  }
  
  @Override
  public ModifierChoice<AttributeType> getAbilityScoreModifierChoice() {
    return ModifierChoice.of(1, 2, Arrays.asList(AttributeType.values()));
  }


}
