package com.reception.system.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
	@Insert("insert into sys_user(id,user_name,user_nick,password,create_time,role_id)values((select max(id)+1 from sys_user),#{userName},#{userNick},#{password},sysdate,#{roleId})")
	int addUser(User user) ;
	
	/**
	 * 查询用户
	 * @param user
	 * @return List<User>
	 */
	@Select({"<script>",
		 	"SELECT u.ID, u.user_name userName, u.user_nick userNick, u.last_login_computer lastLoginComputer, u.last_login_time lastLoginTime, u.create_time createTime, u.modify_time modifyTime, u.enabled, u.role_id roleId, r.role_name roleName FROM sys_user u,sys_role r where r.ID=u.ROLE_ID	",
			"<if test=\" '' != userName\"> ",
			"and user_name like concat(#{userName},'%') ",
			"</if> ",
			"</script>"})
	List<User> selectList(@Param(value="userName")String userName) ;
	
	/**
	 * 查询用户是否存在
	 * @param user
	 * @return List<User>
	 */
	@Select("select count(1) from sys_user where user_name = #{userName}")
	int isExistUser(User user);
	
	/**
	 * 查询用户
	 * @param id
	 * @return List<User>
	 */
	@Select("select id,user_name userName,user_nick userNick,last_login_computer lastLoginComputer,last_login_time lastLoginTime,create_time createTime,modify_time modifyTime,enabled,role_id roleId from sys_user where id = #{id}")
	User selectById(String id);
	
	
	/**
	 * 修改用户信息
	 * @param findUser
	 * @return int
	 */
	@Update({"<script>",
		    "update sys_user",
	        " SET ",
	        "modify_time = sysdate",
	        "<if test=\" userNick!=null and userNick!='' \">",
	        ",user_nick = #{userNick,jdbcType=VARCHAR}",
	        "</if>",
	        "<if test=\" password!=null and password!='' \">",
	        ",password = #{password,jdbcType=VARCHAR}",
	        "</if>",
	        "<if test=\" roleId!=null and roleId!='' \">",
	        ",role_id = #{roleId,jdbcType=VARCHAR}",
	        "</if>",
	      	" where id = #{id,jdbcType=VARCHAR} ",
			"</script>"})
	int updateUser(User user) ;
	
	
	/**
	 * 伪删除用户
	 * @param user
	 * @return int
	 */
	@Delete("delete from sys_user where id=#{id}")
	int deleteUser(User user) ;

	
}
