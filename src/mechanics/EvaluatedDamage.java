package mechanics;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

public class EvaluatedDamage {
  
  private final ImmutableMap<DamageType, Integer> damages;
  
  public EvaluatedDamage(Map<DamageType, Integer> damages) {
    this.damages = ImmutableMap.copyOf(damages);
  }
  
  public int getTotalDamage() {
    int sum = 0;
    for(Integer damage : damages.values()) {
      sum += damage;
    }
    return sum;
  }

}
