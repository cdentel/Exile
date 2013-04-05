import mechanics.Attributes;
import creatures.Creature;
import creatures.Goblin;
import creatures.Hero;
import creatures.clazz.Fighter;
import equipment.Equipment;
import equipment.shield.Shield;
import equipment.shield.ShieldMaterialType;
import equipment.shield.ShieldSize;
import equipment.weapon.Dagger;
import equipment.weapon.Sword;


public class Driver {

  /**
   * @param args
   */
  public static void main(String[] args) {
    Hero h = getHero();
    Goblin g = getGoblin();
    while(h.health().isConscious() && g.health().isConscious()) {
      printStats(h);
      printStats(g);
      h.attack(g).execute();
      if(g.health().isConscious()) {
        g.attack(h).execute();
      }
    }
      System.out.printf("%s Victory!\n", g.health().isConscious() ? g.getName() : h.getName());
      printStats(h);
      printStats(g);
  }
  
  private static Hero getHero() {
    Attributes a = new Attributes(10, 16, 14, 12, 16, 12);
    Equipment e = new Equipment();
    e.setLeftHand(new Shield(ShieldMaterialType.WOOD, ShieldSize.MEDIUM));
    e.setRightHand(new Sword());
    return new Hero(a, e, new Fighter());
  }
  
  private static Goblin getGoblin() {
    Attributes a = new Attributes(10, 16, 18, 12, 12, 12);
    Equipment e = new Equipment();
    e.setRightHand(new Dagger());
    return new Goblin(a, e, new Fighter());
  }
  
  private static void printStats(Creature c) {
    System.out.println(c.getName());
    System.out.println(c.defenses());
    System.out.println(c.health());
  }

}
