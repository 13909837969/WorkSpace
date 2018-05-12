package com.company.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.dao.idao.InfoDao;
import com.company.dao.pojo.Info;
import com.company.service.iservice.InfoService;
@Service
public class InfoServiceImpl implements InfoService 
{

	@Autowired
	private InfoDao infoDao;
	
	@Override
	public Info getById(Integer id) 
	{

		
		return infoDao.getById(id);
	}

}
