package creatures.clazz;

public class Fighter implements Clazz {

  @Override
  public int getHealingSurges() {
    return 9;
  }

  @Override
  public int getBaseHitPointsForLevel(int level) {
    return 15 + 6 * level;
  }

}
