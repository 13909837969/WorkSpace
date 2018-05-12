package com.qfjy.meeting.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qfjy.meeting.bean.MeetingType;

public interface MeetingTypeRepository extends JpaRepository<MeetingType, String> {

	//查询所有的有效的会议类别、要按照SortNum进行升序
	//select * from meetingtype where status=0  order by sortnum ;
	public List<MeetingType> getByStatusOrderBySortnumDesc(Integer status);
}
