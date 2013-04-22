package mechanics;

import java.util.Map;
import java.util.TreeMap;

import mechanics.dice.Dice;

import com.google.common.collect.Maps;

public class Damage {
  
  public Map<DamageType, DamageAmount> damages = new TreeMap<DamageType, DamageAmount>();
  
  private Damage(DamageType type, DamageAmount damage) {
    damages.put(type, damage);
  }
  
  public Damage add(DamageType type, DamageAmount damage) {
    damages.put(type, damages.get(type).add(damage));
    return this;
  }
  
  public Damage set(DamageType type, DamageAmount amount) {
    damages.put(type,  amount);
    return this;
  }
  
  public EvaluatedDamage evaluate() {
    Map<DamageType, Integer> evaluated = Maps.newTreeMap();
    for(DamageType type : damages.keySet()) {
      evaluated.put(type, damages.get(type).evaluate());
    }
    return new EvaluatedDamage(evaluated);
  }
  
  public EvaluatedDamage crit() {
    Map<DamageType, Integer> evaluated = Maps.newTreeMap();
    for(DamageType type : damages.keySet()) {
      evaluated.put(type, damages.get(type).crit());
    }
    return new EvaluatedDamage(evaluated);
  }
  
  public static Damage of(DamageType type, int fixed, Dice dice) {
    return new Damage(type, new DamageAmount(fixed, dice));
  }
  
  public static Damage basic(int fixed, Dice dice) {
    return new Damage(DamageType.BASIC, new DamageAmount(fixed, dice));
  }
  
  public static Damage basic(Dice dice) {
    return new Damage(DamageType.BASIC, new DamageAmount(0, dice));
  }
  
  private static class DamageAmount {
    
    private final int fixed;
    private final Dice dice;
    
    private DamageAmount(int fixed, Dice dice) {
      this.fixed = fixed;
      this.dice = dice;
    }
    
    public int evaluate() {
      return fixed + dice.roll();
    }
    
    public int crit() {
      return fixed + dice.critValue();
    }
    
    public DamageAmount add(DamageAmount other) {
      return new DamageAmount(fixed + other.fixed, dice.add(other.dice));
    }

  }

}
