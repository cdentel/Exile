package creatures.clazz;

import java.util.Set;

import mechanics.Modifier;
import mechanics.defenses.DefenseType;
import mechanics.skills.SkillType;

import com.google.common.collect.ImmutableSet;

import equipment.WeaponType;
import equipment.shield.ShieldType;
import equipment.wearable.ArmorType;

public abstract class Clazz {
  
  
  public abstract ClazzType getClassType();
  
  public abstract Modifier<DefenseType> getDefenseModifier();
  
  public abstract int getHealingSurges();
  
  public abstract int getBaseHitPoints();
  
  public abstract Set<ArmorType> getArmorProficiencies();
  
  public abstract Set<ShieldType> getShieldProficiencies();
  
  public abstract Set<WeaponType> getWeaponProficiencies();
  
  public abstract int getHitPointsGainedPerLevel();

  public int getBaseHitPointsAtLevel(int level) {
    return getHitPointsGainedPerLevel() * (level -1) + getBaseHitPoints();
  }
  
  public Set<SkillType> getStartingSkills() {
    return ImmutableSet.of();
  }
  
  public abstract Set<SkillType> getTrainableSkills();
  
  public abstract int getNumberOfSkillChoices();
  

}
