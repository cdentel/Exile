package creatures.race;

import mechanics.BonusSource;
import mechanics.defenses.DefenseType;
import mechanics.modifier.ImmutableModifier;
import mechanics.skills.SkillType;

import com.google.common.collect.ImmutableSet;

import creatures.Creature;
import creatures.components.AttributeType;
import creatures.components.BurdenType;
import creatures.components.CreatureSize;
import creatures.components.Language;
import creatures.components.Vision;

public abstract class Race {
  
  public abstract RaceType getRaceType();
  
  public abstract Vision getVision();
  
  public abstract CreatureSize getSize();
  
  public abstract int getSpeed();
  
  public abstract ImmutableModifier<AttributeType, Integer> getAbilityScoreModifier();
  
  public ImmutableModifier<DefenseType, Integer> getDefenseModifier() {
    return ImmutableModifier.none(BonusSource.RACE);
  }
    
  public ImmutableModifier<SkillType, Integer> getSkillModifiers() {
    return ImmutableModifier.none(BonusSource.RACE);
  }
  
  public int getCreationClassSkillChoices() {
    return 0;
  }
  
  public int getCreationExtraFeatChoices() {
    return 0;
  }
  
  public int getCreationExtraAtWillPowerChoices() {
    return 0;
  }
  
  public abstract ImmutableSet<Language> getLanguages();
  
  public int getCreationBonusSkillChoices() {
    return 0;
  }
  
  public void applyRaceBonuses(Creature c) {
    c.vision().add(getVision(), BonusSource.RACE);
    c.burden().add(ImmutableModifier.of(BonusSource.RACE, BurdenType.MOVEMENT, getSpeed()));
    c.attributes().add(getAbilityScoreModifier());
    c.defenses().add(getDefenseModifier());
    c.getSkills().add(getSkillModifiers());
    c.getSkills().addClassSkillChoices(getCreationClassSkillChoices());
    c.getSkills().addBonusSkillChoices(getCreationBonusSkillChoices());
    c.languages().addAll(getLanguages(), BonusSource.RACE);
  }
}
