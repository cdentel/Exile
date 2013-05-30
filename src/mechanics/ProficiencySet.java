package mechanics;

import java.util.Map;
import java.util.Set;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class ProficiencySet<T extends Enum<T>> {
  
  private Map<T, Set<BonusSource>> proficiencies = Maps.newTreeMap();
  
  public ProficiencySet() {}
  
  public void add(T proficiency, BonusSource source) {
    if(!proficiencies.containsKey(proficiency)) {
      proficiencies.put(proficiency, Sets.<BonusSource>newTreeSet());
    }
      proficiencies.get(proficiency).add(source);
  }
  
  public void addAll(Set<T> proficiencies, BonusSource source) {
    for(T proficiency : proficiencies) {
      add(proficiency, source);
    }
  }
  
  public void removeAll(Set<T> proficiencies, BonusSource source) {
    for(T proficiency : proficiencies) {
      remove(proficiency, source);
    }
  }
  
  public boolean remove(T proficiency, BonusSource source) {
    if(!proficiencies.containsKey(proficiency) || !proficiencies.get(proficiency).remove(source)) {
      throw new IllegalArgumentException("This proficieny set does not include a proficiency from that source");
    }
    if(proficiencies.get(proficiency).isEmpty()) {
      proficiencies.remove(proficiency);
      return true;
    }
    return false;
  }
  
  public boolean contains(Object o) {
    return proficiencies.keySet().contains(o);
  }
  
  public static <T extends Enum<T>> ProficiencySet<T> create() {
    return new ProficiencySet<>();
  }
}
