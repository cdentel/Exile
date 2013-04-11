package mechanics;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import exceptions.ChoiceNotAllowedException;

public class Choice<T extends Enum<T>> {
  
  private int numberOfChoices;
  private final Set<T> choices;
  private final boolean canRepeat;
  private List<T> soFarChosen;
  
  private Choice(int numberOfChoices, Collection<T> choices, boolean canRepeat) {
    this.numberOfChoices = numberOfChoices;
    this.choices = Sets.newTreeSet(choices);
    this.canRepeat = canRepeat;
    this.soFarChosen = Lists.newArrayListWithCapacity(numberOfChoices);
  }
  
  public ImmutableSet<T> getChoices() {
    return ImmutableSet.copyOf(choices);
  }
  
  public int getNumberOfChoicesRemaining() {
    return numberOfChoices;
  }
  
  public boolean canChoose(T choice) {
    return choices.contains(choice);
  }
  
  public ImmutableList<T> choose(T choice) {
    if(!canChoose(choice)) {
      throw new ChoiceNotAllowedException();
    } else {
       soFarChosen.add(choice);
       if(!canRepeat) {
         choices.remove(choice);
       }
       numberOfChoices--;
       return ImmutableList.copyOf(soFarChosen);
    }
  }
  
  public boolean haveChosen(T choice) {
    return soFarChosen.contains(choice);
  }
  
  public static <T extends Enum<T>> Choice<T>  of(int numberOfChoices,  boolean canRepeat, Collection<T> choices) {
    return new Choice<>(numberOfChoices, choices, canRepeat);
  }
  
  public static <T extends Enum<T>> Choice<T>  of(int numberOfChoices,  boolean canRepeat, T[] choices) {
    return new Choice<>(numberOfChoices, Arrays.asList(choices), canRepeat);
  }
}
