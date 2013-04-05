package mechanics.defenses;

import creatures.Creature;

public class Defenses {
  
  private ArmorClass ac;
  
  private Defenses(Creature c) {
    ac = new ArmorClass(c);
  }
  
  public ArmorClass getArmorClass() {
    return ac;
  }
  
  public Defense getDefense(DefenseType type) {
    if(type.equals(DefenseType.AC)) {
      return getArmorClass();
    } else {
      return null;
    }
  }
  
  public static Defenses of(Creature c) {
    return new Defenses(c);
  }
  
  @Override
  public String toString() {
    return String.format(
        "Defenses\n" + 
        " -- AC -- \n" +
        getArmorClass());
  }

}
