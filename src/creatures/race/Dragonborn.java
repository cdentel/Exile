package creatures.race;

import mechanics.modifier.Modifier;
import mechanics.modifier.ModifierType;
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
  public Modifier<AttributeType, Integer> getAbilityScoreModifier() {
    return Modifier.of(ModifierType.RACE, AttributeType.STRENGTH, 2).and(AttributeType.CHARISMA, 2);
  }

  @Override
  public ImmutableSet<Language> getLanguages() {
    return ImmutableSet.of(Language.COMMON, Language.DRACONIC);
  }
  
  @Override
  public boolean hasDraconicHeritage() {
    return true;
  }
  
  @Override
  public Modifier<SkillType, Integer> getSkillModifiers() {
    return Modifier.of(ModifierType.RACE, SkillType.HISTORY, 2).and(SkillType.INTIMIDATE, 2);
  }

}
