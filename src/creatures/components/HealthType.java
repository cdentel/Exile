package creatures.components;

import mechanics.Attribute;

public enum HealthType implements Attribute<Integer> {
  HP, MAX_HP, MAX_SURGES, SURGES, SURGE_VALUE
}
