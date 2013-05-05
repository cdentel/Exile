package mechanics.modifier;

import com.google.common.base.Preconditions;

public abstract class Modifiable<T extends Enum<T>> {

  protected ModificationCollection<T> collection ;
  
  public Modifiable() {
    collection = new ModificationCollection<>();
  }
  
  public int get(T type) {
    Preconditions.checkNotNull(type);
    return collection.getTotal(type);
  }
  
  public int get(T type, ModifierType modType) {
    return collection.getTypeTotal(type, modType);
  }
  
  public void add(Modifier<T> modifier) {
    collection.add(modifier);
  }
  
  public void remove(Modifier<T> modifier) {
    collection.remove(modifier);
  }
}
