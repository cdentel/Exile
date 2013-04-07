package equipment.shield;

import equipment.Implement;

public class Shield extends Implement {
  
  private ShieldType size;
  
  public Shield(ShieldType size) {
    this.size = size;
  }
  
  public ShieldType getShieldType() {
    return size;
  }
  
  @Override
  public int getWeight() {
    return size.weight;
  }
  
  @Override
  public int getArmorClassModifer() {
    return (size.armorBonus);
  }
}
