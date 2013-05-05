package mechanics.modifier;

import java.util.Map;
import java.util.Set;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableMap;

public class Modifier<T extends Enum<T>, N extends Number> {
  
   private final ImmutableMap<T, N> modifiers;
   private final ModifierType modType;
   
   private Modifier(ModifierType modType) {
     this.modType = modType;
     modifiers = ImmutableMap.of();
   }
   
   private Modifier(ModifierType modType, Map<T, N> map) {
     modifiers = ImmutableMap.copyOf(map);
     this.modType = modType;
   }
   
   public ModifierType getModifierType() {
     return modType;
   }
   
    public Modifier<T, N> and(T type, N amount) {
      return new Modifier<T, N>(getModifierType(),
          ImmutableMap.<T, N>builder()
            .putAll(modifiers)
            .put(type, amount)
          .build());
    }
    
    public Set<T> getModified() {
      return modifiers.keySet();
    }
    
    @Override
    public boolean equals(Object other) {
      if(!(other instanceof Modifier)) {
        return false;
      }
      @SuppressWarnings("rawtypes")
      Modifier mod = (Modifier) other;
      return modifiers.equals(mod.modifiers) && modType.equals(mod.modType);
    }
    
    @Override
    public int hashCode() {
      return Objects.hashCode(modifiers, modType);
    }
    
    
    public N get(T type) {
      return modifiers.containsKey(type) ? modifiers.get(type): null;
    }
    
    public static <H extends Enum<H>, N extends Number> Modifier<H, N> of(ModifierType modType, H type, N value) {
      return new Modifier<H, N>(modType, ImmutableMap.of(type, value));
    }
    
    public static <H extends Enum<H>, N extends Number> Modifier<H, N> none(ModifierType modType) {
      return new Modifier<H, N>(modType);
    }
  }
