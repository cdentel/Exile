package creatures;
import static mechanics.Attribute.CONSTITUTION;
import static mechanics.Attribute.DEXTERITY;
import static mechanics.Attribute.INTELLIGENCE;
import mechanics.Attributes;
import attack.Attack;
import attack.MeleeBasicAttack;
import creatures.clazz.Clazz;
import creatures.race.Race;
import equipment.Equipment;
import equipment.wearable.WearableMaterialType.ArmorWeight;


public abstract class Creature {
  
  protected int level;
  
  protected int xp;
  
  protected int currentHp;
  
  protected int currentHealingSurges;

  protected Attributes attributes;
  
  protected Equipment equipment;
  
  protected Race race;
  
  protected Clazz clazz;
  
  public Creature(Attributes attributes, Equipment equipment) {
    this.attributes = attributes;
    this.equipment = equipment;
    currentHp = getMaxHp();
    currentHealingSurges = getMaxHealingSurges();
    level = 1;
  }
  
  public int getAC() {
    return 
          // Base
          10 
          // AC of equipment
        + equipment.getAmorClassModifier()
          // 1/2 your level
        + level/2 
          // Intelligence or dex modifier if not wearing armor or armor is light
        + ((!equipment.getTorso().isPresent() || 
            equipment.getTorso().get().getMaterialType().armorWeight.equals(ArmorWeight.LIGHT)) 
          ? Math.max(attributes.getModifier(DEXTERITY), attributes.getModifier(INTELLIGENCE))
          : 0);
  }
  
  public int getMaxHp() {
    return
          // Base + level
          clazz.getBaseHitPointsForLevel(level)
        + attributes.getModifier(CONSTITUTION);
  }
  
  public int getCurrentHp() {
    return currentHp;
  }
  
  public int getMaxHealingSurges() {
    return 
          clazz.getHealingSurges()
        + attributes.getModifier(CONSTITUTION);
  }
  
  public int getCurrentHealingSurges() {
    return currentHealingSurges;
  }
  
  public Attack attack(Creature opponent) {
    //if(equipment.getRightHand().isPresent()) {
      return new MeleeBasicAttack(this, opponent, equipment.getRightHand().get());
    //} else {
      
    //}
  }
}
