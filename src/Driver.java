import mechanics.BonusSource;
import mechanics.DamageType;
import mechanics.defenses.DefenseType;
import mechanics.modifier.Modifier;
import powers.dragonborn.DragonBreathOption;
import creatures.Creature;
import creatures.Hero;
import creatures.Monster;
import creatures.clazz.Clazz;
import creatures.clazz.Fighter;
import creatures.components.AttributeType;
import creatures.components.Language;
import creatures.race.Dragonborn;
import creatures.race.Human;
import creatures.race.Race;
import equipment.Equipment;
import equipment.shield.Shield;
import equipment.shield.ShieldType;
import equipment.weapon.Dagger;
import equipment.weapon.Warhammer;
import equipment.wearable.ArmorType;
import equipment.wearable.Footwear;
import equipment.wearable.Handwear;
import equipment.wearable.Torso;
import event.AttributeListener;
import event.AttributeBroadcaster;


public class Driver {

  /**
   * @param args
   */
  public static void main(String[] args) {
    //Creature creature = getMonster();
    
    AttributeBroadcaster mb = new AttributeBroadcaster();
    mb.subscribe(new AttributeListener<Integer>(DefenseType.AC){

      @Override
      public void onBroadcast(Integer number) {
        System.out.println(number);
        
      }
     
    });
    
    mb.broadcast(DefenseType.AC, 5);
    
    //CreatureViewer viewer = new CreatureViewer(creature);
    
    /*
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
      System.out.printf("%s Victory!\n", g.health().isConscious() ? g.getName() : h.getName());    */
  }
  
  private static Hero getHero() {
    Race race = new Human(Language.ELVEN, AttributeType.STRENGTH);
    Clazz clazz = new Fighter();
    Hero h =  new Hero(race, clazz);
    h.attributes().add(Modifier
        .of(BonusSource.BASE, AttributeType.CHARISMA, 10)
        .and(AttributeType.CONSTITUTION, 14)
        .and(AttributeType.DEXTERITY, 11)
        .and(AttributeType.INTELLIGENCE, 8)
        .and(AttributeType.STRENGTH, 18)
        .and(AttributeType.WISDOM, 10));
    Equipment e = h.equipment();
    e.equip(new Torso(ArmorType.CHAIN));
    e.equip(new Footwear(ArmorType.CHAIN));
    e.equip(new Handwear(ArmorType.CHAIN));
    e.equip(new Shield(ShieldType.HEAVY));
    e.equip(new Warhammer());
    return h;
  }
  
  private static Monster getMonster() {
    Race race = new Dragonborn(DragonBreathOption.withModifierAndDamageType(
        AttributeType.DEXTERITY, DamageType.POISON));
    Clazz clazz = new Fighter();
    Monster g = new Monster(race, clazz);
    g.attributes().add(Modifier
        .of(BonusSource.BASE, AttributeType.CHARISMA, 8)
        .and(AttributeType.CONSTITUTION, 14)
        .and(AttributeType.DEXTERITY, 18)
        .and(AttributeType.INTELLIGENCE, 11)
        .and(AttributeType.STRENGTH, 10)
        .and(AttributeType.WISDOM, 10));
    Equipment e = g.equipment();
    e.equip(new Torso(ArmorType.LEATHER));
    e.equip(new Handwear(ArmorType.LEATHER));
    e.equip(new Footwear(ArmorType.LEATHER));
    e.equip(new Dagger());
    return g;

  }
  
  private static void printStats(Creature c) {
    System.out.println(c.getName());
    System.out.println(c.defenses());
    System.out.println(c.health());
  }

}
