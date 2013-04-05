package attack;

import creatures.Creature;

public abstract class Attack {
  
  protected Creature attacker, opponent;
  
  public Attack(Creature attacker, Creature opponent) {
    this.attacker = attacker;
    this.opponent = opponent;
  }

}
