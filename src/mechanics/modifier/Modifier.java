package mechanics.modifier;

import java.util.Set;

import mechanics.BonusSource;

public interface Modifier<T, N> {
  
  public BonusSource getModifierType();
  
  public Set<T> getModified();
  
  public N get(T type);


}
