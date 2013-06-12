package mechanics.defenses;

import java.util.Set;

import mechanics.Attribute;
import mechanics.BonusSource;
import mechanics.modifier.MutableModifier;

import com.google.common.collect.Sets;

import creatures.components.Attributes;
import event.AttributeBroadcaster;

public class AttributeDefenseModifier extends MutableModifier<DefenseType, Integer> {
  
  public AttributeDefenseModifier(AttributeBroadcaster broadcaster) {
    super(BonusSource.ATTRIBUTE, broadcaster);
  }

  @Override
  protected void onUpdate() {
    for(DefenseType type: DefenseType.values()) {
      int defense = Math.max(
          Attributes.getModifier(poll(type.first)),
          Attributes.getModifier(poll(type.second))
          );
      set(type, defense);
    }
  }

  @Override
  public Set<? extends Attribute<?>> getDependencies() {
    return Sets.newHashSet(DefenseType.values());
  }

}
