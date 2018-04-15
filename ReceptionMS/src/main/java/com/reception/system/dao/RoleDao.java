package com.reception.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
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
	@Insert("insert into sys_role(role_name,description)values(#{roleName},#{description})")
	int addRole(Role role);

	/**
	 * 更新角色
	 * @param role
	 * @return int
	 */
	@Update({ "<script>", "UPDATE sys_role SET", "<if test=\"role_name != null and role_name != ''\">",
			"role_name = #{roleName,jdbcType=VARCHAR},", "</if>", "<if test=\"description != null and description != ''\">",
			"description = #{description,jdbcType=VARCHAR}", "</if> ", "where id = #{id}", "</script>" })
	int updateRole(Role role);

	/**
	 * 查询所有角色
	 * @param
	 * @return list
	 */
	@Select({ "<script>", "SELECT id,role_name,description", "FROM SYS_ROLE", "where 1=1 ",
			"<if test=\" '' != roleName  and null != roleName\">", "and role_name=#{roleName}", "</if>", "</script>" })
	List<Role> selectList(String roleName);

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
	@Insert({ "<script>", "insert into sys_role_module", "(role_id,module_id)", "values",
			"<foreach collection=\"menuIds\" item=\"menu\"   separator=\",\">", "(#{roleId},#{menu})", "</foreach>",
			"</script>" })
	int addRoleModule(Map map);

	/**
	 * 查询角色权限信息
	 * @param roleId
	 */
	@Select("SELECT m.id,m.module_name,m.module_id,m.module_parent_id,m.url,m.sort,m.create_time,m.icon,m.remark FROM sys_module m left join sys_role_module rm on m.module_id=rm.module_id WHERE rm.role_id=#{role_id}")
	List<RoleModule> selectRoleModule(String roleId);
}
