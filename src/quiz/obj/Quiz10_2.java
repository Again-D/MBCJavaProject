package quiz.obj;

public class Quiz10_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Warrior w1 = new Warrior("강한친구");
		Wizard w2 = new Wizard("구르미");
		Warrior me = new Warrior("나의 캐릭터");
		Player[] players = new Player[2];
		players[0] = w1;
		players[1] = me;
		
		
		//w2의 블리자드를 5번 실행
		for (int i = 0; i < 5 ; i++) {
			w2.blizzard(players);
		}
	}

}
