package creatures.clazz;

import java.util.Set;

import mechanics.BonusSource;
import mechanics.defenses.DefenseType;
import mechanics.modifier.Modifier;
import mechanics.skills.SkillType;

import com.google.common.collect.ImmutableSet;

import equipment.shield.ShieldType;
import equipment.weapon.WeaponType;
import equipment.wearable.ArmorType;

public class Cleric extends Clazz {

  @Override
  public ClazzType getClassType() {
    return ClazzType.CLERIC;
  }

  @Override
  public Modifier<DefenseType, Integer> getDefenseModifier() {
    return Modifier.of(BonusSource.CLAZZ, DefenseType.WILL, 2);
  }

  @Override
  public int getHealingSurges() {
    return 9;
  }
  
  @Override
  public int getBaseHitPoints() {
    return 12;
  }

  @Override
  public int getHitPointsGainedPerLevel() {
    return 5;
  }

  @Override
  public Set<ArmorType> getArmorProficiencies() {
    return ImmutableSet.of(
        ArmorType.CLOTH,
        ArmorType.LEATHER,
        ArmorType.HIDE,
        ArmorType.CHAIN);
  }

  @Override
  public Set<ShieldType> getShieldProficiencies() {
    return ImmutableSet.of();
  }

  @Override
  public Set<WeaponType> getWeaponProficiencies() {
    return ImmutableSet.of(WeaponType.SIMPLE_MELEE, WeaponType.SIMPLE_RANGED);
  }
  
  @Override
  public Set<SkillType> getStartingSkills() {
    return ImmutableSet.of(SkillType.RELIGION);
  }

  @Override
  public Set<SkillType> getTrainableSkills() {
    return ImmutableSet.of(SkillType.ARCANA, SkillType.DIPLOMACY, SkillType.HEAL, SkillType.HISTORY, SkillType.INSIGHT);
  }
  
  @Override
  public int getNumberOfSkillChoices() {
    return 3;
  }
}
