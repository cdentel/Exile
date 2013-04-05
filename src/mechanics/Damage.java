package mechanics;

public class Damage {
  
  private int fixed;
  private Dice dice;
  
  public Damage(int fixed, Dice dice) {
    this.fixed = fixed;
    this.dice = dice;
  }
  
  public EvaluatedDamage evaluate() {
    return EvaluatedDamage.basic(fixed + dice.roll());
  }
  
  public EvaluatedDamage crit() {
    return EvaluatedDamage.basic(fixed + dice.critValue());
  }

}
