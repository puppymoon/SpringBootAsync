package com.moon.SpringBootAsync.dto;

import java.text.SimpleDateFormat;
import java.util.UUID;

public class AsyncDto {

	private String ID;

	private Long nowTime;

	public AsyncDto() {
		this.ID = UUID.randomUUID().toString();
		this.nowTime = System.currentTimeMillis();
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public Long getNowTime() {
		return nowTime;
	}

	public void setNowTime(Long nowTime) {
		this.nowTime = nowTime;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss.SSS");
		return "AsyncDto [ID=" + ID + ", nowTime=" + sdFormat.format(this.nowTime) + "]";
	}

}
