package event;

import java.util.HashMap;
import java.util.LinkedList;

import mechanics.Attribute;

import com.google.common.collect.Maps;

public class AttributeBroadcaster {
  
  private static final AttributeBroadcaster INSTANCE = new AttributeBroadcaster();
  
  public static AttributeBroadcaster INSTANCE() {
    return INSTANCE;
  }
  
  private HashMap<Attribute<? extends Number>, LinkedList<AttributeListener<? extends Number>>> mapping = Maps.newHashMap();
  
  public <N extends Number> void subscribe(AttributeListener<N> receiver) {
   if(mapping.get(receiver.getAttribute()) == null) {
     mapping.put(receiver.getAttribute(), new LinkedList<AttributeListener<? extends Number>>());
   }
   mapping.get(receiver.getAttribute()).add(receiver);
  }
  
  public <N extends Number> void broadcast(Attribute<N> attr, N value) {
    for(AttributeListener<? extends Number> br : mapping.get(attr)) {
      ((AttributeListener<N>) br).onBroadcast(value);
    }
  }

}
