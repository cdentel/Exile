package mechanics.modifier.numeric;

public interface Numeric<N> {
  
  public N add(N n1, N n2);
  
  public N subtract(N n1, N n2);
  
  public N zero();

}
