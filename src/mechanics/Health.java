package mechanics;

import static mechanics.Attribute.CONSTITUTION;
import creatures.Creature;

public class Health {
  
  private Creature creature;
  private int currentHp;
  private int currentSurges;
  
  public Health(Creature c){
    this.creature = c;
    currentHp = getMaxHp();
    currentSurges = getMaxHealingSurges();
  }
  
  public Health(Creature c, int currentHp, int currentHealingSurges) {
    this(c);
    this.currentHp = currentHp;
    this.currentSurges = currentHealingSurges;
  }
  
  public int getMaxHp() {
    return
          // Base + level
          creature.getClazz().getBaseHitPointsForLevel(creature.getLevel())
        + creature.attributes().getModifier(CONSTITUTION);
  }
  
  public int getMaxHealingSurges() {
    return 
        creature.getClazz().getHealingSurges()
      + creature.attributes().getModifier(CONSTITUTION);
  }
  
  public int getCurrentHp() {
    return currentHp;
  }
  
  public int  getCurrentHealingSurges() {
    return currentSurges;
  }
  
  public boolean isBloodied() {
    return getCurrentHp() <= bloodiedValue();
  }
  
  public boolean isConscious() {
    return getCurrentHp() > 0;
  }
  
  public int surgeValue() {
    return getMaxHp() / 4;
  }
  
  public int bloodiedValue() {
    return getMaxHp() / 2;
  }
  
  public void takeDamage(EvaluatedDamage damage) {
    currentHp -= damage.getBasicDamage();
  }
  
  @Override
  public String toString() {
    return String.format(
        "Health\n" +
        " -- HP         (%d/%d)\n" +
        " -- Surges     (%d/%d)\n" +
        " -- Conscious: %b\n" +
        " -- Bloodied:  %b\n",
        getCurrentHp(),
        getMaxHp(),
        getCurrentHealingSurges(),
        getMaxHealingSurges(),
        isConscious(),
        isBloodied());
  }

}
