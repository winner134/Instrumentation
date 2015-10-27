
import instrumentationTool.Instrumentation;


public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		Instrumentation ins = Instrumentation.Instance();
		
		ins.activate(true);
		for (int i = 0; i < 500000;i++) {
			ins.startTiming("main");
			ins.stopTiming("main");
		}
		
	}
}
