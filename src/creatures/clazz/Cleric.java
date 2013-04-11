package creatures.clazz;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

import mechanics.Choice;
import mechanics.Modifier;
import mechanics.defenses.DefenseType;
import mechanics.skills.SkillType;
import equipment.WeaponType;
import equipment.shield.ShieldType;
import equipment.wearable.ArmorType;

public class Cleric extends Clazz {

  @Override
  public ClazzType getClassType() {
    return ClazzType.CLERIC;
  }

  @Override
  public Modifier<DefenseType> getDefenseModifier() {
    return Modifier.with(DefenseType.WILL, 2);
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
  public Choice<SkillType> getCreationSkillChoices() {
    return Choice.of(4, false, ImmutableSet.of(SkillType.RELIGION, SkillType.ARCANA, SkillType.DIPLOMACY, SkillType.HEAL, SkillType.HISTORY, SkillType.INSIGHT));
  }
}
