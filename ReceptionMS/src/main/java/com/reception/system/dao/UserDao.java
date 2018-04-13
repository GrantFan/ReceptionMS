package com.reception.system.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reception.system.model.User;


/**
 * 用户Dao层
 */
@Mapper
public interface UserDao {

	/**
	 * 用户添加
	 * @param user
	 * @return int
	 */
	@Insert("insert into sys_user(user_name,user_nick,password,createTime,enable,roleId)values(#{userName},#{userNick},#{password},#{createTime}#{enable},#{roleId})")
	int addUser(User user) ;
	
	/**
	 * 查询用户
	 * @param user
	 * @return List<User>
	 */
	@Select({"<script>",
		 	"select id,user_name,user_nick,last_login_computer,last_login_time,create_time,modify_time,enabled,role_id from sys_user",
			"where 1 = 1",
			"<if test=\" '' != user_name\"> ",
			"and username like '%${userName}%' ",
			"</if> ",
			"</script>"})
	List<User> selectList(String userName) ;
	
	/**
	 * 查询用户是否存在
	 * @param user
	 * @return List<User>
	 */
	@Select("select count(1) from sys_user where user_name = #{userName}")
	int isExistUser(User user);
	
	
	/**
	 * 修改用户信息
	 * @param findUser
	 * @return int
	 */
	@Update({"<script>",
		    "update sys_user user",
	        "set",
	        "modify_time = now(),",
	        "<if test=\" user_name!=null and  user_name!='' \">",
	        ",user_name = #{userName,jdbcType=VARCHAR}",
	        "</if>",
	        "<if test=\" userNick!=null and userNick!='' \">",
	        ",user_nick = #{userNick,jdbcType=VARCHAR}",
	        "</if>",
	        "<if test=\" password!=null and password!='' \">",
	        ",password = #{password,jdbcType=VARCHAR}",
	        "</if>",
	      	"where id = #{id,jdbcType=VARCHAR} ",
			"</script>"})
	int updateUser(User user) ;
	
	
	/**
	 * 伪删除用户
	 * @param user
	 * @return int
	 */
	@Delete("delete from sys_user where id=#{userId}")
	int deleteUser(User user) ;

	
}
