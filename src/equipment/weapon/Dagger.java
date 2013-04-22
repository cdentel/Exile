package equipment.weapon;

import static mechanics.dice.Die.d4;
import mechanics.Damage;
import mechanics.defenses.DefenseType;
import mechanics.dice.Dice;

import com.google.common.collect.ImmutableSet;

import creatures.components.AttributeType;

import equipment.WeaponType;

public class Dagger extends Weapon {

  @Override
  public int getWeight() {
    return 1;
  }

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

}
