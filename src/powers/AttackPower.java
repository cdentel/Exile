package powers;

import attack.DamageDealing;

public abstract class AttackPower implements DamageDealing {
  
  public abstract PowerType getPowerType();
  
  public abstract PowerFrequency getPowerFrequency();
}
