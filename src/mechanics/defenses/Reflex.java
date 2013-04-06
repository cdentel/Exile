package mechanics.defenses;

import static mechanics.Attribute.DEXTERITY;
import static mechanics.Attribute.INTELLIGENCE;
import creatures.Creature;

public class Reflex extends Defense {

  public Reflex(Creature c) {
    super(c);
  }

  @Override
  public int getAbility() {
    return Math.max(
        creature.attributes().getModifier(DEXTERITY), 
        creature.attributes().getModifier(INTELLIGENCE));
  }

  @Override
  public int getClassBonus() {
    return creature.getClazz().getReflexBonus();
  }

}
