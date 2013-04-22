package creatures;
import java.util.Set;

import mechanics.EvaluatedDamage;
import mechanics.defenses.Defenses;
import mechanics.skills.Skills;
import mechanics.skills.TrainedSkills;
import attack.Attack;
import attack.MeleeBasicAttack;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;

import creatures.clazz.Clazz;
import creatures.components.Attributes;
import creatures.components.Health;
import creatures.components.Language;
import creatures.components.Vision;
import creatures.race.Race;
import equipment.Equipment;
import equipment.WeaponType;
import equipment.shield.ShieldType;
import equipment.wearable.ArmorType;


public abstract class Creature {
    
  protected int xp;
  
  protected Attributes attributes;
  
  protected Equipment equipment;
  
  protected Race race;
  
  protected Clazz clazz;
  
  protected Health health;
  
  protected Skills skills;
  
  public abstract String getName();
  
  
  public Creature(Race race, Clazz clazz, TrainedSkills trainedSkills) {
    this.clazz = clazz;
    this.race = race;
    attributes = new Attributes(this);
    health = new Health(this);
    equipment = new Equipment(this);
    skills = new Skills(this, trainedSkills);
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
  
  public Set<WeaponType> getWeaponProficiencies() {
    return getClazz().getWeaponProficiencies();
  }
  
  public Set<ArmorType> getArmorProficiencies() {
    return getClazz().getArmorProficiencies();
  }
  
  public Set<ShieldType> getShieldProficiencies() {
    return getClazz().getShieldProficiencies();
  }
  
  public Vision getVision() {
    return race.getVision();
  }
  
  public Skills getSkills() {
    return skills;
  }
  
  public ImmutableSet<Language> getLanguages() {
    return race.getLanguages();
  }

}
