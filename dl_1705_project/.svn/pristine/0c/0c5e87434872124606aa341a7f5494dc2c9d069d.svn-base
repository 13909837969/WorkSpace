package com.qfjy.meeting.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
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
		
		pub.setId(UUID.randomUUID().toString());
		
		pub.setPcode(genPubCode(pub.getPtime()));//按照一定的规则生成
		
		pub.setCurrtDate(new Date());
		
		pub.setStatus(0);//默认有效的发单数据
		
		meetingPubRepository.save(pub);
	}
	/**
	 会议编号规则：
	     根据会议召开时间进行生成会议编号，如果是当天的第一单+001，第二单+002
	例如：召开时间为2018-04-26-12：30
	          第一单： 20180426001
	          第二单： 20180426002
	 */
	public String genPubCode(String pubTime){
		String result=null;
		//1 将2018-05-06T12:30 变成：20180506
		String str=pubTime.substring(0, 10);//2018-05-06
		String strOper=str.replaceAll("-","");
		//2判断这场会议在 当天的时间是第几单
		String pcode=meetingPubRepository.getPcodeByPtime(str);
		if(StringUtils.isEmpty(pcode)){
			result=strOper+"001";
		}else{
			//将最大的会议编号得到，+1 20180506001
			long l=Long.parseLong(pcode);
			l+=1;
			result=l+"";
		}
		return result;
	}
	@Override
	public List<MeetingPub> getByUid(String uid) {
		// TODO Auto-generated method stub
		return meetingPubRepository.getByUid(uid);
	}
	
}
