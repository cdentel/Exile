package equipment.weapon;

import static mechanics.dice.Die.d4;
import mechanics.BonusSource;
import mechanics.Damage;
import mechanics.defenses.DefenseType;
import mechanics.dice.Dice;
import mechanics.modifier.ImmutableModifier;

import com.google.common.collect.ImmutableSet;

import creatures.components.AttributeType;
import creatures.components.BurdenType;

public class Dagger extends Weapon {

  @Override
  public Damage getDamage() {
    return Damage.basic(Dice.with(d4));
  }

  @Override
  public int getAttackRollModifier() {
    return 2;
  }

  @Override
  public AttributeType getAttributeUsed() {
    return AttributeType.DEXTERITY;
  }

  @Override
  public DefenseType getDefenseType() {
    return DefenseType.AC;
  }

  @Override
  public WeaponType getWeaponType() {
    return WeaponType.SIMPLE_MELEE;
  }

  @Override
  public ImmutableSet<WeaponGroup> getWeaponGroup() {
    return ImmutableSet.of(WeaponGroup.LIGHT_BLADE);
  }

  @Override
  public ImmutableModifier<BurdenType, Integer> getBurdenModifier() {
    return ImmutableModifier.of(BonusSource.WEAPON, BurdenType.WEIGHT, 1);
  }
}
