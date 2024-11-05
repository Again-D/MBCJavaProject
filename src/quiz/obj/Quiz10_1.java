package quiz.obj;

public class Quiz10_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Warrior me = new Warrior("강한친구대한전사");
		Wizard play2 = new Wizard("구르미그린달빛");
		Warrior play3 = new Warrior("전사약해요");
		
		me.mp = 100;
		
		System.out.println("---나의 캐릭 배쉬스킬 사용---");
		me.bash(play2);	//강한친구대한전사 bash스킬 사용(play2 적중)
		me.bash(play3); //강한친구대한전사 bash스킬 사용(play3 적중)
		
		me.bash(play2);	//강한친구대한전사 bash스킬 사용(play2 적중)
		me.bash(play3); //강한친구대한전사 bash스킬 사용(play3 적중)
		
		play2.info();
		play3.info();

	}

}
