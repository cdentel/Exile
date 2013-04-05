package attack;

import creatures.Creature;
import equipment.weapon.Weapon;

public class MeleeBasicAttack extends Attack {
  
  protected Weapon attackingWeapon;

  public MeleeBasicAttack(Creature attacker, Creature opponent, Weapon attackingWeapon) {
    super(attacker, opponent);
    this.attackingWeapon = attackingWeapon;
  }
  

}
