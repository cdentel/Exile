package equipment;

import creatures.Creature;

public interface Equippable extends Item{
  
  public EquipmentType getEquipmentType();
  
  public void onEquip(Creature c);
  
  public void onUnequip(Creature c);
  
  public boolean canBeEquippedBy(Creature c);

}
