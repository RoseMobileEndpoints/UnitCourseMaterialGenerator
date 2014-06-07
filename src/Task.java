import java.io.PrintWriter;


/**
 * A lesson or activity.
 *
 * @author Matt Boutell.
 *         Created Jun 6, 2014.
 */
public abstract class Task {
	private String title;
	private Unit unit; 
	private int number;

	public abstract String getFileName();
	
	public Task(Unit unit, int number) {
		this.unit = unit;
		this.number = number;
	}

	public void setTitle(String title) {
		this.title= title;
	}

	public String getTitle() {
		return title;
	}
	
	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public Unit getUnit() {
		return unit;
	}
	
	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public abstract void generateFile(PrintWriter pw);
	
	protected String replaceNextAndPrevious(String template) {
		Task previousTask = this.getUnit().getPreviousTask(this);
		String previousLink = "";
		if (previousTask != null) {
			previousLink = String.format("<a href=\""
					+ previousTask.getFileName() + "\"> Previous Page </a>");
		}
		template = template.replace("$PREVIOUS_LINK", previousLink);

		Task nextTask = this.getUnit().getNextTask(this);
		String nextLink = "";
		if (nextTask != null) {
			nextLink = String.format("<a href=\""
					+ nextTask.getFileName() + "\"> Next Page </a>");
		}
		template = template.replace("$NEXT_LINK", nextLink);
		return template;
	}

	
}
