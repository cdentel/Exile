package powers.dragonborn;

import mechanics.DamageType;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;

import creatures.components.AttributeType;

public class DragonBreathOption {
  
  private AttributeType attributeType;
  private DamageType damageType;
  
  private DragonBreathOption(AttributeType attributeType, DamageType damageType) {
    Preconditions.checkArgument(getAttributeOptions().contains(attributeType));
    Preconditions.checkArgument(getDamageOptions().contains(damageType));
    this.attributeType = attributeType;
    this.damageType = damageType;
  }
  
  public AttributeType getChosenAttribute() {
    return attributeType;
  }
  
  public DamageType getChosenDamageType() {
    return damageType;
  }
  
  public static ImmutableSet<AttributeType> getAttributeOptions() {
    return ImmutableSet.of(
        AttributeType.STRENGTH, 
        AttributeType.CONSTITUTION, 
        AttributeType.DEXTERITY);
  }
  
  public static ImmutableSet<DamageType> getDamageOptions() {
    return ImmutableSet.of(
        DamageType.ACID, 
        DamageType.COLD, 
        DamageType.FIRE,
        DamageType.LIGHTNING, 
        DamageType.POISON);
  }
  
  public static DragonBreathOption withModifierAndDamageType(AttributeType modifier, DamageType damageType) {
    return new DragonBreathOption(modifier, damageType);
  }

}
