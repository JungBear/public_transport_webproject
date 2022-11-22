package com.study.domain.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.domain.post.PostMapper;
import com.study.domain.post.PostResponse;

@Service
public class MainServicelmpl implements MainService{
	
	@Autowired
	private BridgeMapper bridgeMapper;
	
	@Autowired
	private PostMapper postmapper;
	
	@Override
	public List<BridgeDTO> getcongestionRate(BridgeDTO params) {
		return bridgeMapper.getResult(params);
	}
	public List<PostResponse> summaryInfoList(PostResponse params){
		List<PostResponse> summaryInfoList = postmapper.summaryInfoList(params);
		return summaryInfoList;
	}
	public List<PostResponse> summaryFreeList(PostResponse params){
		List<PostResponse> summaryFreeList = postmapper.summaryInfoList(params);
		return summaryFreeList;
	}
	
}
