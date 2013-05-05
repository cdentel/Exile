package mechanics.modifier.numeric;

public class IntegerNumeric implements Numeric<Integer> {

  @Override
  public Integer add(Integer n1, Integer n2) {
    if (n1 == null && n2 == null) {
      return zero();
    } else if (n1 == null || n2 == null) {
      return n1 == null ? n2 : n1;
    } else {
      return n1 + n2;
    }
  }

  @Override
  public Integer subtract(Integer n1, Integer n2) {
    if (n1 == null && n2 == null) {
      return zero();
    } else if (n1 == null || n2 == null) {
      return zero()- (n1 == null ? n2 : n1);
    } else {
      return n1 - n2;
    }
  }

  @Override
  public Integer zero() {
    return 0;
  }
  
  public static Numeric<Integer> INSTANCE() {
    return new IntegerNumeric();
  }

}
