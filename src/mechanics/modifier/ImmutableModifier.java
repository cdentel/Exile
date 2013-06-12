package mechanics.modifier;

import java.util.Map;
import java.util.Set;

import mechanics.Attribute;
import mechanics.BonusSource;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableMap;

public class ImmutableModifier<T extends Attribute<N>, N extends Number> implements Modifier<T, N>{
  
   private final ImmutableMap<T, N> modifiers;
   private final BonusSource modType;
   
   private ImmutableModifier(BonusSource modType) {
     this.modType = modType;
     modifiers = ImmutableMap.of();
   }
   
   private ImmutableModifier(BonusSource modType, Map<T, N> map) {
     modifiers = ImmutableMap.copyOf(map);
     this.modType = modType;
   }
   
   public BonusSource getModifierType() {
     return modType;
   }
   
    public ImmutableModifier<T, N> and(T type, N amount) {
      return new ImmutableModifier<T, N>(getModifierType(),
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
      if(!(other instanceof ImmutableModifier)) {
        return false;
      }
      @SuppressWarnings("rawtypes")
      ImmutableModifier mod = (ImmutableModifier) other;
      return modifiers.equals(mod.modifiers) && modType.equals(mod.modType);
    }
    
    @Override
    public int hashCode() {
      return Objects.hashCode(modifiers, modType);
    }
    
    
    public N get(T type) {
      return modifiers.containsKey(type) ? modifiers.get(type): null;
    }
    
    public static <H extends Attribute<N>, N extends Number> ImmutableModifier<H, N> of(BonusSource modType, H type, N value) {
      return new ImmutableModifier<H, N>(modType, ImmutableMap.of(type, value));
    }
    
    public static <H extends Attribute<N>, N extends Number> ImmutableModifier<H, N> none(BonusSource modType) {
      return new ImmutableModifier<H, N>(modType);
    }
  }
