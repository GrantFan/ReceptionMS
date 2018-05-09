package com.reception.recep.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.reception.recep.api.ReceptionRecordService;
import com.reception.recep.dao.ReceptionRecordMapper;
import com.reception.recep.model.ReceptionRecordEntity;

@Service
public class ReceptionRecordServiceImpl implements ReceptionRecordService {

	@Resource
	ReceptionRecordMapper receptionRecordMapper;
	
	@Override
	public int add(ReceptionRecordEntity reception) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ReceptionRecordEntity reception) {
		// TODO Auto-generated method stub
		return receptionRecordMapper.update(reception);
	}

	@Override
	public int delete(ReceptionRecordEntity reception) {
		// TODO Auto-generated method stub
		return receptionRecordMapper.delete(reception);
	}

	@Override
	public List<ReceptionRecordEntity> selectList() {
		// TODO Auto-generated method stub
		return receptionRecordMapper.selectList();
	}

	public List<ReceptionRecordEntity> selectByNumber(String receptionNumber) {
		// TODO Auto-generated method stub
		return receptionRecordMapper.selectByNumber(receptionNumber);
	}
	
	public List<ReceptionRecordEntity> selectLike(ReceptionRecordEntity reception){
		return receptionRecordMapper.selectLike(reception);
	}
}
