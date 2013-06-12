package mechanics.modifier;

import java.util.Map;

import mechanics.Attribute;
import mechanics.modifier.numeric.Numeric;

import com.google.common.collect.Maps;

public class ModifierTotal<T extends Attribute<N>, N extends Number> {
    
    private Map<T, N> totals;
    private Numeric<N> numeric;
    
    public ModifierTotal(Numeric<N> numeric) {
      totals = Maps.newLinkedHashMap();
    }
    
    public N get(T type) {
      return totals.get(type);
    }
    
    public void add(ImmutableModifier<T, N> modifier) {
      for(T type: modifier.getModified()) {
        if(totals.containsKey(type)) {
          totals.put(type, numeric.add(totals.get(type), modifier.get(type)));
        } else {
          totals.put(type, modifier.get(type));
        }
      }
    }

    public void subtract(ImmutableModifier<T, N> modifier) {
      for(T type: modifier.getModified()) {
        if(totals.containsKey(type)) {
          totals.put(type, numeric.subtract(totals.get(type),  modifier.get(type)));
        } else {
          totals.put(type, numeric.subtract(null,  modifier.get(type)));
        }
      }
    }
  }
  