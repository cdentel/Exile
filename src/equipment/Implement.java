package equipment;


public abstract class Implement implements Item {
  
   public int getArmorClassModifer() {
    return 0;
  }
   
   public abstract ImplementType getImplementType();
   
   public enum ImplementType {
     WEAPON, SHIELD;
   }

}
