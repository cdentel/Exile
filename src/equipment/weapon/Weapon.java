package equipment.weapon;

import mechanics.Attribute;
import mechanics.Damage;
import equipment.Implement;

public class Weapon extends Implement {

  private WeaponType type;
  
  public Weapon(WeaponType type) {
    this.type = type;
  }
  
  @Override
  public double getWeight() {
    return type.weight;
  }
  
  public Damage getDamage() {
    return type.damage;
  }
  
  public int getAttackRollModifier() {
    return type.attackRollModifer;
  }
  
  public Attribute getAttributeUsed() {
    return type.attribute;
  }
  
  @Override
  public ImplementType getImplementType() {
    return ImplementType.WEAPON;
  }

}
