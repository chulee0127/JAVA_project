package strategy;

public abstract class Desktop {
	
	private AiSpeaker aiSpeaker;
	
	public void setAiSpeaker(AiSpeaker aiSpeaker) {
		this.aiSpeaker = aiSpeaker;
	}

	public void process(String currentThread) {
		System.out.println("----- "+currentThread+" ----- ");
		mainBoard();
		memory();
		cpu();
		speaker();
	}
	
	public void speaker() {
		if (aiSpeaker != null) {
			aiSpeaker.speakerName();
		}
	}
	
	public void mainBoard() {
		System.out.println("[ MainBoard ]");
	}
	
	public void memory() {
		System.out.println("[ Memory ]");
	}
	
	public void cpu() {
		System.out.println("[ CPU ]");
	}
	
}
