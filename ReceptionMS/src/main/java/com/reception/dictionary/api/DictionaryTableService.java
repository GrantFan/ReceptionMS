package com.reception.dictionary.api;

import java.util.List;

import com.reception.dictionary.model.DictionaryTableEntity;

public interface DictionaryTableService {

	int add(DictionaryTableEntity dic);
	
	int update(DictionaryTableEntity dic);
	
	int delete(DictionaryTableEntity dic);
	
	List<DictionaryTableEntity> list(DictionaryTableEntity dic);
	
	int isExist(DictionaryTableEntity dic);
}
