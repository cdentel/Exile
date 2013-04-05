package mechanics.defenses;

import static mechanics.Attribute.DEXTERITY;
import static mechanics.Attribute.INTELLIGENCE;
import creatures.Creature;
import equipment.wearable.WearableMaterialType.ArmorWeight;

public class ArmorClass extends Defense {
  
  public ArmorClass(Creature c) {
    super(c);
  }

  
  public int getArmor() {
    return creature.equipment().getAmorClassModifier();
  }
  
  @Override
  public int getAbility() {
      // If the creature is not wearing armor
    if(!creature.equipment().getTorso().isPresent()
      // Or their armor is light
      || creature.equipment().getTorso().get().getMaterialType().armorWeight.equals((ArmorWeight.LIGHT))) {
      // They can add the max of either their dex or intelligence mod to their ac
      // Because being smart makes you harder to hit?
      return Math.max(
          creature.attributes().getModifier(DEXTERITY), 
          creature.attributes().getModifier(INTELLIGENCE));
    } else {
      // Hope their armor is worth it
      return 0;
    }
  }

  @Override
  public int getHalfLevel() {
    return creature.getLevel() / 2;
  }

  @Override
  public int getClassBonus() {
    return creature.getClazz().getAcBonus();
  }
  
  @Override
  public int getScore() {
   return super.getScore() + getArmor(); 
  }
  
  @Override
  public String toString() {
    return 
        super.toString() + String.format(
        " -- Armor:     %d\n",
        getArmor());
  }

}
