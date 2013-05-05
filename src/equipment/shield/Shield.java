package equipment.shield;

import mechanics.defenses.DefenseType;
import mechanics.modifier.Modifier;
import mechanics.modifier.ModifierType;
import creatures.Creature;
import creatures.components.BurdenType;
import equipment.EquipmentType;
import equipment.Equippable;

public class Shield implements Equippable {
  
  private ShieldType size;
  
  public Shield(ShieldType size) {
    this.size = size;
  }
  
  public ShieldType getShieldType() {
    return size;
  }
  
  @Override
  public Modifier<BurdenType, Integer> getBurdenModifier() {
    return Modifier.of(ModifierType.SHIELD, BurdenType.WEIGHT, size.weight);
  }
  
  public Modifier<DefenseType, Integer> getDefenseModifier() {
    return Modifier.of(ModifierType.SHIELD, DefenseType.AC, size.armorBonus);
  }

  public int getMovementModifier() {
    return size.check;
  }

  @Override
  public EquipmentType getEquipmentType() {
    return EquipmentType.SHIELD;
  }

  @Override
  public void onEquip(Creature c) {
    c.defenses().add(getDefenseModifier());
    c.burden().add(getBurdenModifier());
    
  }

  @Override
  public void onUnequip(Creature c) {
    c.defenses().remove(getDefenseModifier());
    c.burden().remove(getBurdenModifier());
    
  }

  @Override
  public boolean canBeEquippedBy(Creature c) {
    return c.getShieldProficiencies().contains(getShieldType());
  }
}
