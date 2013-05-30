package mechanics.modifier;

import mechanics.BonusSource;
import mechanics.modifier.numeric.Numeric;

import com.google.common.base.Preconditions;

public abstract class Modifiable<T extends Enum<T>, N extends Number> {

  protected ModificationCollection<T, N> collection ;
  
  protected Modifiable(Numeric<N> numeric) {
    collection = new ModificationCollection<>(numeric);
  }
  
  public N get(T type) {
    Preconditions.checkNotNull(type);
    return collection.getTotal(type);
  }
  
  public N get(T type, BonusSource modType) {
    return collection.getTypeTotal(type, modType);
  }
  
  public void add(Modifier<T, N> modifier) {
    collection.add(modifier);
  }
  
  public void remove(Modifier<T, N> modifier) {
    collection.remove(modifier);
  }
}
