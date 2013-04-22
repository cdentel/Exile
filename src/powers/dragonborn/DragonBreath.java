package powers.dragonborn;

import mechanics.Damage;
import mechanics.defenses.DefenseType;
import mechanics.dice.Dice;
import mechanics.dice.Die;
import powers.AttackPower;
import powers.PowerFrequency;
import powers.PowerType;
import creatures.components.AttributeType;
import creatures.components.Attributes;

public class DragonBreath extends AttackPower {
  
  private DragonBreathOption option;
  private Attributes attackerAttributes;
  
  public DragonBreath(DragonBreathOption option, Attributes attackerAttributes) {
    this.attackerAttributes = attackerAttributes;
    this.option = option;
  }

  @Override
  public PowerType getPowerType() {
    return PowerType.MINOR;
  }

  @Override
  public PowerFrequency getPowerFrequency() {
    return PowerFrequency.ENCOUNTER;
  }

  @Override
  public Damage getDamage() {
    return Damage.of(
        option.getChosenDamageType(), 
        attackerAttributes.get(AttributeType.CONSTITUTION).getModifier(), 
        Dice.with(Die.d6));
  }

  @Override
  public int getAttackRollModifier() {
    return 2;
  }

  @Override
  public AttributeType getAttributeUsed() {
    return option.getChosenAttribute();
  }

  @Override
  public DefenseType getDefenseType() {
    return DefenseType.REFLEX;
  }
}
