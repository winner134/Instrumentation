package instrumentationTool;

import java.util.*;
import java.io.*;

public class Instrumentation {
	
    private static Instrumentation ref;
    private static boolean active = false;
	private static Formatter writer;
	private TimerBlock[] timerBlocks = new TimerBlock[500000];
	private int count = 0;
	//private long totalTime = 0;
	
	private Instrumentation() {
		
	}
	
	public static Instrumentation Instance() {
		
		if (ref == null) {
			ref = new Instrumentation();
			createLogFile();
		}
		
		return ref;
		
	}
	
	public void startTiming(String comment) {
		
		if (active) {
		
			double startTime = (double) System.currentTimeMillis();
			writer.format("Start Timing: " + comment + System.getProperty("line.separator"));
			writer.flush();
			
			timerBlocks[count] = new TimerBlock(startTime, comment);
			
			count++;
		
		}
		
	}
	
	public void stopTiming(String comment) {
		
		if (active) {
			
		
			double endTime = (double) System.currentTimeMillis();
			double blockRunTime = 0;
				
			boolean foundTimeBlock = false;
			for (int i = 0; foundTimeBlock != true; i++) {
				
				if (timerBlocks[i].getComment().equals(comment)) {
					
					timerBlocks[i].setEndTime(endTime);
					foundTimeBlock = true;
					blockRunTime = timerBlocks[i].getTime();
					//timerBlocks[i] = null;
				}
			}
				
			writer.format("Stop Timing: " + comment + "  " + blockRunTime + " ms" + System.getProperty("line.separator"));
			writer.flush();
				
			//totalTime = totalTime + blockRunTime;
				

			

		
		}
			
	}
	
	public void comment(String comment) {
		
		if(active) {
			writer.format("Comment: " + comment + System.getProperty("line.separator"));
			writer.flush();
		}
		
	}
	
	public void activate(boolean onoff) {
		
		active = onoff;
	}
	
	private static void createLogFile() {
		
		try {
		
			writer = new Formatter(new File("log.txt"));
		
		}
		
		catch (FileNotFoundException f) {
			
			System.err.println("Cannot find file");
		}
	}

}
