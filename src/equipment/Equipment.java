package equipment;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

import equipment.shield.Shield;
import equipment.weapon.Weapon;
import equipment.wearable.Footwear;
import equipment.wearable.Handwear;
import equipment.wearable.Torso;

public class Equipment {
  
  private Optional<Torso> torso;
  private Optional<Handwear> handwear;
  private Optional<Footwear> footwear;
  private Optional<Shield> leftHand;
  private Optional<Weapon> rightHand;
  
  public Equipment() {/*Naked*/}
  
  public int getAmorClassModifier() {
    return 
          (torso.isPresent()      ? torso.get().getArmorClassModifer()      : 0)
        + (handwear.isPresent()   ? handwear.get().getArmorClassModifer()   : 0) 
        + (footwear.isPresent()   ? footwear.get().getArmorClassModifer()   : 0)
        + (leftHand.isPresent()   ? leftHand.get().getArmorClassModifer()   : 0)
        + (rightHand.isPresent()  ? rightHand.get().getArmorClassModifer()  : 0);
  }
  
  public int getMovementModifer() {
    return 
          (torso.isPresent()    ? torso.get().getMovementModifer()    : 0)
        + (handwear.isPresent() ? handwear.get().getMovementModifer() : 0) 
        + (footwear.isPresent() ? footwear.get().getMovementModifer() : 0);
  }
  
  public double getWeight() {
    return 
          (torso.isPresent()      ? torso.get().getWeight()     : 0)
        + (handwear.isPresent()   ? handwear.get().getWeight()  : 0) 
        + (footwear.isPresent()   ? footwear.get().getWeight()  : 0)
        + (leftHand.isPresent()   ? leftHand.get().getWeight()  : 0)
        + (rightHand.isPresent()  ? rightHand.get().getWeight() : 0);
  }
  
  public Optional<Torso> getTorso() {
    return torso;
  }
  
  public void setTorso(Torso torso) {
    Preconditions.checkNotNull(torso);
    this.torso = Optional.of(torso);
  }
  
  public Torso removeTorso() {
    Preconditions.checkState(torso.isPresent());
    Torso temporary = torso.get();
    torso = Optional.absent();
    return temporary;
  }
  
  public Optional<Handwear> getHandwear() {
    return handwear;
  }
  
  public void setHandwear(Handwear handwear) {
    Preconditions.checkNotNull(handwear);
    this.handwear = Optional.of(handwear);
  }
  
  public Handwear removeHandwear() {
    Preconditions.checkState(handwear.isPresent());
    Handwear temporary = handwear.get();
    handwear = Optional.absent();
    return temporary;
  }
  
  public Optional<Footwear> getFootwear() {
    return footwear;
  }
  public void setFootwear(Footwear footwear) {
    Preconditions.checkNotNull(footwear);
    this.footwear = Optional.of(footwear);
  }
  
  public Footwear removeFootwear() {
    Preconditions.checkState(footwear.isPresent());
    Footwear temporary = footwear.get();
    footwear = Optional.absent();
    return temporary;
  }

  public Optional<Shield> getLeftHand() {
    return leftHand;
  }

  public void setLeftHand(Shield leftHand) {
    Preconditions.checkNotNull(leftHand);
    this.leftHand = Optional.of(leftHand);
  }
  
  public Shield removeLeftHand() {
    Preconditions.checkState(leftHand.isPresent());
    Shield temporary = leftHand.get();
    leftHand = Optional.absent();
    return temporary;
  }

  public Optional<Weapon> getRightHand() {
    return rightHand;
  }

  public void setRightHand(Weapon rightHand) {
    Preconditions.checkNotNull(rightHand);
    this.rightHand = Optional.of(rightHand);
  }
  
  public Weapon removeRightHand() {
    Preconditions.checkState(rightHand.isPresent());
    Weapon temporary = rightHand.get();
    rightHand = Optional.absent();
    return temporary;
  }
}
