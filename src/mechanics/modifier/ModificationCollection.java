package mechanics.modifier;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import mechanics.modifier.numeric.Numeric;

import com.google.common.base.Preconditions;


public class ModificationCollection<T extends Enum<T>, N extends Number> {

  private Map<ModifierType, List<Modifier<T, N>>> modifications;
  private Map<ModifierType, ModifierTotal<T, N>> typeTotals;
  private ModifierTotal<T, N> total;
  
  
  public ModificationCollection(Numeric<N> numeric) {
    modifications = new HashMap<>();
    for(ModifierType type : ModifierType.values()) {
      modifications.put(type, new LinkedList<Modifier<T, N>>());
      typeTotals.put(type, new ModifierTotal<T, N>(numeric));
    }
    total = new ModifierTotal<>(numeric);
  }
  
  public void add(Modifier<T, N> modifier) {
    modifications.get(modifier.getModifierType()).add(modifier);
    typeTotals.get(modifier.getModifierType()).add(modifier);
    total.add(modifier);
  }
  
  public void remove(Modifier<T, N> modifier) {
    Preconditions.checkArgument(modifications.containsKey(modifier));
    modifications.get(modifier.getModifierType()).remove(modifier);
    typeTotals.get(modifier.getModifierType()).subtract(modifier);
    total.subtract(modifier);
  }
  
  public N getTotal(T type) {
    return total.get(type);
  }
  
  public N getTypeTotal(T type, ModifierType modType) {
    return typeTotals.get(modType).get(type);
  }

}
