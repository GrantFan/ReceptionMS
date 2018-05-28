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
                VALUES("id", "(select nvl(MAX(id),0)+1 from GUEST_INFO)");
                VALUES("guest_name", "#{guest_name}");
                VALUES("main_position", "#{main_position}");
                VALUES("deputy_position", "#{deputy_position}");
                VALUES("office_area", "#{office_area}");
                VALUES("sex", "#{sex}");
                VALUES("birth_date", "#{birth_date}");
                VALUES("nation", "#{nation}");
                VALUES("menu", "#{menu}");
                VALUES("drink", "#{drink}");
                VALUES("flavor", "#{flavor}");
                VALUES("sleep", "#{sleep}");
                VALUES("origin_place", "#{origin_place}");
                VALUES("remark", "#{remark}");
                VALUES("url", "#{url}");
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
                    SET("birth_date = #{birth_date}");
                    SET("nation = #{nation}");
                    SET("origin_place = #{origin_place}");
                    SET("menu = #{menu}");
                    SET("drink = #{drink}");
                    SET("flavor = #{flavor}");
                    SET("sleep = #{sleep}");
                    SET("remark = #{remark}");
                    SET("url = #{url}");
                    WHERE("id=#{id}");
                }
            }.toString();
            log.info("更新宾客信息："+sql);
            return  sql;
        }

}
