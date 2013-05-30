package creatures;
import mechanics.EvaluatedDamage;
import mechanics.ProficiencySet;
import mechanics.defenses.Defenses;
import mechanics.skills.Skills;
import attack.Attack;
import creatures.clazz.Clazz;
import creatures.components.Attributes;
import creatures.components.Burden;
import creatures.components.Health;
import creatures.components.Language;
import creatures.components.Vision;
import creatures.race.Race;
import equipment.Equipment;
import equipment.shield.ShieldType;
import equipment.weapon.WeaponType;
import equipment.wearable.ArmorType;


public abstract class Creature {
    
  protected int xp;
  
  protected Attributes attributes = new Attributes();
  
  protected Health health = new Health();
  
  protected Skills skills = new Skills();
  
  protected  Defenses defenses = new Defenses();
  
  protected Burden burden = new Burden();
  
  protected ProficiencySet<ShieldType> shieldProficiencies = ProficiencySet.create();
  
  protected ProficiencySet<ArmorType> armorProficiencies = ProficiencySet.create();
  
  protected ProficiencySet<WeaponType> weaponProficiencies = ProficiencySet.create();
  
  protected ProficiencySet<Vision> vision = ProficiencySet.create();
  
  protected ProficiencySet<Language> languages = ProficiencySet.create();
  
  protected Race race;
  
  protected Clazz clazz;
  
  protected Equipment equipment;

  public abstract String getName();
  
  
  public Creature(Race race, Clazz clazz) {
    this.clazz = clazz;
    this.race = race;
    equipment = new Equipment(this);
    race.applyRaceBonuses(this);
    clazz.applyClazzBonuses(this);
  }
  
  public Burden burden() {
    return burden;
  }
  
  public Defenses defenses() {
    return defenses;
  }
  
  public Attack attack(Creature opponent) {
    throw new UnsupportedOperationException();
    //if(equipment.getRightHand().isPresent()) {
      //return new MeleeBasicAttack(this, opponent, equipment.get(EquipmentType.WEAPON).get());
    //} else {
      
    //}
  }
  
  public void takeDamage(EvaluatedDamage d) {
    System.out.printf("%s takes %d damage.\n", getName(), d.getTotalDamage());
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
  
  public Race getRace() {
    return race;
  }
  
  public Attributes attributes() {
    return attributes;
  }
  
  public ProficiencySet<WeaponType> weaponProficiencies() {
    return weaponProficiencies;
  }
  
  public ProficiencySet<ArmorType> armorProficiencies() {
    return armorProficiencies;
  }
  
  public ProficiencySet<ShieldType> shieldProficiencies() {
    return shieldProficiencies;
  }
  
  public ProficiencySet<Vision> vision() {
    return vision;
  }
  
  public Skills getSkills() {
    return skills;
  }
  
  public ProficiencySet<Language> languages() {
    return languages;
  }

}
