package mechanics.defenses;

import java.util.Map;
import java.util.TreeMap;

public class DefenseModifier {
  
  private Map<DefenseType, Integer> modifiers;
  
  private DefenseModifier() {
    modifiers = new TreeMap<>();
    for(DefenseType type : DefenseType.values()) {
      modifiers.put(type, 0);
    }
  }
  
  public static DefenseModifier of(DefenseType type, int amount){
    return new DefenseModifier();
  }
  
  public static DefenseModifier none() {
    return new DefenseModifier();
  }
  
  public void set(DefenseType type, int amount) {
    modifiers.put(type, amount);
  }
  
  public DefenseModifier and(DefenseType type, int amount) {
    set(type, amount);
    return this;
  }
  
  public int get(DefenseType type) {
    return modifiers.get(type);
  }

}
