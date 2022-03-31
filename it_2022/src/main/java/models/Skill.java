package models;

public class Skill {
	
	private String skillName;
	private int skillLevel;
	
	public Skill() {
		skillName="Умение";
		skillLevel=30;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public int getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(int skillLevel) {
		this.skillLevel = skillLevel;
	}
}
