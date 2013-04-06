package mechanics.defenses;

import creatures.Creature;

public class Defenses {
  
  private ArmorClass ac;
  private Fortitude fortitude;
  private Reflex reflex;
  private Will will;
  
  private Defenses(Creature c) {
    ac = new ArmorClass(c);
    fortitude = new Fortitude(c);
    reflex = new Reflex(c);
    will = new Will(c);
  }
  
  public Fortitude getFortitude() {
    return fortitude;
  }

  public Reflex getReflex() {
    return reflex;
  }

  public Will getWill() {
    return will;
  }

  public ArmorClass getArmorClass() {
    return ac;
  }
  
  public Defense getDefense(DefenseType type) {
    if(type.equals(DefenseType.AC)) {
      return getArmorClass();
    } else if(type.equals(DefenseType.FORTITUDE)) {
      return getFortitude();
    } else if (type.equals(DefenseType.REFLEX)) {
      return getReflex();
    } else if (type.equals(DefenseType.WILL)) {
      return getWill();
    } else {
      throw new UnsupportedOperationException("Defense Type " + type + " is not supported");
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
