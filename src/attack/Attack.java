package attack;

import mechanics.Damage;
import mechanics.Die;
import mechanics.defenses.Defense;
import creatures.Creature;

public abstract class Attack {
  
  protected Creature attacker, opponent;
  
  public Attack(Creature attacker, Creature opponent) {
    this.attacker = attacker;
    this.opponent = opponent;
  }
  
  public abstract int getAttackModifier();
  
  public abstract Defense getDefense();
  
  
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
    return getAttackModifier() + roll > getDefense().getScore();
  }
  
  public abstract Damage getDamage();
  
}
