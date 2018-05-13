package com.reception.conference.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.reception.conference.api.IConferenceRecordService;
import com.reception.conference.dao.ConferenceRecordMapper;
import com.reception.conference.model.ConferenceRecordEntity;
import com.reception.conference.model.HotelUtil;


@Service
public class ConferenceRecordServiceImpl implements IConferenceRecordService{
	
	@Resource
	private ConferenceRecordMapper conferenceRecordMapper;
	
	@Override
	public void addConferenceRecord(ConferenceRecordEntity conferenceRecordEntity) {
		conferenceRecordEntity.setID(String.valueOf(System.currentTimeMillis()));
		this.conferenceRecordMapper.addConferenectRecord(conferenceRecordEntity); 
	}

	@Override
	public boolean delConferenceRecord(String id) {
		return this.conferenceRecordMapper.delConferenectRecord(id) == 1 ? true : false;
		
	}

	@Override
	public boolean modConferenceRecord(ConferenceRecordEntity conferenceRecordEntity) {
		return this.conferenceRecordMapper.modConferenectRecord(conferenceRecordEntity) == 1 ? true : false;
	}

	@Override
	public ConferenceRecordEntity queryConferenceRecordById(String id) { 
		return this.conferenceRecordMapper.queryConferenceRecordById(id);
	}									 
	
	@Override 
	public List<HotelUtil> hotelList(Map map){
		List<HotelUtil> list = this.conferenceRecordMapper.hotelList(map);
		for(int i = 0,j = list.size() ; i < j ;i ++){
			HotelUtil hotelUtil = list.get(i);
			map.put("name", hotelUtil.getName());
			if(hotelUtil != null){
				hotelUtil.setConferenceRecordList(this.conferenceRecordMapper.queryConferenecByHotelName(map));
			}
		} 
		return list; 
	}

	@Override
	public List<ConferenceRecordEntity> queryConferenceRecordByPage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUse_Number(String now_date) {
		String index = this.conferenceRecordMapper.getUse_Number(now_date).toString(); 
		if(index.length() == 1){
			return new String("H"+now_date+"00"+index);
		}else if(index.length() == 2){
			return new String("H"+now_date+"0"+index);
		}else if(index.length() == 3){
			return new String("H"+now_date+index);
		} 
		return null;
	}
	@Override
	public boolean checkConferenceRecord(ConferenceRecordEntity conferenceRecordEntity){
		List<ConferenceRecordEntity> list = this.conferenceRecordMapper.checkConferenceRecord(conferenceRecordEntity); 
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String USE_DATE = conferenceRecordEntity.getUSE_DATE();
		String be_TIME = conferenceRecordEntity.getSTART_TIME();
		String af_TIME = conferenceRecordEntity.getEND_TIME();
		
		Date  ibe_TIME = null; 
		Date  iaf_TIME = null;
		
		try {
			ibe_TIME = sf.parse(USE_DATE+" "+be_TIME+":00");
			iaf_TIME = sf.parse(USE_DATE+" "+af_TIME+":00");
			
			Date  ube_TIME = null; 
			Date  uaf_TIME = null; 
			for(int i = 0,j = list.size() ; i < j ; i++){
				ube_TIME = sf.parse(list.get(i).getSTART_DATE()); 
				uaf_TIME = sf.parse(list.get(i).getEND_DATE());
				if((ibe_TIME.getTime() > ube_TIME.getTime() && ibe_TIME.getTime() < iaf_TIME.getTime()) ||
						(iaf_TIME.getTime() > ube_TIME.getTime() && iaf_TIME.getTime() < iaf_TIME.getTime())){
					 return false;
				} 
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return true;
	}
}
