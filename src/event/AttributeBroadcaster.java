package event;

import java.util.Map;
import java.util.Set;

import mechanics.Attribute;
import mechanics.modifier.Modifiable;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;


public class AttributeBroadcaster {
  
    private Map<Attribute<?>, Set<Notifier>> listeners;
    private Map<Class<? extends Attribute<? extends Number>>, Modifiable<? extends Attribute<? extends Number>, ? extends Number>> map = Maps.newHashMap();
    
    public void listen(Attribute<?> attribute, Notifier notifier) {
      if(!listeners.containsKey(attribute)) {
        listeners.put(attribute, Sets.<Notifier>newLinkedHashSet());
      }
      listeners.get(attribute).add(notifier);
    }
    
    public void listen(Set<? extends Attribute<?>> dependencies,
        Notifier notifier) {
      for(Attribute<?> attr : dependencies) {
        listen(attr, notifier);
      }
      
    }
    
    public void notify(Attribute<?> attribute) {
      if(listeners.containsKey(attribute)) {
        for(Notifier notifier : listeners.get(attribute)) {
          notifier.onNotify();
        }
      }
    }
    
    public void notify(Iterable<? extends Attribute<?>> attributes) {
      for(Attribute<?> attr : attributes) {
        notify(attr);
      }
    }
    
    public <N extends Number> N poll(Attribute<N> attribute) {
      return ((Modifiable<Attribute<N>, N>) map.get(attribute.getClass())).get(attribute);
    }
    
    public <N extends Number, T extends  Attribute<N>> void provide(Class<T> attribute, Modifiable<T, N> provider) {
      map.put(attribute, provider);
    }

}
