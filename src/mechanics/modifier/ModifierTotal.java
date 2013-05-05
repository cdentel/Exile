package mechanics.modifier;

import java.util.Map;

import mechanics.modifier.numeric.Numeric;

import com.google.common.collect.Maps;

public class ModifierTotal<T extends Enum<T>, N extends Number> {
    
    private Map<T, N> totals;
    private Numeric<N> numeric;
    
    public ModifierTotal(Numeric<N> numeric) {
      totals = Maps.newTreeMap();
    }
    
    public N get(T type) {
      return totals.get(type);
    }
    
    public void add(Modifier<T, N> modifier) {
      for(T type: modifier.getModified()) {
        if(totals.containsKey(type)) {
          totals.put(type, numeric.add(totals.get(type), modifier.get(type)));
        } else {
          totals.put(type, modifier.get(type));
        }
      }
    }

    public void subtract(Modifier<T, N> modifier) {
      for(T type: modifier.getModified()) {
        if(totals.containsKey(type)) {
          totals.put(type, numeric.subtract(totals.get(type),  modifier.get(type)));
        } else {
          totals.put(type, numeric.subtract(null,  modifier.get(type)));
        }
      }
    }
  }
  