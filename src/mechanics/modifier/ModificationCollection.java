package mechanics.modifier;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import mechanics.Attribute;
import mechanics.BonusSource;
import mechanics.modifier.numeric.Numeric;

import com.google.common.base.Preconditions;

import event.AttributeBroadcaster;


public class ModificationCollection<T extends Attribute<N>, N extends Number> {

  private Map<BonusSource, List<Modifier<T, N>>> modifications;

  private AttributeBroadcaster broadcaster;
  
  private Numeric<N> numeric;
  
  
  public ModificationCollection(Numeric<N> numeric, AttributeBroadcaster broadcaster) {
    modifications = new HashMap<>();
    this.numeric = numeric;
    for(BonusSource type : BonusSource.values()) {
      modifications.put(type, new LinkedList<Modifier<T, N>>());
    }
    this.broadcaster = broadcaster;
  }
  
  public void add(ImmutableModifier<T, N> modifier) {
    modifications.get(modifier.getModifierType()).add(modifier);
    broadcast(modifier.getModified());
  }
  
  private void broadcast(Set<T> attributes) {
    broadcaster.notify(attributes);
  }
  
  public void remove(ImmutableModifier<T, N> modifier) {
    Preconditions.checkArgument(modifications.containsKey(modifier));
    modifications.get(modifier.getModifierType()).remove(modifier);
    broadcast(modifier.getModified());

  }
  
  public N getTotal(T type) {
    N sum = numeric.zero();
    for(List<Modifier<T,N>> list : modifications.values()) {
      for(Modifier<T,N> mod : list) {
        sum = numeric.add(sum, mod.get(type));
      }
    }
    return sum;
  }
  
  public N getTypeTotal(T type, BonusSource modType) {
    N sum = numeric.zero();
    for(Modifier<T,N> mod : modifications.get(modType)) {
      sum = numeric.add(sum, mod.get(type));
    }
    return sum;
  }

}
