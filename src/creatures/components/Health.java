package creatures.components;

import mechanics.modifier.Modifiable;
import mechanics.modifier.numeric.IntegerNumeric;
import event.AttributeBroadcaster;
import event.AttributeBroadcaster;

public class Health extends Modifiable<HealthType, Integer> {
  
  public Health(AttributeBroadcaster broadcaster) {
    super(IntegerNumeric.INSTANCE(), broadcaster);
  }
  
  public int getMaxHp() {
    return get(HealthType.MAX_HP);
  }
  
  public int getMaxHealingSurges() {
    return get(HealthType.MAX_SURGES);

  }
  
  public int getCurrentHp() {
    return get(HealthType.HP);

  }
  
  public int  getCurrentHealingSurges() {
    return get(HealthType.SURGES);

  }
  
  public boolean isBloodied() {
    return getCurrentHp() <= bloodiedValue();
  }
  
  public boolean isConscious() {
    return getCurrentHp() > 0;
  }
  
  public int surgeValue() {
    return get(HealthType.SURGE_VALUE);
  }
  
  public int bloodiedValue() {
    return getMaxHp() / 2;
  }
}
