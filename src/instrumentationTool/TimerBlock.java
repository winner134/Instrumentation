package instrumentationTool;

public class TimerBlock {
	
	private double StartTimeOfBlock;
	private String comment;
	private double EndTimeOfBlock;
	private double totalTime;
	
	public TimerBlock (double time, String note) {
		
		StartTimeOfBlock = time;
		comment = note;
	}
	
	public void setEndTime(double time) {
		
		EndTimeOfBlock = time;
		calculateTotalTime();
	}
	
	public String getComment() {
		
		return comment;
	}
	
	private void calculateTotalTime() {
		
		totalTime = EndTimeOfBlock - StartTimeOfBlock;
	}
	
	public double getTime() {
		
		return totalTime;
	}
	
}
