package com.reception.dictionary.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.reception.conference.api.IConferenceService;
import com.reception.conference.model.ConferenceEntity;
import com.reception.dictionary.model.DictionaryTableEntity;
import com.reception.dictionary.service.DictionaryTableServiceImpl;
import com.reception.exceptionfilter.EntityNotFoundException;
import com.reception.util.JSONHelper;


@RestController
@RequestMapping(value= "dic" ,produces = "application/json;charset=UTF-8")
public class DictionaryTableAction {

	private static Logger log=LoggerFactory.getLogger(DictionaryTableAction.class);
	
	@Resource
	DictionaryTableServiceImpl dictionaryTableServiceImpl;

	@RequestMapping(method = RequestMethod.POST)
	public void add(@ModelAttribute("dic")DictionaryTableEntity dic){
		this.dictionaryTableServiceImpl.add(dic); 
	}
	@RequestMapping(method = RequestMethod.DELETE)
	public String delete(@ModelAttribute("dic")DictionaryTableEntity dic){
		int r =  this.dictionaryTableServiceImpl.delete(dic);
		if(r>0){
			return "true";
		}
		return "false";
	}	 
	@RequestMapping(method = RequestMethod.PUT)
	public String update(@ModelAttribute("dic")DictionaryTableEntity dic){
		int r =  this.dictionaryTableServiceImpl.update(dic);  
		if(r>0){
			return "true";
		}
		return "false";
	}
	@RequestMapping(method = RequestMethod.GET)
	public String query(@ModelAttribute("dic")DictionaryTableEntity dic){
		List<DictionaryTableEntity> list =  this.dictionaryTableServiceImpl.list(dic);  
		return JSONHelper.toJSON(list);
	}
}
