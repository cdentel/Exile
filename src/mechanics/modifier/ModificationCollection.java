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
  private Map<BonusSource, ModifierTotal<T, N>> typeTotals;
  private ModifierTotal<T, N> total;
  private AttributeBroadcaster broadcaster;
  
  
  public ModificationCollection(Numeric<N> numeric, AttributeBroadcaster broadcaster) {
    modifications = new HashMap<>();
    typeTotals = new HashMap<>();
    for(BonusSource type : BonusSource.values()) {
      modifications.put(type, new LinkedList<Modifier<T, N>>());
      typeTotals.put(type, new ModifierTotal<T, N>(numeric));
    }
    total = new ModifierTotal<>(numeric);
    this.broadcaster = broadcaster;
  }
  
  public void add(Modifier<T, N> modifier) {
    modifications.get(modifier.getModifierType()).add(modifier);
    typeTotals.get(modifier.getModifierType()).add(modifier);
    total.add(modifier);
    broadcast(modifier.getModified());
  }
  
  private void broadcast(Set<T> attributes) {
    for(T attribute : attributes) {
      broadcaster.broadcast(attribute, total.get(attribute));
    }
  }
  
  public void remove(Modifier<T, N> modifier) {
    Preconditions.checkArgument(modifications.containsKey(modifier));
    modifications.get(modifier.getModifierType()).remove(modifier);
    typeTotals.get(modifier.getModifierType()).subtract(modifier);
    total.subtract(modifier);
    broadcast(modifier.getModified());

  }
  
  public N getTotal(T type) {
    return total.get(type);
  }
  
  public N getTypeTotal(T type, BonusSource modType) {
    return typeTotals.get(modType).get(type);
  }

}
