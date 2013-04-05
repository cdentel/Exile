package equipment.weapon;

import mechanics.Attribute;
import mechanics.Damage;
import mechanics.defenses.DefenseType;
import equipment.Implement;

public abstract class Weapon extends Implement {
  
  public abstract double getWeight();
  
  public abstract Damage getDamage();
  
  public abstract int getAttackRollModifier();
  
  public abstract Attribute getAttributeUsed();
  
  public abstract DefenseType getDefenseType();

}
