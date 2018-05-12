package com.qfjy.meeting.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qfjy.meeting.bean.MeetingPub;
import com.qfjy.meeting.dao.MeetingPubRepository;
import com.qfjy.meeting.service.MeetingPubService;

@Service
public class MeetingPubServiceImpl implements MeetingPubService {
   @Autowired
	MeetingPubRepository meetingPubRepository;
	@Override
	public void add(MeetingPub pub) {
		// TODO Auto-generated method stub
		meetingPubRepository.save(pub);
	}

}
