package mechanics;

public class EvaluatedDamage {

  private int basic;
  
  private EvaluatedDamage(int basic) {
    this.basic = basic;
  }
  
  public static EvaluatedDamage basic(int basicDamage) {
    return new EvaluatedDamage(basicDamage);
  }
  
  public int getBasicDamage() {
    return basic;
  }

}
