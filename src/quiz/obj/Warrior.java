package quiz.obj;

public class Warrior extends Player {
	
	
	public Warrior() {}
	
	public Warrior (String name, int hp, int mp) {
		this.name = name;
		this.hp = hp;
		this.mp = mp;		
	}
	
	
	
	public Warrior(String name) {
		this(name, 1000, 500);
	}
	
	// 매개값 추가.. Warrior, Wizard
	void bash(Player player) {	// 부모객체
		
		// 실행시 mp를 -100 감소
		
		if(mp < 100) {
			System.out.println("마나가 부족하여 스킬을 사용하지 못했습니다.");
			return;
		}else {
			mp -= 100;
		//hp 감소폭 다르게
		if(player instanceof Warrior) {
			player.hp -= 100;	// 전사 적중시 hp 100 감소
		}else {
			player.hp -= 200;	// 마법사 적중시 hp 200 감소
		}
		}
		System.out.println(player.name + "님 배쉬 스킬 적중");
		
		
	}
	


	@Override
	void action() {
		// TODO Auto-generated method stub
		System.out.println("----전사----");
		System.out.println("전사는 멋진 동작을 합니다.");
	}
}
