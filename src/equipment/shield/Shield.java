package equipment.shield;

import equipment.Implement;

public class Shield extends Implement {
  
  private ShieldMaterialType type;
  private ShieldSize size;
  
  public Shield(ShieldMaterialType type, ShieldSize size) {
    this.type = type;
    this.size = size;
  }
  
  
  
  @Override
  public double getWeight() {
    return type.weight * size.sizeModifier;
  }
  
  @Override
  public int getArmorClassModifer() {
    return (int) (type.acValue * size.sizeModifier);
  }
}
