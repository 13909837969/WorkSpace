package com.qfjy.meeting.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qfjy.meeting.bean.MeetingType;
import com.qfjy.meeting.service.MeetingTypeService;

@Controller

public class MeetingTypeController {
	@Autowired
	MeetingTypeService meetingTypeService;

	// ajax列表数据
	@RequestMapping("weixin/meetingType/getAll")
	@ResponseBody
	public List<MeetingType> getAll() {

		return meetingTypeService.getByStatusOrderBySortnumDesc();
	}

}
