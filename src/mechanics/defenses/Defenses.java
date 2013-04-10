package mechanics.defenses;

import java.util.Map;
import java.util.TreeMap;

import creatures.Creature;

public class Defenses {
  
  private Map<DefenseType, Defense> defenses;
  
  private Defenses(Creature c) {
    defenses = new TreeMap<>();
    for(DefenseType type : DefenseType.values()){
      defenses.put(type, new Defense(c, type));
    }
  }
  public Defense getDefense(DefenseType type) {
    return defenses.get(type);
  }
  
  public static Defenses of(Creature c) {
    return new Defenses(c);
  }
  
  @Override
  public String toString() {
    return String.format(
        "--AC--\n%s\n--Fortitude--\n%s\n--Reflex--\n%s\n--Will--\n%s\n",
        getDefense(DefenseType.AC),
        getDefense(DefenseType.FORTITUDE),
        getDefense(DefenseType.REFLEX),
        getDefense(DefenseType.WILL));
  }
}
