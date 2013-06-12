package equipment;

import mechanics.modifier.ImmutableModifier;
import creatures.components.BurdenType;

public interface Item {

  public ImmutableModifier<BurdenType, Integer> getBurdenModifier();
}
