package creatures.race;

import mechanics.BonusSource;
import mechanics.modifier.ImmutableModifier;
import mechanics.skills.SkillType;
import powers.dragonborn.DragonBreathOption;

import com.google.common.collect.ImmutableSet;

import creatures.components.AttributeType;
import creatures.components.CreatureSize;
import creatures.components.Language;
import creatures.components.Vision;


// Missing DragonbornFury, DragonBreath
public class Dragonborn extends Race {
  
  private DragonBreathOption option;
  
  
  public Dragonborn(DragonBreathOption option) {
    super();
    this.option = option;

  }

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
  public ImmutableModifier<AttributeType, Integer> getAbilityScoreModifier() {
    return ImmutableModifier.of(BonusSource.RACE, AttributeType.STRENGTH, 2).and(AttributeType.CHARISMA, 2);
  }

  @Override
  public ImmutableSet<Language> getLanguages() {
    return ImmutableSet.of(Language.COMMON, Language.DRACONIC);
  }
  
  @Override
  public ImmutableModifier<SkillType, Integer> getSkillModifiers() {
    return ImmutableModifier.of(BonusSource.RACE, SkillType.HISTORY, 2).and(SkillType.INTIMIDATE, 2);
  }

}
