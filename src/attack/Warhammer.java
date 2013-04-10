package attack;

import mechanics.Attribute;
import mechanics.Damage;
import mechanics.Dice;
import mechanics.Die;
import mechanics.defenses.DefenseType;

import com.google.common.collect.ImmutableSet;

import equipment.WeaponType;
import equipment.weapon.Weapon;
import equipment.weapon.WeaponGroup;

public class Warhammer extends Weapon {

  @Override
  public int getWeight() {
    return 5;
  }

  @Override
  public Damage getDamage() {
    return new Damage(Dice.with(Die.d10));
  }

  @Override
  public int getAttackRollModifier() {
    return 2;
  }

  @Override
  public Attribute getAttributeUsed() {
    return Attribute.STRENGTH;
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
    return ImmutableSet.of(WeaponGroup.HAMMER);
  }

}
