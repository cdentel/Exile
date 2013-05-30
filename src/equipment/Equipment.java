package equipment;

import java.util.Map;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;

import creatures.Creature;

public class Equipment {
  
  private Creature creature;
  
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
