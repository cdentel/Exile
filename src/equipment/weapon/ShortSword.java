package equipment.weapon;

import static mechanics.Die.d6;
import mechanics.Attribute;
import mechanics.Damage;
import mechanics.Dice;
import mechanics.defenses.DefenseType;

import com.google.common.collect.ImmutableSet;

import equipment.WeaponType;

public class ShortSword extends Weapon {

  @Override
  public int getWeight() {
    return 2;
  }

  @Override
  public Damage getDamage() {
    return new Damage(Dice.with(d6));
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
    return ImmutableSet.of(WeaponGroup.LIGHT_BLADE);
  }

}
