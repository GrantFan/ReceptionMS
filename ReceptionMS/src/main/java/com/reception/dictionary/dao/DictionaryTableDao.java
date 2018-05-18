package com.reception.dictionary.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.reception.dictionary.model.DictionaryTableEntity;

@Mapper
public interface DictionaryTableDao {

	@Insert("insert into ${tableName}(name,value,remark) values(#{name},#{value},#{remark})")
	int add(DictionaryTableEntity dic);
	
	@Update("update ${tableName} set name=#{name},remark=#{remark} where value=#{value}")
	int update(DictionaryTableEntity dic);
	
	@Delete("delete from ${tableName} where value=#{value}")
	int delete(DictionaryTableEntity dic);
	
	@Select("select name,value,remark from ${tableName}")
	List<DictionaryTableEntity> list(DictionaryTableEntity dic);
	
	@Select("select name,value,remark from ${tableName} where value=#{value}")
	List<DictionaryTableEntity> selectByValue(DictionaryTableEntity dic);
}
