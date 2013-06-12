package mechanics.modifier;

import java.util.Map;
import java.util.Set;

import mechanics.Attribute;
import mechanics.BonusSource;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableMap;

import event.AttributeBroadcaster;
import event.Notifier;

public abstract class MutableModifier<T extends Attribute<N>, N extends Number> implements Modifier<T, N> {
  
   private final Map<T, N> modifiers;
   private final BonusSource modType;
   private final AttributeBroadcaster broadcaster;
   
   public MutableModifier(BonusSource modType, AttributeBroadcaster broadcaster) {
     this.modType = modType;
     modifiers = ImmutableMap.of();
     this.broadcaster = broadcaster;
     broadcaster.listen(getDependencies(), new Notifier() {
       public void onNotify(){
         onUpdate();
       }
     });
   }
   
   public BonusSource getModifierType() {
     return modType;
   }
   
   public void set(T attribute, N value) {
     if(get(attribute) != value) {
       modifiers.put(attribute, value);
       broadcaster.notify(attribute);
     }
   }
   
   protected abstract void onUpdate();
   
   protected <V extends Number> V poll(Attribute<V> attribute) {
     return broadcaster.poll(attribute);
   }
   
   public abstract Set<? extends Attribute<?>> getDependencies();
   
    public Set<T> getModified() {
      return modifiers.keySet();
    }
    
    @Override
    public boolean equals(Object other) {
      if(!(other instanceof MutableModifier)) {
        return false;
      }
      @SuppressWarnings("rawtypes")
      MutableModifier mod = (MutableModifier) other;
      return modifiers.equals(mod.modifiers) && modType.equals(mod.modType);
    }
    
    @Override
    public int hashCode() {
      return Objects.hashCode(modifiers, modType);
    }
    
    
    public N get(T type) {
      return modifiers.containsKey(type) ? modifiers.get(type): null;
    }
  }
