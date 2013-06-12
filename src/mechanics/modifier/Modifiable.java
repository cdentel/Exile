package mechanics.modifier;

import mechanics.Attribute;
import mechanics.BonusSource;
import mechanics.modifier.numeric.Numeric;

import com.google.common.base.Preconditions;

import event.AttributeBroadcaster;

public abstract class Modifiable<T extends Attribute<N>, N extends Number> {

  protected ModificationCollection<T, N> collection ;
  
  protected Modifiable(Numeric<N> numeric, AttributeBroadcaster broadcaster) {
    collection = new ModificationCollection<>(numeric, broadcaster);
  }
  
  public N get(T type) {
    Preconditions.checkNotNull(type);
    return collection.getTotal(type);
  }
  
  public N get(T type, BonusSource modType) {
    return collection.getTypeTotal(type, modType);
  }
  
  public void add(ImmutableModifier<T, N> modifier) {
    collection.add(modifier);
  }
  
  public void remove(ImmutableModifier<T, N> modifier) {
    collection.remove(modifier);
  }
}
