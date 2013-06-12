package creatures.clazz;

import java.util.Set;

import mechanics.BonusSource;
import mechanics.defenses.DefenseType;
import mechanics.modifier.ImmutableModifier;
import mechanics.skills.SkillType;

import com.google.common.collect.ImmutableSet;

import creatures.Creature;
import creatures.components.HealthType;
import equipment.shield.ShieldType;
import equipment.weapon.WeaponType;
import equipment.wearable.ArmorType;

public abstract class Clazz {
  
  public abstract ClazzType getClassType();
  
  public abstract ImmutableModifier<DefenseType, Integer> getDefenseModifier();
  
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
  
  public void applyClazzBonuses(Creature c) {
    c.defenses().add(getDefenseModifier());
    c.health().add(ImmutableModifier.of(BonusSource.CLAZZ, HealthType.MAX_SURGES, getHealingSurges()));
    c.health().add(ImmutableModifier.of(BonusSource.CLAZZ, HealthType.MAX_HP, getBaseHitPoints()));
    c.armorProficiencies().addAll(getArmorProficiencies(), BonusSource.CLAZZ);
    c.shieldProficiencies().addAll(getShieldProficiencies(), BonusSource.CLAZZ);
    c.weaponProficiencies().addAll(getWeaponProficiencies(), BonusSource.CLAZZ);
    c.getSkills().setTrainableSkills(getTrainableSkills());
    c.getSkills().setStartingSkills(getStartingSkills());
    c.getSkills().addClassSkillChoices(getNumberOfSkillChoices());
  }
}