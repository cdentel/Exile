package creatures.components;

public enum Language {
  COMMON(Script.COMMON), 
  DEEP_SPEECH(Script.RELLANIC), 
  DRACONIC(Script.IOKHARIC),
  DWARVEN(Script.DAVEK),
  ELVEN(Script.RELLANIC),
  GIANT(Script.DAVEK),
  GOBLIN(Script.COMMON),
  PRIMORDIAL(Script.BARAZHAD),
  SUPERNAL(Script.SUPERNAL),
  ABYSSAL(Script.BARAZHAD);
  
  public final Script script;
  
  private Language(Script script) {
    this.script = script;
  }
  
  public enum Script {
    BARAZHAD, COMMON, DAVEK, IOKHARIC, RELLANIC, SUPERNAL;
  }
}
