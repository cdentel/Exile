package equipment.weapon;

import static mechanics.Die.d4;
import mechanics.Attribute;
import mechanics.Damage;
import mechanics.Dice;
import mechanics.defenses.DefenseType;

import com.google.common.collect.ImmutableSet;

import equipment.WeaponType;

public class Dagger extends Weapon {

  @Override
  public int getWeight() {
    return 1;
  }

  @Override
  public Damage getDamage() {
    return new Damage(Dice.with(d4));
  }

  @Override
  public int getAttackRollModifier() {
    return 2;
  }

  @Override
  public Attribute getAttributeUsed() {
    return Attribute.DEXTERITY;
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
