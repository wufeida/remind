package com.wufeida.remind.dao;

import com.wufeida.remind.model.Remind;
import com.wufeida.remind.model.RemindCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface RemindMapper {
    @SelectProvider(type=RemindSqlProvider.class, method="countByExample")
    long countByExample(RemindCriteria example);

    @DeleteProvider(type=RemindSqlProvider.class, method="deleteByExample")
    int deleteByExample(RemindCriteria example);

    @Delete({
        "delete from remind",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into remind (remind_time, create_at, ",
        "update_at, user_id, ",
        "content)",
        "values (#{remindTime,jdbcType=TIMESTAMP}, #{createAt,jdbcType=TIMESTAMP}, ",
        "#{updateAt,jdbcType=TIMESTAMP}, #{userId,jdbcType=INTEGER}, ",
        "#{content,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Remind record);

    @InsertProvider(type=RemindSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(Remind record);

    @SelectProvider(type=RemindSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="remind_time", property="remindTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_at", property="createAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_at", property="updateAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Remind> selectByExampleWithBLOBs(RemindCriteria example);

    @SelectProvider(type=RemindSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="remind_time", property="remindTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_at", property="createAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_at", property="updateAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER)
    })
    List<Remind> selectByExample(RemindCriteria example);

    @Select({
        "select",
        "id, remind_time, create_at, update_at, user_id, content",
        "from remind",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="remind_time", property="remindTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_at", property="createAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_at", property="updateAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    Remind selectByPrimaryKey(Integer id);

    @UpdateProvider(type=RemindSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Remind record, @Param("example") RemindCriteria example);

    @UpdateProvider(type=RemindSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") Remind record, @Param("example") RemindCriteria example);

    @UpdateProvider(type=RemindSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Remind record, @Param("example") RemindCriteria example);

    @UpdateProvider(type=RemindSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Remind record);

    @Update({
        "update remind",
        "set remind_time = #{remindTime,jdbcType=TIMESTAMP},",
          "create_at = #{createAt,jdbcType=TIMESTAMP},",
          "update_at = #{updateAt,jdbcType=TIMESTAMP},",
          "user_id = #{userId,jdbcType=INTEGER},",
          "content = #{content,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(Remind record);

    @Update({
        "update remind",
        "set remind_time = #{remindTime,jdbcType=TIMESTAMP},",
          "create_at = #{createAt,jdbcType=TIMESTAMP},",
          "update_at = #{updateAt,jdbcType=TIMESTAMP},",
          "user_id = #{userId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Remind record);
}