package kr.co.sboard.security;

import kr.co.sboard.entity.UserEntity;
import kr.co.sboard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;


@Service
public class SecurityUserService implements UserDetailsService{

	@Autowired
	private UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { // UserDetailService 에서 loadUser~ 가 호출되어 현재 메서드로 사용 가능함 
		
		// 패스워드에 대한 검사는 이전 컴포넌트(AuthenticationProvider)에서 처리되어 사용자 아이디만 넘어옴
		UserEntity user = repo.findById(username).orElseThrow(() -> new UsernameNotFoundException(username + "NotFound"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 사용자 인증객체 생성(세션에 저장)
		UserDetails userDetails = MyUserDetails.builder()
									.user(user)
									.build();
		return userDetails;
	}

}
