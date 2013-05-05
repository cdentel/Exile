package mechanics.modifier;

import java.util.Map;
import java.util.Set;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

public class Modifier<T extends Enum<T>> {
  
   private final ImmutableMap<T, Integer> modifiers;
   private final ModifierType modType;
   
   private Modifier(ModifierType modType) {
     this.modType = modType;
     modifiers = ImmutableMap.of();
   }
   
   private Modifier(ModifierType modType, Map<T, Integer> map) {
     modifiers = ImmutableMap.copyOf(map);
     this.modType = modType;
   }
   
   public ModifierType getModifierType() {
     return modType;
   }
   
    public Modifier<T> and(T type, int amount) {
      return new Modifier<T>(getModifierType(),
          ImmutableMap.<T, Integer>builder()
            .putAll(modifiers)
            .put(type, amount)
          .build());
    }
    
    public Modifier<T> add(Modifier<T> other) {
      Preconditions.checkNotNull(other);
      Preconditions.checkArgument(other.getModifierType().equals(this.getModifierType()));
      Builder<T, Integer> builder = ImmutableMap.<T, Integer>builder().putAll(modifiers);
      for(T type : other.modifiers.keySet()) {
        builder.put(type, get(type) + other.get(type));
      }
      return new Modifier<T>(getModifierType(), builder.build());
    }
    
    public Modifier<T> subtract(Modifier<T> other) {
      Preconditions.checkNotNull(other);
      Preconditions.checkArgument(other.getModifierType().equals(this.getModifierType()));
      Builder<T, Integer> builder = ImmutableMap.<T, Integer>builder().putAll(modifiers);
      for(T type : other.modifiers.keySet()) {
        builder.put(type, get(type) - other.get(type));
      }
      return new Modifier<T>(getModifierType(), builder.build());
    }
    public Set<T> getModified() {
      return modifiers.keySet();
    }
    
    
    public int get(T type) {
      return modifiers.containsKey(type) ? modifiers.get(type): 0;
    }
    
    public static <H extends Enum<H>> Modifier<H> of(ModifierType modType, H type, int value) {
      return new Modifier<H>(modType, ImmutableMap.of(type, value));
    }
    
    public static <H extends Enum<H>> Modifier<H> none(ModifierType modType) {
      return new Modifier<H>(modType);
    }
  }
