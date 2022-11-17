package com.study.domain.main;

import java.sql.Date;
import java.sql.Time;

import lombok.Data;

@Data
public class MainDTO {
	private String name;
	private String startPosition;
	private Date date;
	private Time time;
	private double congestionRate;

}
