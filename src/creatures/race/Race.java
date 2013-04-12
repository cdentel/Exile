package creatures.race;

import com.google.common.collect.ImmutableSet;

import mechanics.Choice;
import mechanics.Modifier;
import mechanics.ModifierChoice;
import mechanics.defenses.DefenseType;
import mechanics.skills.SkillType;
import creatures.components.AttributeType;
import creatures.components.CreatureSize;
import creatures.components.Language;
import creatures.components.Vision;

public abstract class Race {
  
  public abstract RaceType getRaceType();
  
  public abstract Vision getVision();
  
  public abstract CreatureSize getSize();
  
  public abstract int getSpeed();
  
  public abstract Modifier<AttributeType> getAbilityScoreModifier();
  
  public Modifier<DefenseType> getDefenseModifier() {
    return Modifier.none();
  }
    
  public Modifier<SkillType> getSkillModifiers() {
    return Modifier.none();
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
