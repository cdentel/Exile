package mechanics.dice;

import java.util.Collection;
import java.util.Collections;

import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.TreeMultiset;

public class Dice implements Rollable {
  
  private Multiset<Die> dice;
  
  private Dice(Die... dies) {
    dice = TreeMultiset.create();
    Collections.addAll(dice, dies);
  }
  
  private Dice(Collection<Die> dies) {
    dice = TreeMultiset.create(dies);
  }
  
  public static Dice with(Die... dies) {
    return new Dice(dies);
  }
  
  public int roll() {
    int sum = 0;
    for(Die d : dice) {
      sum += d.roll();
    }
    return sum;
  }
  
  public int critValue() {
    int sum = 0;
    for(Die d : dice) {
      sum += d.critValue();
    }
    return sum;
  }

  public Dice add(Dice other) {
    return new Dice(Multisets.sum(dice, other.dice));
  }
  
}
