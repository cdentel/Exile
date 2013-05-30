package graphics;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.Panel;

import javax.swing.JFrame;

import mechanics.BonusSource;
import mechanics.defenses.DefenseType;
import mechanics.skills.SkillType;
import creatures.Creature;
import creatures.components.AttributeType;

public class CreatureViewer extends JFrame {
  
  private Creature creature;
  
  public CreatureViewer(Creature c) {
    super();
    this.creature = c;
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    GridBagLayout layout = new GridBagLayout();
    Panel content = new Panel(layout);
    GridBagConstraints constraints = new GridBagConstraints();
    content.setBackground(Color.BLACK);
    constraints.fill = GridBagConstraints.BOTH;
    
    constraints.anchor = GridBagConstraints.BASELINE;
    constraints.gridwidth = 3;
    constraints.gridheight =5;
    addTo(getAttributes(), content, layout, constraints);
    
    constraints.gridwidth = 2;
    constraints.gridheight =5;
    addTo(getHealth(), content, layout, constraints);
    
    
    
    constraints.gridx = 0;
    constraints.gridwidth = 5;
    constraints.gridy = 5;
    addTo(getDefenses(), content, layout, constraints);
    
    constraints.gridx = GridBagConstraints.RELATIVE;
    constraints.gridy = 0;
    constraints.gridwidth = GridBagConstraints.REMAINDER;
    constraints.gridheight = 10;
    addTo(getSkills(), content, layout, constraints);
    
    content.setSize(600, 600);
    add(content);
    pack();
    setVisible(true);
  }
  
  
  public Container getAttributes() {
    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints constraints = new GridBagConstraints();
    constraints.fill = GridBagConstraints.BOTH;
    constraints.gridy = 0;
    Panel attr = new Panel(layout);
    attr.setBackground(Color.WHITE);
    constraints.gridwidth = 1;
    constraints.gridheight =1;
    
    addTo(new Label("Scr"), attr, layout, constraints);
    constraints.gridwidth = 2;
    addTo(new Label("Attr"), attr, layout, constraints);
    constraints.gridwidth = 1;
    addTo(new Label("Mod"), attr, layout, constraints);
    addTo(new Label("MhL"), attr, layout, constraints);

    for(AttributeType a : AttributeType.values()) {
      constraints.gridy++;
      addTo(new Label("" + creature.attributes().get(a)), attr, layout, constraints);
      constraints.gridwidth = 2;
      addTo(new Label(a.toString()), attr, layout, constraints);
      constraints.gridwidth = 1;
      addTo(new Label("" + creature.attributes().getModifier(a)), attr, layout, constraints);
      addTo(new Label("" + creature.attributes().getModifier(a) + creature.getLevel() / 2), attr, layout, constraints);
    }
    attr.setPreferredSize(new Dimension(400, 450));
    return attr;
    
  }
  
  public Container getDefenses() {
    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints constraints = new GridBagConstraints();
    constraints.fill = GridBagConstraints.BOTH;
    constraints.gridy = 0;
    Panel defenses = new Panel(layout);
    defenses.setBackground(Color.WHITE);
    constraints.gridwidth = 1;
    constraints.gridheight =1;

    addTo(new Label("Scr"), defenses, layout, constraints);
    constraints.gridwidth = 2;
    addTo(new Label("Dfns"), defenses, layout, constraints);
    constraints.gridwidth = 1;
    addTo(new Label("Armr"), defenses, layout, constraints);
    addTo(new Label("Mod"), defenses, layout, constraints);
    addTo(new Label("hL"), defenses, layout, constraints);
    addTo(new Label("Race"), defenses, layout, constraints);
    addTo(new Label("Class"), defenses, layout, constraints);
    for(DefenseType d : DefenseType.values()) {
      constraints.gridy++;
      addTo(new Label("" + creature.defenses().get(d)), defenses, layout, constraints);
      constraints.gridwidth = 2;
      addTo(new Label(d.getAbbreviation()), defenses, layout, constraints);
      constraints.gridwidth = 1;
      addTo(
          d.equals(DefenseType.AC) 
            ? new Label("" + creature.defenses().get(d))
            : new Label("0"), defenses, layout, constraints);
      addTo(new Label("" + creature.defenses().get(d, BonusSource.ATTRIBUTE)), defenses, layout, constraints);
      addTo(new Label("" + creature.getLevel()/2), defenses, layout, constraints);
      addTo(new Label("" + creature.defenses().get(d, BonusSource.RACE)), defenses, layout, constraints);
      addTo(new Label("" + creature.defenses().get(d, BonusSource.CLAZZ)), defenses, layout, constraints);
    }
    defenses.setPreferredSize(new Dimension(400, 450));
    return defenses;
  }
  
  public Container getHealth() {
    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints constraints = new GridBagConstraints();
    constraints.fill = GridBagConstraints.BOTH;
    Panel health = new Panel(layout);
    health.setBackground(Color.WHITE);
    constraints.gridwidth = 2;
    constraints.gridheight =1;
    constraints.gridx = 0;
   
    addTo(new Label("HP"), health, layout, constraints);
    addTo(new Label("Bloodied At"), health, layout, constraints);
    addTo(new Label("Bloodied?"), health, layout, constraints);
    addTo(new Label("Conscious?"), health, layout, constraints);
    addTo(new Label("Surges"), health, layout, constraints);
    addTo(new Label("Surge Value"), health, layout, constraints);
    constraints.gridx = 2;
    constraints.gridy = 0;
    addTo(new Label("" + creature.health().getCurrentHp() + "/" + creature.health().getMaxHp()), health, layout, constraints);
    constraints.gridy = GridBagConstraints.RELATIVE;
    addTo(new Label("" + creature.health().bloodiedValue()), health, layout, constraints);
    addTo(new Label("" + creature.health().isBloodied()), health, layout, constraints);
    addTo(new Label("" + creature.health().isConscious()), health, layout, constraints);
    addTo(new Label("" + creature.health().getCurrentHealingSurges() + "/" + creature.health().getMaxHealingSurges()), health, layout, constraints);
    addTo(new Label("" + creature.health().surgeValue()), health, layout, constraints);
   
    health.setPreferredSize(new Dimension(100, 300));
    return health;
  }
  
  public Container getSkills() {
    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints constraints = new GridBagConstraints();
    constraints.fill = GridBagConstraints.BOTH;
    constraints.gridy = 0;
    Panel skills = new Panel(layout);
    skills.setBackground(Color.WHITE);
    constraints.gridwidth = 1;
    constraints.gridheight =1;
    addTo(new Label("Scr"), skills, layout, constraints);
    constraints.gridwidth = 3;
    addTo(new Label("Skill"), skills, layout, constraints);
    addTo(new Label("Use"), skills, layout, constraints);
    constraints.gridwidth = 1;
    addTo(new Label("MhL"), skills, layout, constraints);
    addTo(new Label("Trnd"), skills, layout, constraints);
    addTo(new Label("Race"), skills, layout, constraints);
    addTo(new Label("Armr"), skills, layout, constraints);
    for(SkillType type : SkillType.values()) {
      constraints.gridy++;
      addTo(new Label("" + creature.getSkills().get(type)), skills, layout, constraints);
      constraints.gridwidth = 3;
      addTo(new Label(type.toString()), skills, layout, constraints);
      addTo(new Label(type.attribute.getAbbreviation()), skills, layout, constraints);
      constraints.gridwidth = 1;
      addTo(new Label("" + creature.getSkills().get(type, BonusSource.ATTRIBUTE) + creature.getLevel()/2), skills, layout, constraints);
      addTo(new Label("" + creature.getSkills().get(type, BonusSource.TRAINED)), skills, layout, constraints);
      addTo(new Label("" + creature.getSkills().get(type, BonusSource.RACE)), skills, layout, constraints);
      addTo(new Label("" + creature.getSkills().get(type, BonusSource.ARMOR)), skills, layout, constraints);
    }
    skills.setPreferredSize(new Dimension(400, 450));
    return skills;

  }
  
  public void addTo(Component inside, Panel container, GridBagLayout layout, GridBagConstraints constraints) {
    layout.setConstraints(inside, constraints);
    container.add(inside);
  }

}
