package creatures.clazz;

import static equipment.WeaponType.MILITARY_MELEE;
import static equipment.WeaponType.MILITARY_RANGED;
import static equipment.WeaponType.SIMPLE_MELEE;
import static equipment.WeaponType.SIMPLE_RANGED;
import static equipment.wearable.ArmorType.CHAIN;
import static equipment.wearable.ArmorType.CLOTH;
import static equipment.wearable.ArmorType.HIDE;
import static equipment.wearable.ArmorType.LEATHER;
import static equipment.wearable.ArmorType.SCALE;
import static mechanics.skills.SkillType.ATHLETICS;
import static mechanics.skills.SkillType.ENDURANCE;
import static mechanics.skills.SkillType.HEAL;
import static mechanics.skills.SkillType.INTIMIDATE;
import static mechanics.skills.SkillType.STREETWISE;

import java.util.Set;

import mechanics.defenses.DefenseType;
import mechanics.modifier.Modifier;
import mechanics.modifier.ModifierType;
import mechanics.skills.SkillType;

import com.google.common.collect.ImmutableSet;

import equipment.WeaponType;
import equipment.shield.ShieldType;
import equipment.wearable.ArmorType;

public class Fighter extends Clazz {

  @Override
  public int getHealingSurges() {
    return 9;
  }

  @Override
  public int getBaseHitPoints() {
    return 15;
  }
  
  @Override 
  public int getHitPointsGainedPerLevel() {
    return 6;
  }
  

  @Override
  public Modifier<DefenseType> getDefenseModifier() {
    return Modifier.of(ModifierType.CLAZZ, DefenseType.FORTITUDE, 2);
  }

  @Override
  public Set<ArmorType> getArmorProficiencies() {
    // TODO Auto-generated method stub
    return ImmutableSet.of(CLOTH, LEATHER, HIDE, CHAIN, SCALE);
  }

  @Override
  public Set<ShieldType> getShieldProficiencies() {
    return ImmutableSet.of(ShieldType.LIGHT, ShieldType.HEAVY);
  }

  @Override
  public Set<WeaponType> getWeaponProficiencies() {
    return ImmutableSet.of(
        SIMPLE_MELEE, 
        SIMPLE_RANGED, 
        MILITARY_MELEE, 
        MILITARY_RANGED);
  }

  @Override
  public Set<SkillType> getTrainableSkills() {
    return ImmutableSet.of(ATHLETICS, ENDURANCE, HEAL, INTIMIDATE, STREETWISE);
  }
  
  @Override
  public int getNumberOfSkillChoices() {
    return 3;
  }

  @Override
  public ClazzType getClassType() {
    return ClazzType.FIGHTER;
  }
}
