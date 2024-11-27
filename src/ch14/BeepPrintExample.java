package ch14;

import java.awt.Toolkit;

public class BeepPrintExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Toolkit toolkit = Toolkit.getDefaultToolkit();
//		for (int i=0; i<5;i++) {
//			toolkit.beep();
//			try {
//				Thread.sleep(500); // 1000 -> 1s
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//		}

		// 스레드를 통해서 작업 진행...
		// 스레드 생성
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for (int i = 0; i < 5; i++) {
					toolkit.beep();
					try {
						Thread.sleep(500); // 1000 -> 1s
					} catch (Exception e) {
						// TODO: handle exception
					}
				}

			}

		});
		// 스레드 생성
		Thread thread2 = new Thread() {
			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for (int i = 0; i < 5; i++) {
					toolkit.beep();
					try {
						Thread.sleep(500); // 1000 -> 1s
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		};

		// 스레드 시작
//		thread2.start();
		BeepWork beep = new BeepWork();
		beep.start();

		for (int i = 0; i < 5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500); // 1000 -> 1s
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}
}

//BeepWork 클래스(Thread 상속)
class BeepWork extends Thread{
	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for (int i = 0; i < 5; i++) {
			toolkit.beep();
			try {
				Thread.sleep(500); // 1000 -> 1s
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
}