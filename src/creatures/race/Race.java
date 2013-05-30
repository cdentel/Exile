package creatures.race;

import mechanics.BonusSource;
import mechanics.defenses.DefenseType;
import mechanics.modifier.Modifier;
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
  
  public abstract Modifier<AttributeType, Integer> getAbilityScoreModifier();
  
  public Modifier<DefenseType, Integer> getDefenseModifier() {
    return Modifier.none(BonusSource.RACE);
  }
    
  public Modifier<SkillType, Integer> getSkillModifiers() {
    return Modifier.none(BonusSource.RACE);
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
    c.burden().add(Modifier.of(BonusSource.RACE, BurdenType.MOVEMENT, getSpeed()));
    c.attributes().add(getAbilityScoreModifier());
    c.defenses().add(getDefenseModifier());
    c.getSkills().add(getSkillModifiers());
    c.languages().addAll(getLanguages(), BonusSource.RACE);
  }
  
  public void removeRaceBonuses(Creature c) {
    c.vision().remove(getVision(), BonusSource.RACE);
    c.burden().remove(Modifier.of(BonusSource.RACE, BurdenType.MOVEMENT, getSpeed()));
    c.attributes().remove(getAbilityScoreModifier());
    c.defenses().remove(getDefenseModifier());
    c.getSkills().remove(getSkillModifiers());
    c.languages().removeAll(getLanguages(), BonusSource.RACE);
  }

}
