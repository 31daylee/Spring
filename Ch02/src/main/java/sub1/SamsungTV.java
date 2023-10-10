package sub1;

public class SamsungTV {
	
	private Speaker spk;
	
	public void powerOn() {
		System.out.println("SamsungTV powerOn ...");
	}

	public void powerOff() {
		System.out.println("SamsungTV powerOff ...");
	}

	public void soundUp() {
		spk.soundUp(); // spk에 대한 초기화가 없으므로 현재 nullPointException이 발생하게 된다 => 주입을 받게 되면 생성자는 필요없다.
	}

	public void soundDown() {
		spk.soundDown();
	}
	
}
