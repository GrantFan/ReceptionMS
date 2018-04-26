package com.reception.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.reception.system.model.Module; 

/**
 * 菜单管理
 */
@Mapper
public interface ModuleDao {
	
	
	/**
	 * 添加菜单
	 * @param menu
	 * @return int
	 */
	@Insert("insert into sys_module(module_name,module_id,module_parent_id,url,sort,create_time,icon,remark) values(#{moduleName},#{moduleId},#{moduleParentId},#{url},#{sort},#{createTime},#{icon},#{remark})")
	int addModule(Module module);

	/**
	 * 删除菜单
	 * @param menu
	 * @return int
	 */
	@Delete("delete from sys_module where module_id=#{moduleId}")
	int deleteModule(Module module) ;

	/**
	 * 修改菜单
	 * @param menu
	 * @return int
	 */
	@Update({"<script>",
		"update  sys_module ",
        "<set>",
        "<if test=\"moduleName!=null and moduleName!='' \">",
        "module_name=#{moduleName,jdbcType=VARCHAR},",
        "</if>",
        "<if test=\"moduleParentId!=null and moduleParentId!='' \">",
        "module_parent_id=#{moduleParentId,jdbcType=VARCHAR},",
        "</if>",
        "<if test=\"url!=null and url!='' \">",
        "url=#{url,jdbcType=VARCHAR},",
        "</if>",
       	"<if test=\"sort!=null and sort!='' \">",
       	"sort=#{sort,jdbcType=VARCHAR},",
       	"</if>",
        "</set>",
       	 "where module_id=#{moduleId}",
	"</script>"})
	int updateModule(Module module) ;
	
	
	/**
	 * 查询模块列表
	 * @return list
	 */
	@Select({"<script>",
		"select id,module_name,module_id,module_parent_id,url,sort,create_time,icon,remark from sys_module order by sort",
		"<where>",
		"<if test=\" '' != module_name and null != module_name  \">",
		" and module_name like #{moduleName} ",
		"</if>",
		"</where>",
	"</script>"})
	List<Module> selectModuleList(String moduleName) ;
	 
	/**
	 * 通过角色权限查询功能模块
	 * @param menu
	 * @return list
	 */
	@Select({"<script>",
		"SELECT m.id,m.module_name moduleName,m.module_id moduleId,m.module_parent_id moduleParentId,m.url,m.sort,m.create_time createTime,m.icon,m.remark FROM sys_module m",
		"<if test=\"role_id != 0 \">",
		" ,sys_role_module role where 1=1 and m.module_id = role.module_id",
		" and role.role_id = #{role_id} ",
		"</if>",
		" order by m.sort",
		"</script>"})
	List<Module> selectModuleByRole(@Param("role_id")String role_id) ;
	
	
	/**
	 * 删除菜单与角色之间的关系
	 * @param menu
	 * @return
	 */
	@Delete("delete from sys_role_module where module_id=#{module_id}")
	int deleteModuleRole(String module_id) ;

}
