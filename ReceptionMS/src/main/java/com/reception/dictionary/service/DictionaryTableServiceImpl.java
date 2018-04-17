package com.reception.dictionary.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.reception.dictionary.api.DictionaryTableService;
import com.reception.dictionary.dao.DictionaryTableDao;
import com.reception.dictionary.model.DictionaryTableEntity;

@Service
public class DictionaryTableServiceImpl implements DictionaryTableService {

	@Resource
	DictionaryTableDao dictionaryTableDao;
	
	@Override
	public int add(DictionaryTableEntity dic) {
		// TODO Auto-generated method stub
		return dictionaryTableDao.add(dic);
	}

	@Override
	public int update(DictionaryTableEntity dic) {
		// TODO Auto-generated method stub
		return dictionaryTableDao.update(dic);
	}

	@Override
	public int delete(DictionaryTableEntity dic) {
		// TODO Auto-generated method stub
		return dictionaryTableDao.add(dic);
	}

	@Override
	public List<DictionaryTableEntity> list(DictionaryTableEntity dic) {
		// TODO Auto-generated method stub
		return dictionaryTableDao.list(dic);
	}

}
