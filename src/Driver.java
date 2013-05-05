import java.awt.Dimension;

import javax.swing.JFrame;

import mechanics.DamageType;
import mechanics.modifier.Modifier;
import mechanics.modifier.ModifierType;
import mechanics.skills.SkillType;
import mechanics.skills.TrainedSkills;
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
import graphics.Map;


public class Driver {

  /**
   * @param args
   */
  public static void main(String[] args) {
    Creature creature = getMonster();
    JFrame frame = new JFrame("Demo");
    frame.setSize(600,400);
    Map map = new Map();
    frame.add(map);
    frame.setVisible(true);
    frame.getGraphics().fillRect(100, 100, 10, 10);
    
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
    TrainedSkills skills = TrainedSkills.getTrainedSkillBuilderFor(race, clazz)
        .chooseClazzSkill(SkillType.ATHLETICS).chooseClazzSkill(SkillType.ENDURANCE)
        .chooseClazzSkill(SkillType.HEAL).chooseClazzSkill(SkillType.INTIMIDATE)
        .build();
    
    Hero h =  new Hero(race, clazz, skills);
    h.attributes().add(Modifier
        .of(ModifierType.BASE, AttributeType.CHARISMA, 10)
        .and(AttributeType.CONSTITUTION, 14)
        .and(AttributeType.DEXTERITY, 11)
        .and(AttributeType.INTELLIGENCE, 8)
        .and(AttributeType.STRENGTH, 18)
        .and(AttributeType.WISDOM, 10));
    Equipment e = h.equipment();
    e.setTorso(new Torso(ArmorType.CHAIN));
    e.setFootwear(new Footwear(ArmorType.CHAIN));
    e.setHandwear(new Handwear(ArmorType.CHAIN));
    e.setLeftHand(new Shield(ShieldType.HEAVY));
    e.setRightHand(new Warhammer());
    return h;
  }
  
  private static Monster getMonster() {
    Race race = new Dragonborn(DragonBreathOption.withModifierAndDamageType(
        AttributeType.DEXTERITY, DamageType.POISON));
    Clazz clazz = new Fighter();
    TrainedSkills skills = TrainedSkills.getTrainedSkillBuilderFor(race, clazz)
      .chooseClazzSkill(SkillType.STREETWISE)
      .chooseClazzSkill(SkillType.ATHLETICS)
      .chooseClazzSkill(SkillType.INTIMIDATE)
      .build();
    Monster g = new Monster(race, clazz, skills);
    g.attributes().add(Modifier
        .of(ModifierType.BASE, AttributeType.CHARISMA, 8)
        .and(AttributeType.CONSTITUTION, 14)
        .and(AttributeType.DEXTERITY, 18)
        .and(AttributeType.INTELLIGENCE, 11)
        .and(AttributeType.STRENGTH, 10)
        .and(AttributeType.WISDOM, 10));
    Equipment e = g.equipment();
    e.setTorso(new Torso(ArmorType.LEATHER));
    e.setHandwear(new Handwear(ArmorType.LEATHER));
    e.setFootwear(new Footwear(ArmorType.LEATHER));
    e.setRightHand(new Dagger());
    return g;

  }
  
  private static void printStats(Creature c) {
    System.out.println(c.getName());
    System.out.println(c.defenses());
    System.out.println(c.health());
  }

}
