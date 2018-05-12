package com.qfjy.meeting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qfjy.meeting.bean.MeetingType;
import com.qfjy.meeting.dao.MeetingTypeRepository;
import com.qfjy.meeting.service.MeetingTypeService;

@Service
public class MeetingTypeServiceImpl  implements MeetingTypeService{
   @Autowired
	MeetingTypeRepository meetingTypeRepository;
	@Override
	public List<MeetingType> getByStatusOrderBySortnumDesc() {
		// TODO Auto-generated method stub
		return meetingTypeRepository.getByStatusOrderBySortnumDesc(0);
	}
 
}
