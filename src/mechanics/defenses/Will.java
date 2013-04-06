package mechanics.defenses;

import static mechanics.Attribute.CHARISMA;
import static mechanics.Attribute.WISDOM;
import creatures.Creature;

public class Will extends Defense {

  public Will(Creature c) {
    super(c);
  }

  @Override
  public int getAbility() {
    return Math.max(
        creature.attributes().getModifier(WISDOM), 
        creature.attributes().getModifier(CHARISMA));
  }

  @Override
  public int getClassBonus() {
    return creature.getClazz().getWillBonus();
  }

}
