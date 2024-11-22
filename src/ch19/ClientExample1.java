package ch19;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientExample1 {

	// 클라이언트 프로그램  책 P837
	public static void main(String[] args) {
		try {
			// 1. Socket 생성
			// - 방법1 생성자에 직접 입력하는는 방법
			//Socket socket = new Socket("192.168.0.138", 50001);
			// - 방법2 생성자 주입 정보 : InetSocketAddress() 객체 사용
			Socket socket = new Socket();
			InetSocketAddress serverAddress = new InetSocketAddress("192.168.0.138", 50001);
			socket.connect(serverAddress); 	// connect() 주어진 객체 주소로 연결을 시도하는 메서드
			
			System.out.println("[클라이언트] 연결 성공");
			
			// 2. 데이터 처리를 위한 작업
			// 데이터 전송하기..
			String sendMessage = "여러분 프로그램을 좋아하세요~~~";
			// getOutputStream() : OutputStream 객체 반환 - 전송시 내보낼 데이터 처리를 위한
			OutputStream os = socket.getOutputStream();
			// 보조 스트림 중 DataOutputStream
			DataOutputStream dos = new DataOutputStream(os);
			dos.writeUTF(sendMessage);
			dos.flush();
			
//			byte[] bytes = sendMessage.getBytes("UTF-8");
//			os.write(bytes);
//			os.flush();
			System.out.println("[클라이언트] 데이터 전송 : " + sendMessage);
			
			// 데이터 전송받기..
			InputStream is = socket.getInputStream();
			// 보조 스트림중 DataInputStream
			DataInputStream dis = new DataInputStream(is);
			String receiveMessage = dis.readUTF();
			
			
			// 데이터 처리를 위한 공간 설정
//			bytes = new byte[1024];
//			int readByteCount = is.read(bytes);
//			String receiveMessage = new String(bytes, 0, readByteCount,"UTF-8");
			System.out.println("[클라이언트] 서버에게 받은 데이터 : " + receiveMessage);
			
			// 3. 연결 끊기 : Socket 닫기
			socket.close();
			System.out.println("[클라이언트] 연결 끊음");
		} catch (UnknownHostException e) {
			// IP 표기 방법이 잘못된 경우
			
		} catch (IOException e) {
			// 서버에 연결하지 못하는 경우
			
		}

	}

}
