package creatures.clazz;

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

}
