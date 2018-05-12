package com.qfjy.meeting.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qfjy.meeting.bean.MeetingPub;

public interface MeetingPubRepository extends JpaRepository<MeetingPub,String> {
	
	//根据会议召开时间，查询当天是否存在会议，如果存在，将最大的查出来，如果不存在，就null
	@Query(value=" select  max(pcode) from meetingpub where LEFT(ptime,10) =? "
			,nativeQuery=true)
	public String getPcodeByPtime(String ptime);
	//我的会议（发布的会议）
	public List<MeetingPub> getByUid(String uid);
}
