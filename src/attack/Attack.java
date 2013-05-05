package attack;

import mechanics.Damage;
import mechanics.dice.Die;
import creatures.Creature;

public abstract class Attack {
  
  protected Creature attacker, opponent;
  protected DamageDealing damager;
  
  public Attack(Creature attacker, Creature opponent, DamageDealing damager) {
    this.attacker = attacker;
    this.opponent = opponent;
    this.damager = damager;
  }
  
  public abstract int getAttackModifier();
  
  public abstract int getDefense();
  
  
  public void execute() {
    int attackRoll = Die.d20.roll();
    if(attackRoll == Die.d20.critValue()) {
      System.out.printf("%s crits!\n",attacker.getName());
      opponent.takeDamage(getDamage().crit());
    } else if(attackLandsWithRoll(attackRoll)) {
      System.out.printf("%s's attack lands (with a %d).\n",attacker.getName(), attackRoll + getAttackModifier());
      opponent.takeDamage(getDamage().evaluate());
    } else {
      System.out.printf("%s misses (with a %d).\n",attacker.getName(), attackRoll + getAttackModifier());
    }
  }
  
  public boolean attackLandsWithRoll(int roll) {
    return getAttackModifier() + roll > getDefense();
  }
  
  public abstract Damage getDamage();
  
}
