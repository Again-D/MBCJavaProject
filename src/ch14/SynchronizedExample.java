package ch14;

public class SynchronizedExample {

	public static void main(String[] args) {
		
		// Calculator Object create
		Calculator calculator = new Calculator();
		
		User1Thread user1Thread = new User1Thread();
		user1Thread.setCalculator(calculator);
		user1Thread.start();

		User2Thread user2Thread = new User2Thread();
		user2Thread.setCalculator(calculator);
		user2Thread.start();

	}

}

class Calculator {
	   // 필드
	   private int memory;
	   
	   // getter
	   public int getMemory() {
	      return memory;
	   }
	   
	   // 메서드 선언부에 synchronized 를 사용! - 메서드 진입 자체에서 동기화 제어
	   public synchronized void setMemory1(int memory) {	// Synchronized Method
	      this.memory = memory;
	      try {
	         Thread.sleep(2000);
	      } catch (InterruptedException e) {}
	      System.out.println(Thread.currentThread().getName()+ ": " + this.memory);   
	   }
	   
	   
	   public void setMemory2(int memory) {
	      // synchronized 블럭 생성 - 블럭 부분만 동기화 제어
		   synchronized (this) {	// synchronized (공유객체) {}
	    	  this.memory = memory;
		      try {
		         Thread.sleep(2000);
		      } catch (InterruptedException e) {}
		      System.out.println(Thread.currentThread().getName()+ ": " + this.memory);   
		   }
		}
		   
	}

	class User1Thread extends Thread {
	   // 필드
	   private Calculator calculator;
	   
	   // 생성자
	   public User1Thread() {
	      setName("User1Thread");
	   }
	   
	   // setter 메서드
	   public void setCalculator(Calculator calculator) {
	      this.calculator = calculator;
	   }
	   
	   @Override
	   public void run() {
	      calculator.setMemory1(100);
	   }
	   
	}

	class User2Thread extends Thread {
	   // 필드
	   private Calculator calculator;
	   
	   // 생성자
	   public User2Thread() {
	      setName("User2Thread");
	   }
	   
	   // setter 메서드
	   public void setCalculator(Calculator calculator) {
	      this.calculator = calculator;
	   }
	   
	   @Override
	   public void run() {
	      calculator.setMemory2(50);
	   }
	   
	}
