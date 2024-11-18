package quiz;

import java.util.PriorityQueue;

public class CollectionQuiz2 {

	
	public static void main(String[] args) {
		// 스코빌 지수
		/*		섞은 음식의 스코빌 지수 = 가장 맵지않은 스코빌지수 + (두번째로 맵지않은 음식의 스코빌 지수)
		 *		모든 음식의 스코빌 지수를 k 이상으로 만들 수 없을 경우에는 -1을 리턴
		 * 
		 * 		scoville				k			return
		 * 		[1,2,3,9,10,12]			7			   2
		 */
		int [] scoville = {1,2,3,9,10,12};
		System.out.println("스코빌지수를 주어진 값이상으로 만들기 위한 섞는최소횟수: "+ solution(scoville,1));
	}
	
	public static int solution (int[] scoville, int k) {
		int answer = 0;
		// 우선순위 Queue : PriorityQueue 객체 생성
		PriorityQueue<Integer> que = new PriorityQueue<>();
		// que에 값 저장
		for (int i : scoville) {
			que.add(i);
		}
		System.out.println("섞기 전 음식 : " + que);
		while (true) {
			if (que.peek() >= k) return answer;
			answer ++;
			int result = que.poll() + (que.poll() *2);
			que.add(result);
			System.out.println(que);
//			if (que.peek() >= k) return answer;
			if (que.size() == 1) { // que사이즈 1이면 음실을 섞을 수 없다..
				return -1;
			}
		}
		
//		System.out.println(que);
	}

}
