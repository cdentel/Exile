package exceptions;

public class ChoiceNotAllowedException extends RuntimeException {

  public ChoiceNotAllowedException() {
    super();
  }
  
  public ChoiceNotAllowedException(String string) {
    super(string);
  }

  /**
   * 
   */
  private static final long serialVersionUID = 3033160291744114786L;

}
