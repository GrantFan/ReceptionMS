package com.reception.guest.dao.sqlmapper;

import com.reception.guest.entity.Guest_Info;
import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhangwei
 * @description
 * @date created in 16:10 2018/4/13
 * @throws Exception
 */
public class Guest_InfoSql {

    private static  final Logger log = LoggerFactory.getLogger(Guest_InfoSql.class);

    /**
     * 添加宾客信息
     * @param guest_info
     * @return String
     */
    public String InsertGuest_Info(Guest_Info guest_info) {
        String sql = new SQL() {
            {
                INSERT_INTO("GUEST_INFO");
                VALUES("guest_name", "#{guest_name}");
                VALUES("main_position", "#{main_position}");
                VALUES("deputy_position", "#{deputy_position}");
                VALUES("office_area", "#{office_area}");
                VALUES("sex", "#{sex}");
                VALUES("age", "#{age}");
                VALUES("birth_date", "#{birth_date}");
                VALUES("nation", "#{nation}");
                VALUES("education", "#{education}");
                VALUES("origin_place", "#{origin_place}");
                VALUES("telphone", "#{telphone}");
                VALUES("phone", "#{phone}");
                VALUES("email", "#{email}");
                VALUES("address", "#{address}");
                VALUES("guest_type", "#{guest_type}");
                VALUES("remark", "#{remark}");
            }
        }.toString();
        log.info("添加宾客信息：" + sql);
        return sql;
     }
        /**
         * 更新宾客信息
         * @param guest_info
         * @return String
         */
        public String UpdateGuest_Info(Guest_Info guest_info){
            String sql = new SQL(){
                {
                    UPDATE("GUEST_INFO");
                    SET("guest_name = #{guest_name}");
                    SET("main_position = #{main_position}");
                    SET("deputy_position = #{deputy_position}");
                    SET("office_area = #{office_area}");
                    SET("sex = #{sex}");
                    SET("age = #{age}");
                    SET("birth_date = #{birth_date}");
                    SET("nation = #{nation}");
                    SET("education = #{education}");
                    SET("origin_place = #{origin_place}");
                    SET("telphone = #{telphone}");
                    SET("phone = #{phone}");
                    SET("email = #{email}");
                    SET("address = #{address}");
                    SET("guest_type = #{guest_type}");
                    SET("remark = #{remark}");
                    WHERE("guest_name=#{guest_name}");
                }
            }.toString();
            log.info("更新宾客信息："+sql);
            return  sql;
        }

}
