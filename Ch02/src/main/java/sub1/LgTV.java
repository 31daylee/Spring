package sub1;

import org.springframework.beans.factory.annotation.Autowired;

public class LgTV {
	
	@Autowired // 자동 주입되므로 객체 이름은 필요없다 
	private Speaker spk;
	
	public void powerOn() {
		System.out.println("LgTV powerOn ...");
	}

	public void powerOff() {
		System.out.println("LgTV powerOff ...");
	}

	public void soundUp() {
		spk.soundUp(); // spk에 대한 초기화가 없으므로 현재 nullPointException이 발생하게 된다 => 주입을 받게 되면 생성자는 필요없다.
	}

	public void soundDown() {
		spk.soundDown();
	}
	
}
