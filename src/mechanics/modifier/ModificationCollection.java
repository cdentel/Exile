package mechanics.modifier;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.google.common.base.Preconditions;


public class ModificationCollection<T extends Enum<T>> {

  private Map<ModifierType, List<Modifier<T>>> modifications;
  private Map<ModifierType, Modifier<T>> typeTotals;
  private ModifierTotal<T> total;
  
  
  public ModificationCollection() {
    modifications = new HashMap<>();
    for(ModifierType type : ModifierType.values()) {
      modifications.put(type, new LinkedList<Modifier<T>>());
      typeTotals.put(type, Modifier.<T>none(type));
    }
    total = new ModifierTotal<>();
  }
  
  public void add(Modifier<T> modifier) {
    modifications.get(modifier.getModifierType()).add(modifier);
    typeTotals.put(modifier.getModifierType(), typeTotals.get(modifier.getModifierType()).add(modifier));
    total.add(modifier);
  }
  
  public void remove(Modifier<T> modifier) {
    Preconditions.checkArgument(modifications.containsKey(modifier));
    modifications.get(modifier.getModifierType()).remove(modifier);
    typeTotals.put(modifier.getModifierType(), typeTotals.get(modifier.getModifierType()).subtract(modifier));
    total.subtract(modifier);
  }
  
  public Integer getTotal(T type) {
    return total.get(type);
  }
  
  public Integer getTypeTotal(T type, ModifierType modType) {
    return typeTotals.get(modType).get(type);
  }

}
