package creatures.clazz;

public abstract class Clazz {
  
  public abstract int getHealingSurges();
  
  public abstract int getBaseHitPointsForLevel(int level);
  
  public int getAcBonus() {
    return 0;
  }
  
  public int getFortitudeBonus() {
    return 0;
  }
  
  public int getReflexBonus() {
    return 0;
  }
  
  public int getWillBonus() {
    return 0;
  }
  

}
