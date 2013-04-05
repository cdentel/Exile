package equipment.weapon;

import static mechanics.Die.d4;
import mechanics.Attribute;
import mechanics.Damage;
import mechanics.Dice;
import mechanics.defenses.DefenseType;

public class Dagger extends Weapon {

  @Override
  public double getWeight() {
    return 2;
  }

  @Override
  public Damage getDamage() {
    return new Damage(1, Dice.with(d4, d4));
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

}
