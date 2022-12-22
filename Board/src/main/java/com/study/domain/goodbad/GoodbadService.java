package com.study.domain.goodbad;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class GoodbadService {
	private final GoodbadMapper goodbadmapper;
}
