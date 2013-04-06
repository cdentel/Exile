package creatures.clazz;

import static equipment.wearable.ArmorType.*;
import static equipment.WeaponType.*;
import java.util.Set;

import mechanics.defenses.DefenseModifier;
import mechanics.defenses.DefenseType;

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
  public int getBaseHitPointsForLevel(int level) {
    return 15 + 6 * level;
  }
  
  @Override
  public int getFortitudeBonus() {
    return 2;
  }

  @Override
  public DefenseModifier getDefenseModifier() {
    return DefenseModifier.of(DefenseType.FORTITUDE, 2);
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

}
