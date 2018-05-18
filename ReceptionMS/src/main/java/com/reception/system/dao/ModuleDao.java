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
	@Insert("insert into sys_module(id,module_name,module_id,module_parent_id,url,sort,create_time,icon,remark) values((select nvl(max(id),0)+1 from sys_module),#{moduleName},(select nvl(max(module_id),0)+1 from sys_module),#{moduleParentId},#{url},#{sort},sysdate,#{icon},#{remark})")
	int addModule(Module module);

	/**
	 * 删除菜单
	 * @param menu
	 * @return int
	 */
	@Delete("delete from sys_module where id=#{id} and delete_flag='1' ")
	int deleteModule(@Param("id")String id) ;

	/**
	 * 修改菜单
	 * @param menu
	 * @return int
	 */
	@Update({"<script>",
		"update  sys_module ",
        "<set>",
        "<if test=\"moduleName!=null and moduleName!='' \">",
        "module_name=#{moduleName,jdbcType=VARCHAR}",
        "</if>",
        "<if test=\"moduleParentId!=null and moduleParentId!='' \">",
        ",module_parent_id=#{moduleParentId,jdbcType=VARCHAR} ",
        "</if>",
        "<if test=\"url!=null and url!='' \">",
        ",url=#{url,jdbcType=VARCHAR}",
        "</if>",
       	"<if test=\"sort!=null and sort!='' \">",
       	",sort=#{sort,jdbcType=VARCHAR}",
       	"</if>",
    	"<if test=\"remark!=null and remark!='' \">",
       	",remark=#{remark,jdbcType=VARCHAR}",
       	"</if>",
        "</set>",
       	 "where id=#{id}",
	"</script>"})
	int updateModule(Module module) ;
	
	
	/**
	 * 查询模块列表
	 * @return list
	 */
	@Select({"<script>",
		"SELECT ID, module_name moduleName, module_id moduleId, MODULE_PARENT_ID, url, SORT, create_time createTime, icon, remark FROM sys_module  ORDER BY MODULE_PARENT_ID, SORT",
		"</script>"})
	List<Module> selectModuleList() ;
	
	/**
	 * 查询模块列表
	 * @return list
	 */
	@Select({"<script>",
		"SELECT ID, module_name moduleName, module_id moduleId, MODULE_PARENT_ID, nvl((select MODULE_NAME from SYS_MODULE a where b.MODULE_PARENT_ID=a.MODULE_ID),'接待管理系统') moduleParentName, nvl(url,'无') url, SORT, create_time createTime, icon, remark FROM sys_module b ",
		"<where>",
		"<if test=\" '' != moduleName and null != moduleName  \">",
		" and module_name like concat(#{moduleName},'%')",
		"</if>",
		"</where>",
		"ORDER BY MODULE_PARENT_ID, SORT",
	"</script>"})
	List<Module> selectModuleListByName(@Param(value="moduleName")String moduleName) ;
	
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

	
	@Select({"<script>",
		"SELECT ID, module_name moduleName, module_id moduleId, MODULE_PARENT_ID, url, SORT, create_time createTime, icon, remark FROM sys_module  where id=#{id}",
		"</script>"})
	Module selectModuleById(@Param("id")String id);

}
