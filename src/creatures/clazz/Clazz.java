package creatures.clazz;

import java.util.Set;

import mechanics.defenses.DefenseModifier;
import equipment.WeaponType;
import equipment.shield.ShieldType;
import equipment.wearable.ArmorType;

public abstract class Clazz {
  
  public abstract DefenseModifier getDefenseModifier();
  
  public abstract int getHealingSurges();
  
  public abstract int getBaseHitPointsForLevel(int level);
  
  public abstract Set<ArmorType> getArmorProficiencies();
  
  public abstract Set<ShieldType> getShieldProficiencies();
  
  public abstract Set<WeaponType> getWeaponProficiencies();
  
  
  
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
