package mechanics;

import java.util.Map;
import java.util.TreeMap;

public class Modifier<T extends Enum<T>> {
  
   private Map<T, Integer> modifiers;
   
   private Modifier() {
     modifiers = new TreeMap<>();
   }
   
    public Modifier<T> and(T type, int amount) {
      set(type, amount);
      return this;
    }
    
    public void set(T type, int amount) {
      modifiers.put(type, amount);
    }
    public int get(T type) {
      return modifiers.containsKey(type) ? modifiers.get(type): 0;
    }
    
    public static <H extends Enum<H>> Modifier<H> with(H type, int value) {
      return new Modifier<H>().and(type, value);
    }
    
    public static <H extends Enum<H>> Modifier<H> none() {
      return new Modifier<H>();
    }
  }
