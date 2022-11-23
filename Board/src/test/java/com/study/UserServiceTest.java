package com.study;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.domain.user.UserResponse;
import com.study.domain.user.UserService;

@SpringBootTest
public class UserServiceTest {

	@Autowired
	UserService userService;
	
	@Test
	void usersave() {
		UserResponse params = new UserResponse();
		
		params.setId("lysyeah");
		params.setUserName("가나다");
		params.setNickname("나의닉네임");
		params.setEmail("dldydn04@naver.com");
		params.setPwd("123123123");
		params.setPwdHint("자신의 보물 1호는?");
		params.setPwdHintAns("123123");
		params.setGender(0);
		
		String string = "1992-05-07";
        LocalDate date = LocalDate.parse(string, DateTimeFormatter.ISO_DATE);
		params.setAge(date);
		
		userService.userSave(params);
		System.out.println(params.getUserNo());
		
	}
	
}
