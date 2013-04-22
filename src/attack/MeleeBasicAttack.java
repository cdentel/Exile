package attack;

import mechanics.Damage;
import mechanics.defenses.Defense;
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
        + attacker.attributes().get(damager.getAttributeUsed()).getModifier();
  }

  @Override
  public Damage getDamage() {
    return damager.getDamage();
  }

  @Override
  public Defense getDefense() {
    return opponent.defenses().getDefense(damager.getDefenseType());
  }
  

}
