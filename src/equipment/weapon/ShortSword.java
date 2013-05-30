package equipment.weapon;

import static mechanics.dice.Die.*;
import mechanics.Damage;
import mechanics.BonusSource;
import mechanics.defenses.DefenseType;
import mechanics.dice.Dice;
import mechanics.modifier.Modifier;

import com.google.common.collect.ImmutableSet;

import creatures.components.AttributeType;
import creatures.components.BurdenType;


public class ShortSword extends Weapon {

  @Override
  public Modifier<BurdenType, Integer> getBurdenModifier() {
    return Modifier.of(BonusSource.WEAPON, BurdenType.WEIGHT, 2);
  }

  @Override
  public Damage getDamage() {
    return Damage.basic(Dice.with(d6));
  }

  @Override
  public int getAttackRollModifier() {
    return 2;
  }

  @Override
  public AttributeType getAttributeUsed() {
    return AttributeType.STRENGTH;
  }

  @Override
  public DefenseType getDefenseType() {
    return DefenseType.AC;
  }
  
  @Override
  public WeaponType getWeaponType() {
    return WeaponType.MILITARY_MELEE;
  }
  
  @Override
  public ImmutableSet<WeaponGroup> getWeaponGroup() {
    return ImmutableSet.of(WeaponGroup.LIGHT_BLADE);
  }

}
