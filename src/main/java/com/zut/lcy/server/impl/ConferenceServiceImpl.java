package com.zut.lcy.server.impl;

import java.util.List;

import com.zut.lcy.entity.Boss;
import com.zut.lcy.entity.Car;
import com.zut.lcy.entity.Conference;
import com.zut.lcy.server.ConferenceService;

public class ConferenceServiceImpl implements ConferenceService{

	Conference conference;
	
	public ConferenceServiceImpl() {
		super();
	}

	public ConferenceServiceImpl(Conference conference) {
		super();
		this.conference = conference;
	}

	public Conference getConference() {
		return conference;
	}

	public void setConference(Conference conference) {
		this.conference = conference;
	}

	@Override
	public void conference() {

		System.out.println("会议主题：" + conference.getTheme());
		
		List<Boss> list = conference.getLists();
		
		for(int i=0; i<list.size(); i++) {
			Boss boss = list.get(i);
			System.out.println("老板：姓名：" + boss.getName()
							+ " 爱好：" + boss.getHobby()
							+ " 公司：" + boss.getCompany()
					);
			Car car = boss.getCar();
			System.out.println("\t老板的车：品牌：" + car.getBrand()
								+ " 颜色：" + car.getColour()
								+ " 排量：" + car.getDisplacement());
		}
	}

}
