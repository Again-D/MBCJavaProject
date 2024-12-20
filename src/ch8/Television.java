package ch8;


// RemoteControl 인터페이스의 구현체 클래스...
public class Television implements RemoteControl {	// implements 키워를 사용하여 구현 인터페이스 지정

	// 필드
	private int volume;		// 볼륨
	
	// Mute시에 저장될 volume값
	private int memoryVolume;
	
	@Override
	public void turnOn() {
		System.out.println("Television을 켭니다.");

	}

	@Override
	public void turnOff() {
		System.out.println("Television을 끕니다.");

	}
	
	// setVolume 추상 메서드 오버로드
	@Override
	public void setVolume(int volume) {
		if(volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		}else if (volume < RemoteControl.MIN_VOULUME) {
			this.volume = RemoteControl.MIN_VOULUME;			
		}else {
			this.volume = volume;
		}
		System.out.println("현재 TV 볼륨 : " + this.volume);
		
	}
		
	public int getVolume() {
		return volume;
	}

	// default 메서드 재정의
	@Override
		public void setMute(boolean mute) {
			// 인터페이스에 있는 default 메서드를 재정의...
			if(mute) {
				this.memoryVolume = this.volume;
				System.out.println("무음 처리를 합니다.");
				setVolume(RemoteControl.MIN_VOULUME);
			}else {
				System.out.println("무음을 해제 합니다.");
				setVolume(this.memoryVolume);
				
			}
		}
}
