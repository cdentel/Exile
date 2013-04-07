package equipment.weapon;

import mechanics.Attribute;
import mechanics.Damage;
import mechanics.defenses.DefenseType;

import com.google.common.collect.ImmutableSet;

import equipment.Implement;
import equipment.WeaponType;

public abstract class Weapon extends Implement {
  
  public abstract Damage getDamage();
  
  public abstract int getAttackRollModifier();
  
  public abstract Attribute getAttributeUsed();
  
  public abstract DefenseType getDefenseType();

  public abstract WeaponType getWeaponType();

  public abstract ImmutableSet<WeaponGroup> getWeaponGroup();
}
