package recSys.beans;

public class PartBeans {
	
	private String number;
	private String name;
	private String project;
	private int InspectionLevel;
	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the project
	 */
	public String getProject() {
		return project;
	}
	/**
	 * @param project the project to set
	 */
	public void setProject(String project) {
		this.project = project;
		
		
	}
	public int getInspectionLevel() {
		return InspectionLevel;
	}
	public void setInspectionLevel(int inspectionLevel) {
		InspectionLevel = inspectionLevel;
	}
	

}
