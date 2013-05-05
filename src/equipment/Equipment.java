package equipment;

import java.util.Map;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;

import creatures.Creature;
import equipment.shield.Shield;
import equipment.weapon.Weapon;
import equipment.wearable.Footwear;
import equipment.wearable.Handwear;
import equipment.wearable.Torso;

public class Equipment {
  
  private Creature creature;
  
  private Optional<Torso> torso = Optional.absent();
  private Optional<Handwear> handwear = Optional.absent();
  private Optional<Footwear> footwear = Optional.absent();
  private Optional<Shield> leftHand = Optional.absent();
  private Optional<Weapon> rightHand = Optional.absent();
  
  private Map<EquipmentType, Equippable> equipment;

  
  public Equipment(Creature creature) {
    this.creature = creature;
    equipment = Maps.newTreeMap();
    /*Naked*/
  }
  
  public Optional<Equippable> get(EquipmentType type) {
    return Optional.fromNullable(equipment.get(type));
  }
  
  public boolean canEquip(Equippable equippable) {
    return equippable.canBeEquippedBy(creature);
  }
  
  // Equipps equippable - replacing and returning any existing equippable of that EquipmentType
  public Optional<Equippable> equip(Equippable equippable) {
    Preconditions.checkNotNull(equippable);
    if(!equippable.canBeEquippedBy(creature)) {
      throw new IllegalArgumentException();
    }
    Equippable old = null;
    if(equipment.containsKey(equippable.getEquipmentType())) {
      old = equipment.get(equippable.getEquipmentType());
      unequip(old);
    }
    equippable.onEquip(creature);
    return Optional.fromNullable(old);
  }
  
  public void unequip(Equippable equippable) {
    Preconditions.checkNotNull(equippable);
    // Check that this equippable is currently equipped
    Preconditions.checkArgument(equippable.equals(equipment.get(equippable.getEquipmentType())));
    equippable.onUnequip(creature);
  }
}
