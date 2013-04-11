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

public class ModifierChoice<T extends Enum<T>> {
  
  private int numberOfChoices;
  private int modifierAmount;
  private final Set<T> choices;
  private List<T> soFarChosen;
  private Modifier<T> modifier;
  
  private ModifierChoice(int numberOfChoices, int modifierAmount, Collection<T> choices) {
    this.numberOfChoices = numberOfChoices;
    this.choices = Sets.newTreeSet(choices);
    this.soFarChosen = Lists.newArrayListWithCapacity(numberOfChoices);
    this.modifierAmount = modifierAmount;
    this.modifier = Modifier.none();
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
       modifier.set(choice, modifierAmount);
       choices.remove(choice);
       numberOfChoices--;
       return ImmutableList.copyOf(soFarChosen);
    }
  }
  
  public Modifier<T> modifier() {
    return modifier;
  }
  
  public boolean haveChosen(T choice) {
    return soFarChosen.contains(choice);
  }
  
  public static <T extends Enum<T>> ModifierChoice<T>  of(int numberOfChoices,  int amountOfModifier, Collection<T> choices) {
    return new ModifierChoice<>(numberOfChoices, amountOfModifier, choices);
  }
  
  public static <T extends Enum<T>> ModifierChoice<T>  of(int numberOfChoices, int amountOfModifier, T[] choices) {
    return new ModifierChoice<>(numberOfChoices, amountOfModifier,  Arrays.asList(choices));
  }
  
  public static <T extends Enum<T>> ModifierChoice<T>  none() {
    return new ModifierChoice<>(0, 0, Lists.<T>newArrayList());
  }
}
