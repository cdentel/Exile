package attack;

import mechanics.Damage;
import mechanics.defenses.DefenseType;
import creatures.components.AttributeType;

public interface DamageDealing {
  
  public abstract Damage getDamage();
  
  public abstract int getAttackRollModifier();
  
  public abstract AttributeType getAttributeUsed();
  
  public abstract DefenseType getDefenseType();

}
