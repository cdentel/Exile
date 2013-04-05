package equipment.weapon;

import static mechanics.Die.d6;
import mechanics.Attribute;
import mechanics.Damage;
import mechanics.Dice;
import mechanics.defenses.DefenseType;

public class Sword extends Weapon {

  @Override
  public double getWeight() {
    return 5;
  }

  @Override
  public Damage getDamage() {
    return new Damage(2, Dice.with(d6));
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

}
