package mechanics.defenses;

import static mechanics.Attribute.CONSTITUTION;
import static mechanics.Attribute.STRENGTH;
import creatures.Creature;

public class Fortitude extends Defense {

  public Fortitude(Creature c) {
    super(c);
  }

  @Override
  public int getAbility() {
    return Math.max(
        creature.attributes().getModifier(STRENGTH), 
        creature.attributes().getModifier(CONSTITUTION));
  }

  @Override
  public int getClassBonus() {
    return creature.getClazz().getFortitudeBonus();
  }

}
