package sub2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//등록할 객체에 어노테이션 선언
@Component("com") 
public class Computer {
	
	private CPU cpu;
	private RAM ram;
	
	// DI - Field Inject
	private HDD hdd;
	
	// DI - Constructor Inject 
	@Autowired
	public Computer(CPU cpu) {
		this.cpu = cpu;
	}
	
	// DI - Setter Inject :초기화된 객체의 값을 간접적으로 바꾸는 것 => set
	public void setRam(RAM ram) {
		this.ram = ram;
	}
	
	public void show() {
		cpu.show();
		ram.show();
		hdd.show();
	}
	
}
