package com.study;

import java.sql.Date;
import java.sql.Time;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.domain.main.MainDTO;
import com.study.domain.main.MainMapper;

@SpringBootTest
public class MainMapperTest {

	@Autowired
	MainMapper mainMapper;

	@Test
	void getResult() {
		MainDTO main = new MainDTO();
		main.setName("성산대교");
		Date d = Date.valueOf("2022-11-16");
		main.setDate(d);
		Time T = Time.valueOf("12:00:00");
		main.setTime(T);
		System.out.println(mainMapper.getResult(main));
		
		}
}
