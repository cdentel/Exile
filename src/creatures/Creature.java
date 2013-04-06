package creatures;
import mechanics.Attributes;
import mechanics.EvaluatedDamage;
import mechanics.Health;
import mechanics.defenses.Defenses;
import attack.Attack;
import attack.MeleeBasicAttack;
import creatures.clazz.Clazz;
import creatures.race.Race;
import equipment.Equipment;


public abstract class Creature {
    
  protected int xp;
  
  protected Attributes attributes;
  
  protected Equipment equipment;
  
  protected Race race;
  
  protected Clazz clazz;
  
  protected Health health;
  
  public abstract String getName();
  
  public Creature(Attributes attributes, Equipment equipment, Clazz clazz) {
    this.attributes = attributes;
    this.equipment = equipment;
    this.clazz = clazz;
    health = new Health(this);
  }
  
  public Defenses defenses() {
    return Defenses.of(this);
  }
  
  public Attack attack(Creature opponent) {
    //if(equipment.getRightHand().isPresent()) {
      return new MeleeBasicAttack(this, opponent, equipment.getRightHand().get());
    //} else {
      
    //}
  }
  
  public void takeDamage(EvaluatedDamage d) {
    System.out.printf("%s takes %d damage.\n", getName(), d.getBasicDamage());
    health.takeDamage(d);
  }
  
  public Health health() {
    return health;
  }
  
  public Equipment equipment() {
    return equipment;
  }
  
  public int getLevel() {
    // 500*(level)(level -1) = xp
    // level^2 + (-1)*level - xp/500 = 0;
    // (1 + root(1 + xp/125)) / 2
    return (int) (1 + Math.sqrt(1 + 1.0 * xp / 125))/2;
  }
  
  public Clazz getClazz() {
    return clazz;
  }
  
  public Attributes attributes() {
    return attributes;
  }
}
