package com.qfjy.meeting.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qfjy.meeting.bean.MeetingPub;
import com.qfjy.meeting.service.MeetingPubService;

@Controller
public class MeetingPubController {
	@Autowired
	MeetingPubService meetingPubService;

	// 会议添加功能
	@RequestMapping("weixin/meetingPub/add")
	public String add(MeetingPub pub) {
		try {
			meetingPubService.add(pub);
		} catch (Exception e) {
			e.printStackTrace();
			return "2";
		}
		return "1";
	}
}
