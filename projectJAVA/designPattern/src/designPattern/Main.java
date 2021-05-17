package designPattern;

import singleton.Singleton;
import strategy.*;

public class Main {

	public static void main(String[] args) {
		
		// Singleton Pattern
		Runnable task = ()-> {
			
			Singleton singleton = Singleton.getInstance();
			singleton.print(Thread.currentThread().getName()+" [ Singleton Pattern ]");
			
	    };
	    
	    Thread subTread1 = new Thread(task);
	    Thread subTread2 = new Thread(task);
	    subTread1.start();
	    subTread2.start();
		
	    // Strategy Pattern
	    Desktop desktop = new Samsung();
	    AiSpeaker aiSpeaker = new SamsungSpeaker();
	    desktop.setAiSpeaker(aiSpeaker);
	    desktop.process(Thread.currentThread().getName()+" »ï¼º");
	    
	    desktop = new Apple();
	    aiSpeaker = new AppleSpeaker();
	    desktop.setAiSpeaker(aiSpeaker);
	    desktop.process(Thread.currentThread().getName()+" ¾ÖÇÃ");
	}
	
}
