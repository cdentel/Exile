package creatures.race;

import mechanics.Choice;
import mechanics.Modifier;
import mechanics.skills.SkillType;
import creatures.components.AttributeType;
import creatures.components.CreatureSize;
import creatures.components.Language;
import creatures.components.Vision;

public class Dragonborn extends Race {

  @Override
  public RaceType getRaceType() {
    return RaceType.DRAGONBORN;
  }

  @Override
  public Vision getVision() {
    return Vision.NORMAL;
  }

  @Override
  public CreatureSize getSize() {
    return CreatureSize.MEDIUM;
  }

  @Override
  public int getSpeed() {
    return 6;
  }
  
  @Override
  public Modifier<AttributeType> getAbilityScoreModifier() {
    return Modifier.with(AttributeType.STRENGTH, 2).and(AttributeType.CHARISMA, 2);
  }

  @Override
  public Choice<Language> getCreationLanguageChoice() {
    Choice<Language> choice = Choice.of(2, false, Language.values());
    choice.choose(Language.COMMON);
    choice.choose(Language.DRACONIC);
    return choice;
  }
  
  @Override
  public boolean hasDraconicHeritage() {
    return true;
  }
  
  @Override
  public Modifier<SkillType> getSkillModifiers() {
    return Modifier.with(SkillType.HISTORY, 2).and(SkillType.INTIMIDATE, 2);
  }

}
