package quiz.obj;

public class Wizard extends Player {
	
	public Wizard() {}
	
	public Wizard (String name, int hp, int mp) {
		this.name = name;
		this.hp = hp;
		this.mp = mp;		
	}
	
	public Wizard(String name) {
		this(name, 500, 1000);
	}
	
	void iceArrow() {
		System.out.println("얼음화살 사용");
	}
	
	@Override
	void action() {
		// TODO Auto-generated method stub
		System.out.println("----마법사----");
		System.out.println("마법사는 귀여운 동작을 합니다.");

	} 
	
	public void blizzard(Player[] players) {
		System.out.println("------------------");
		System.out.println(this.name + "님의 눈보라 시전!");
		/*
		 *  기능
		 *   1.매개변수 players 배열을 향상된 for문으로 회전.
		 *   2.for문 안에서는 10~15사이의 랜덤난수를 발생.
		 *   3.players배열의 hp를 각각 랜덤난수 만큼 감소
		 *   4.players배열의 이름과 함께 랜덤피해를 각각 출력.
		 */
		
		//1. for문 사용(강화된 for문)
		for(Player play:players) {
			// 2. 난수 생성
			int damage = (int)(Math.random()*6) + 10;	// 10 ~ 15
			// 3. hp 감소
			play.hp -= damage;
			// 4. 감소 내용 출력
			System.out.println(play.name + "님이 " + damage + "피해를 입었습니다.");
		}

//		for (int i=0; i < players.length; i++) {
//				int dmg = (int)(Math.random() * 6 + 10);
//				players[i].hp -= dmg;
//				System.out.println(players[i].name + "님이 " + dmg + "피해를 입었습니다.");
//		}
	}
		
		
		
}
