package equipment.weapon;

import static mechanics.Die.d4;
import static mechanics.Die.d6;
import mechanics.Attribute;
import mechanics.Damage;
import mechanics.Dice;
import mechanics.defenses.DefenseType;

public enum WeaponType {
  
  SWORD(  2, 5, new Damage(2, Dice.with(d6)),      Attribute.STRENGTH,  DefenseType.AC),
  DAGGER( 2, 2, new Damage(1, Dice.with(d4, d4)),  Attribute.DEXTERITY, DefenseType.AC);
  
  public final int attackRollModifer;
  public final int weight;
  public final Damage damage;
  public final Attribute attribute;
  public final DefenseType versus;
  
  private WeaponType(int attackRollModifer, int weight, Damage damage, Attribute attribute, DefenseType versus) {
    this.attackRollModifer = attackRollModifer;
    this.weight = weight;
    this.damage = damage;
    this.attribute = attribute;
    this.versus = versus;
  }
  
}
