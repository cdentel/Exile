package creatures.race;

import mechanics.defenses.DefenseType;
import mechanics.modifier.Modifier;
import mechanics.modifier.ModifierType;
import mechanics.skills.SkillType;

import com.google.common.collect.ImmutableSet;

import creatures.components.AttributeType;
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
    return Modifier.none(ModifierType.RACE);
  }
    
  public Modifier<SkillType, Integer> getSkillModifiers() {
    return Modifier.none(ModifierType.RACE);
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
  
  public boolean hasDraconicHeritage() {
    return false;
  }

  public int getCreationBonusSkillChoices() {
    return 0;
  }

}
