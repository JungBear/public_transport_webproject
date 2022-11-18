package com.study.domain.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainServicelmpl implements MainService{
	
	@Autowired
	private MainMapper mainMapper;
	
	@Override
	public List<MainDTO> getcongestionRate(MainDTO params) {
		return mainMapper.getResult(params);
	}
	
	
}
