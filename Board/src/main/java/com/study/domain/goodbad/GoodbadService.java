package com.study.domain.goodbad;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GoodbadService {
	private final GoodbadMapper goodbadmapper;
	
	public boolean checkGood(GoodbadDTO params) {
		if (goodbadmapper.checkGood(params) == 0) {
			return false; 
		}else {
			return true;
		}
	}
	
	public boolean checkbad(GoodbadDTO params) {
		if (goodbadmapper.checkbad(params) == 0) {
			return false; 
		}else {
			return true;
		}
	}
}
