package creatures.components;

public enum AttributeType {
  STRENGTH, 
  CONSTITUTION, 
  DEXTERITY, 
  WISDOM, 
  INTELLIGENCE, 
  CHARISMA;
  
  public String getAbbreviation() {
    return this.name().substring(0, 3);
  }
  
  @Override
  public String toString() {
    return "" + name().charAt(0) + name().substring(1).toLowerCase();
  }
}
