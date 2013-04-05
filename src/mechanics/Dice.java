package mechanics;

import java.util.Collections;

import com.google.common.collect.Multiset;
import com.google.common.collect.TreeMultiset;

public class Dice {
  
  private Multiset<Die> dice;
  
  private Dice(Die... dies) {
    dice = TreeMultiset.create();
    Collections.addAll(dice, dies);
  }
  
  public static Dice with(Die... dies) {
    return new Dice(dies);
  }
  
}
