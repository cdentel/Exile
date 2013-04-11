package mechanics;

import mechanics.dice.Dice;

public class Damage {
  
  private int fixed;
  private Dice dice;
  
  public Damage(int fixed, Dice dice) {
    this.fixed = fixed;
    this.dice = dice;
  }
  
  public Damage(Dice dice) {
    this(0, dice);
  }
  
  public EvaluatedDamage evaluate() {
    return EvaluatedDamage.basic(fixed + dice.roll());
  }
  
  public EvaluatedDamage crit() {
    return EvaluatedDamage.basic(fixed + dice.critValue());
  }

}
