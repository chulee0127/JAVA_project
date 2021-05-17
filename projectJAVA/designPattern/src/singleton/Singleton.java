package singleton;

public class Singleton {
	
	private Singleton() {}
	
	private int number = 0;
	
    /*
     * static member class
     * 내부클래스에서 static변수를 선언해야하는 경우 static 내부 클래스를 선언해야만 한다.
     * static 멤버, 특히 static 메서드에서 사용될 목적으로 선언
     */
    private static class LazyHolder {
        // 클래스 로딩 시점에서 생성
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return LazyHolder.INSTANCE;
    }
	
    public void print(String input) {
    	System.out.println("input :: "+input);
    	
        for (int index = 0; index < 10; index++) {
        	number += index;
            System.out.println(Thread.currentThread().getName()+" :: "+number);
        }
        System.out.println(Thread.currentThread() + " 최종 합 : " + number);
    }
    
}
