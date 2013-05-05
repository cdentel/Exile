package mechanics.modifier;

import java.util.Map;

import com.google.common.collect.Maps;

public class ModifierTotal<T extends Enum<T>> {
    
    private Map<T, Integer> totals;
    
    public ModifierTotal() {
      totals = Maps.newTreeMap();
    }
    
    public Integer get(T type) {
      return totals.get(type);
    }
    
    public void add(Modifier<T> modifier) {
      for(T type: modifier.getModified()) {
        if(totals.containsKey(type)) {
          totals.put(type, totals.get(type) + modifier.get(type));
        } else {
          totals.put(type, modifier.get(type));
        }
      }
    }
    
    public void subtract(Modifier<T> modifier) {
      for(T type: modifier.getModified()) {
        if(totals.containsKey(type)) {
          totals.put(type, totals.get(type) - modifier.get(type));
        } else {
          totals.put(type, 0 - modifier.get(type));
        }
      }
      
    }
  }
  