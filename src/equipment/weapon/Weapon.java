package equipment.weapon;

import mechanics.Damage;
import mechanics.defenses.DefenseType;
import attack.DamageDealing;

import com.google.common.collect.ImmutableSet;

import creatures.Creature;
import creatures.components.AttributeType;
import equipment.EquipmentType;
import equipment.Equippable;

public abstract class Weapon implements Equippable, DamageDealing {
  
  public abstract Damage getDamage();
  
  public abstract int getAttackRollModifier();
  
  public abstract AttributeType getAttributeUsed();
  
  public abstract DefenseType getDefenseType();

  public abstract WeaponType getWeaponType();

  public abstract ImmutableSet<WeaponGroup> getWeaponGroup();

  @Override
  public EquipmentType getEquipmentType() {
    return EquipmentType.WEAPON;
  }

  @Override
  public void onEquip(Creature c) {
    
  }

  @Override
  public void onUnequip(Creature c) {
    
  }

  @Override
  public boolean canBeEquippedBy(Creature c) {
    return c.getWeaponProficiencies().contains(getWeaponType());
  }
  
}
