package com.reception.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reception.system.model.Module;
import com.reception.system.model.Role;
import com.reception.system.model.RoleModule;

/**
 * 角色管理
 */
@Mapper
public interface RoleDao {

	/**
	 * 添加角色
	 * @param role
	 * @return int
	 */
	@Insert("insert into sys_role(id,role_name,description)values((select max(id)+1 from sys_role),#{roleName},#{description})")
	int addRole(Role role);

	/**
	 * 更新角色
	 * @param role
	 * @return int
	 */
	@Update("UPDATE sys_role SET role_name=#{roleName},description=#{description} where id = #{id}")
	int updateRole(Role role);

	/**
	 * 查询所有角色
	 * @param
	 * @return list
	 */
	@Select({ "<script>", "SELECT id,role_name roleName,description", "FROM SYS_ROLE", "where 1=1 ",
			"<if test=\" '' != roleName  and null != roleName\">", "and role_name like concat(#{roleName},'%')", "</if>", "</script>" })
	List<Role> selectListByName(@Param(value="roleName")String roleName);

	@Select("SELECT id,role_name roleName,description FROM SYS_ROLE")
	List<Role> selectList();
	
	@Select("SELECT id,role_name roleName,description FROM SYS_ROLE where id=#{id}")
	Role selectById(String id);
	
	/**
	 * 删除角色
	 * @param role
	 * @return int
	 */
	@Delete("delete from sys_role where id=#{id}")
	int deleteRole(String role_id);

	/**
	 * 删除权限与角色的关系
	 * @param role
	 * @return int
	 */
	@Delete("delete from sys_role_module where role_id=#{role_id}")
	int deleteRoleModule(String role_id);

	/**
	 * 修改角色权限删除之后再插入
	 * @param menus
	 * @return int
	 */
	@Insert({ "<script>", "INSERT ALL ", "<foreach collection=\"menuIds\" item=\"moduleId\"   separator=\"\">",
			" into sys_role_module (role_id,module_id)", "values ", "(#{roleId},#{moduleId})", "</foreach>",
			"select 1 from dual", "</script>" })
	int addRoleModule(Map map);

	/**
	 * 查询角色权限信息
	 * @param roleId
	 */
	@Select("SELECT role_id,module_id from SYS_ROLE_MODULE where ROLE_ID=#{roleId}")
	List<RoleModule> selectRoleModule(String roleId);



}
