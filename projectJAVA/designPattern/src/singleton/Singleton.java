package singleton;

public class Singleton {
	
	private Singleton() {}
	
	private int number = 0;
	
    /*
     * static member class
     * ����Ŭ�������� static������ �����ؾ��ϴ� ��� static ���� Ŭ������ �����ؾ߸� �Ѵ�.
     * static ���, Ư�� static �޼��忡�� ���� �������� ����
     */
    private static class LazyHolder {
        // Ŭ���� �ε� �������� ����
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
        System.out.println(Thread.currentThread() + " ���� �� : " + number);
    }
    
}
