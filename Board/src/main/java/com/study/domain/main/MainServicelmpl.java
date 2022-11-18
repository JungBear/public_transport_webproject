package com.study.domain.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainServicelmpl implements MainService{
	
	@Autowired
	private BridgeMapper bridgeMapper;
	
	@Override
	public List<BridgeDTO> getcongestionRate(BridgeDTO params) {
		return bridgeMapper.getResult(params);
	}
	
	
}
