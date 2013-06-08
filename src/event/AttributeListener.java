/**
 * 
 */
package event;

import mechanics.Attribute;



public abstract class AttributeListener<N extends Number> {
  
  public final Attribute<N> attribute;
  
  public AttributeListener(Attribute<N> attribute) {
    this.attribute = attribute;
  }
  
  public Attribute<N> getAttribute() {
    return attribute;
  }
  
  public abstract void onBroadcast(N number);

}
