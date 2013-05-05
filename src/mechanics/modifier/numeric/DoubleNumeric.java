package mechanics.modifier.numeric;

public class DoubleNumeric implements Numeric<Double> {
  
  private DoubleNumeric() {}

  @Override
  public Double add(Double n1, Double n2) {
    if (n1 == null && n2 == null) {
      return zero();
    } else if (n1 == null || n2 == null) {
      return n1 == null ? n2 : n1;
    } else {
      return n1 + n2;
    }
  }

  @Override
  public Double subtract(Double n1, Double n2) {
    if (n1 == null && n2 == null) {
      return zero();
    } else if (n1 == null || n2 == null) {
      return zero()- (n1 == null ? n2 : n1);
    } else {
      return n1 - n2;
    }
  }

  @Override
  public Double zero() {
    return 0.d;
  }
  
  public static DoubleNumeric INSTANCE = new DoubleNumeric();
  
  public static Numeric<Double> INSTANCE() {
    return INSTANCE;
  }

}
