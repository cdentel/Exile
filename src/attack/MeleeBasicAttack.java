package attack;

import mechanics.Damage;
import creatures.Creature;
import equipment.weapon.Weapon;

public class MeleeBasicAttack extends Attack {
  
  public MeleeBasicAttack(Creature attacker, Creature opponent, Weapon attackingWeapon) {
    super(attacker, opponent, attackingWeapon);
  }

  @Override
  public int getAttackModifier() {
    return
          // Weapon Modifier
          damager.getAttackRollModifier()
          // The relevant attribute modifier
        + attacker.attributes().getModifier(damager.getAttributeUsed());
  }

  @Override
  public Damage getDamage() {
    return damager.getDamage();
  }

  @Override
  public int getDefense() {
    return opponent.defenses().get(damager.getDefenseType());
  }
  

}
