package creatures.components;

import static creatures.components.AttributeType.CONSTITUTION;
import mechanics.EvaluatedDamage;
import creatures.Creature;

public class Health {
  
  private Creature creature;
  private int damageTaken;
  private int surgesUsed;
  
  public Health(Creature c){
    this(c, 0, 0);
  }
  
  public Health(Creature c, int damageTaken, int surgesUsed) {
    this.creature = c;
    this.damageTaken = damageTaken;
    this.surgesUsed = surgesUsed;
    
  }
  
  public int getMaxHp() {
    return
          // Base + level
          creature.getClazz().getBaseHitPointsAtLevel(creature.getLevel())
        + creature.attributes().get(CONSTITUTION).getScore();
  }
  
  public int getMaxHealingSurges() {
    return 
        creature.getClazz().getHealingSurges()
      + creature.attributes().get(CONSTITUTION).getModifier();
  }
  
  public int getCurrentHp() {
    return getMaxHp() - damageTaken;
  }
  
  public int  getCurrentHealingSurges() {
    return getMaxHealingSurges() - surgesUsed;
  }
  
  public boolean isBloodied() {
    return getCurrentHp() <= bloodiedValue();
  }
  
  public boolean isConscious() {
    return getCurrentHp() > 0;
  }
  
  public int surgeValue() {
    // Draconic Heritage
    if(creature.getRace().hasDraconicHeritage()) {
      return getMaxHp() / 4 + creature.attributes().get(CONSTITUTION).getModifier();
    }
    return getMaxHp() / 4;
  }
  
  public int bloodiedValue() {
    return getMaxHp() / 2;
  }
  
  public void takeDamage(EvaluatedDamage damage) {
    damageTaken += damage.getBasicDamage();
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
