import mechanics.Attributes;
import attack.Warhammer;
import creatures.Creature;
import creatures.Goblin;
import creatures.Hero;
import creatures.clazz.Fighter;
import equipment.Equipment;
import equipment.shield.Shield;
import equipment.shield.ShieldType;
import equipment.weapon.Dagger;
import equipment.wearable.ArmorType;
import equipment.wearable.Footwear;
import equipment.wearable.Handwear;
import equipment.wearable.Torso;


public class Driver {

  /**
   * @param args
   */
  public static void main(String[] args) {
    Hero h = getHero();
    Goblin g = getGoblin();
    printStats(h);
    printStats(g);
    while(h.health().isConscious() && g.health().isConscious()) {
      
      h.attack(g).execute();
      if(g.health().isConscious()) {
        g.attack(h).execute();
      }
      System.out.println("Hero");
      System.out.println(h.health());
      System.out.println("Goblin");
      System.out.println(g.health());
    }
      System.out.printf("%s Victory!\n", g.health().isConscious() ? g.getName() : h.getName());
  }
  
  private static Hero getHero() {
    Attributes a = new Attributes(10, 16, 14, 12, 16, 12);
    Hero h =  new Hero(a, new Fighter());
    Equipment e = h.equipment();
    e.setTorso(new Torso(ArmorType.SCALE));
    e.setFootwear(new Footwear(ArmorType.SCALE));
    e.setHandwear(new Handwear(ArmorType.SCALE));
    e.setLeftHand(new Shield(ShieldType.HEAVY));
    e.setRightHand(new Warhammer());
    return h;
  }
  
  private static Goblin getGoblin() {
    Attributes a = new Attributes(10, 16, 18, 12, 12, 12);
    Goblin g = new Goblin(a, new Fighter());
    Equipment e = g.equipment();
    e.setTorso(new Torso(ArmorType.LEATHER));
    e.setHandwear(new Handwear(ArmorType.SCALE));
    e.setFootwear(new Footwear(ArmorType.SCALE));
    e.setRightHand(new Dagger());
    return g;

  }
  
  private static void printStats(Creature c) {
    System.out.println(c.getName());
    System.out.println(c.defenses());
    System.out.println(c.health());
  }

}
