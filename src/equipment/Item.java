package equipment;

import mechanics.modifier.Modifier;
import creatures.components.BurdenType;

public interface Item {

  public Modifier<BurdenType, Integer> getBurdenModifier();
}
