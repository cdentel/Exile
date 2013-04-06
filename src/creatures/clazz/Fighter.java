package creatures.clazz;

import mechanics.defenses.DefenseModifier;
import mechanics.defenses.DefenseType;

public class Fighter extends Clazz {

  @Override
  public int getHealingSurges() {
    return 9;
  }

  @Override
  public int getBaseHitPointsForLevel(int level) {
    return 15 + 6 * level;
  }
  
  @Override
  public int getFortitudeBonus() {
    return 2;
  }

  @Override
  public DefenseModifier getDefenseModifier() {
    return DefenseModifier.of(DefenseType.FORTITUDE, 2);
  }

}
