package equipment.shield;

import mechanics.BonusSource;
import mechanics.defenses.DefenseType;
import mechanics.modifier.ImmutableModifier;
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
  public ImmutableModifier<BurdenType, Integer> getBurdenModifier() {
    return ImmutableModifier.of(BonusSource.SHIELD, BurdenType.WEIGHT, size.weight);
  }
  
  public ImmutableModifier<DefenseType, Integer> getDefenseModifier() {
    return ImmutableModifier.of(BonusSource.SHIELD, DefenseType.AC, size.armorBonus);
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
    return c.shieldProficiencies().contains(getShieldType());
  }
}
