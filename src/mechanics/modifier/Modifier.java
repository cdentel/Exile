package mechanics.modifier;

import java.util.Map;
import java.util.Set;

import mechanics.Attribute;
import mechanics.BonusSource;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableMap;

public class Modifier<T extends Attribute<N>, N extends Number> {
  
   private final ImmutableMap<T, N> modifiers;
   private final BonusSource modType;
   
   private Modifier(BonusSource modType) {
     this.modType = modType;
     modifiers = ImmutableMap.of();
   }
   
   private Modifier(BonusSource modType, Map<T, N> map) {
     modifiers = ImmutableMap.copyOf(map);
     this.modType = modType;
   }
   
   public BonusSource getModifierType() {
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
    
    public static <H extends Attribute<N>, N extends Number> Modifier<H, N> of(BonusSource modType, H type, N value) {
      return new Modifier<H, N>(modType, ImmutableMap.of(type, value));
    }
    
    public static <H extends Attribute<N>, N extends Number> Modifier<H, N> none(BonusSource modType) {
      return new Modifier<H, N>(modType);
    }
  }
