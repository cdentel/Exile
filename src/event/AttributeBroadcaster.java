package event;

import java.util.LinkedList;
import java.util.Map;

import mechanics.Attribute;
import mechanics.modifier.Modifiable;

import com.google.common.collect.Maps;

public class AttributeBroadcaster {
  
  private Map<Attribute<? extends Number>, LinkedList<AttributeListener<? extends Number>>> mapping = Maps.newHashMap();
  private Map<Class<? extends Attribute<? extends Number>>, Modifiable<? extends Attribute<? extends Number>, ? extends Number>> map = Maps.newHashMap();
  
  public <N extends Number> void subscribe(AttributeListener<N> receiver) {
   if(mapping.get(receiver.getAttribute()) == null) {
     mapping.put(receiver.getAttribute(), new LinkedList<AttributeListener<? extends Number>>());
   }
   mapping.get(receiver.getAttribute()).add(receiver);
  }
  
  public <N extends Number> void broadcast(Attribute<N> attr, N value) {
    if(mapping.get(attr) != null) {
      for(AttributeListener<? extends Number> br : mapping.get(attr)) {
        ((AttributeListener<N>) br).onBroadcast(value);
      }
    }
  }
  
  public <N extends Number> N poll(Attribute<N> attribute) {
    return ((Modifiable<Attribute<N>, N>) map.get(attribute.getClass())).get(attribute);
  }
  
  public <N extends Number, T extends  Attribute<N>> void provide(Class<T> attribute, Modifiable<T, N> provider) {
    map.put(attribute, provider);
  }

}
