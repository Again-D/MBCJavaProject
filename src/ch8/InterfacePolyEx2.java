package ch8;

public class InterfacePolyEx2 {

	public static void main(String[] args) {
		// Driver 객체 생성
		Driver driver = new Driver();
		
		// Vehicle 구현 객체 생성
		Bus bus = new Bus();
		Taxi taxi = new Taxi();
		
		// 매개값으로 구현 객체를 대입
		driver.drive(bus);
		driver.drive(taxi);

	}

}


// interface

interface Vehicle {
	// 추상 메서드
	void run();
}

// Bus
class Bus implements Vehicle {
	@Override
	public void run() {
		System.out.println("버스가 달립니다.");
		}
}

// Taxi
class Taxi implements Vehicle {
	@Override
	public void run() {
		System.out.println("택시가 달립니다.");
		}
}

// Driver
class Driver {
	void drive (Vehicle vehicle) {
		vehicle.run();
	}
}