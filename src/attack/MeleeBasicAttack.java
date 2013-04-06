package attack;

import mechanics.Damage;
import mechanics.defenses.Defense;
import creatures.Creature;
import equipment.weapon.Weapon;

public class MeleeBasicAttack extends Attack {
  
  protected Weapon attackingWeapon;

  public MeleeBasicAttack(Creature attacker, Creature opponent, Weapon attackingWeapon) {
    super(attacker, opponent);
    this.attackingWeapon = attackingWeapon;
  }

  @Override
  public int getAttackModifier() {
    return
          // Weapon Modifier
          attackingWeapon.getAttackRollModifier()
          // The relevant attribute modifier
        + attacker.attributes().getModifier(attackingWeapon.getAttributeUsed());
  }

  @Override
  public Damage getDamage() {
    return attackingWeapon.getDamage();
  }

  @Override
  public Defense getDefense() {
    return opponent.defenses().getDefense(attackingWeapon.getDefenseType());
  }
  

}
