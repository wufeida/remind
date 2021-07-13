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
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into remind (remind_time, user_id, ",
        "status, msg_type, ",
        "title, mobile, is_at_all, ",
        "pic_url, create_at, ",
        "update_at, time_unit, ",
        "interval_time, notify_type, ",
        "content)",
        "values (#{remindTime,jdbcType=TIMESTAMP}, #{userId,jdbcType=BIGINT}, ",
        "#{status,jdbcType=SMALLINT}, #{msgType,jdbcType=SMALLINT}, ",
        "#{title,jdbcType=VARCHAR}, #{mobile,jdbcType=VARCHAR}, #{isAtAll,jdbcType=SMALLINT}, ",
        "#{picUrl,jdbcType=VARCHAR}, #{createAt,jdbcType=TIMESTAMP}, ",
        "#{updateAt,jdbcType=TIMESTAMP}, #{timeUnit,jdbcType=VARCHAR}, ",
        "#{intervalTime,jdbcType=INTEGER}, #{notifyType,jdbcType=SMALLINT}, ",
        "#{content,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(Remind record);

    @InsertProvider(type=RemindSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(Remind record);

    @SelectProvider(type=RemindSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="remind_time", property="remindTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.SMALLINT),
        @Result(column="msg_type", property="msgType", jdbcType=JdbcType.SMALLINT),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_at_all", property="isAtAll", jdbcType=JdbcType.SMALLINT),
        @Result(column="pic_url", property="picUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_at", property="createAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_at", property="updateAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="time_unit", property="timeUnit", jdbcType=JdbcType.VARCHAR),
        @Result(column="interval_time", property="intervalTime", jdbcType=JdbcType.INTEGER),
        @Result(column="notify_type", property="notifyType", jdbcType=JdbcType.SMALLINT),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Remind> selectByExampleWithBLOBs(RemindCriteria example);

    @SelectProvider(type=RemindSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="remind_time", property="remindTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.SMALLINT),
        @Result(column="msg_type", property="msgType", jdbcType=JdbcType.SMALLINT),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_at_all", property="isAtAll", jdbcType=JdbcType.SMALLINT),
        @Result(column="pic_url", property="picUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_at", property="createAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_at", property="updateAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="time_unit", property="timeUnit", jdbcType=JdbcType.VARCHAR),
        @Result(column="interval_time", property="intervalTime", jdbcType=JdbcType.INTEGER),
        @Result(column="notify_type", property="notifyType", jdbcType=JdbcType.SMALLINT)
    })
    List<Remind> selectByExample(RemindCriteria example);

    @Select({
        "select",
        "id, remind_time, user_id, status, msg_type, title, mobile, is_at_all, pic_url, ",
        "create_at, update_at, time_unit, interval_time, notify_type, content",
        "from remind",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="remind_time", property="remindTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.SMALLINT),
        @Result(column="msg_type", property="msgType", jdbcType=JdbcType.SMALLINT),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_at_all", property="isAtAll", jdbcType=JdbcType.SMALLINT),
        @Result(column="pic_url", property="picUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_at", property="createAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_at", property="updateAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="time_unit", property="timeUnit", jdbcType=JdbcType.VARCHAR),
        @Result(column="interval_time", property="intervalTime", jdbcType=JdbcType.INTEGER),
        @Result(column="notify_type", property="notifyType", jdbcType=JdbcType.SMALLINT),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    Remind selectByPrimaryKey(Long id);

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
          "user_id = #{userId,jdbcType=BIGINT},",
          "status = #{status,jdbcType=SMALLINT},",
          "msg_type = #{msgType,jdbcType=SMALLINT},",
          "title = #{title,jdbcType=VARCHAR},",
          "mobile = #{mobile,jdbcType=VARCHAR},",
          "is_at_all = #{isAtAll,jdbcType=SMALLINT},",
          "pic_url = #{picUrl,jdbcType=VARCHAR},",
          "create_at = #{createAt,jdbcType=TIMESTAMP},",
          "update_at = #{updateAt,jdbcType=TIMESTAMP},",
          "time_unit = #{timeUnit,jdbcType=VARCHAR},",
          "interval_time = #{intervalTime,jdbcType=INTEGER},",
          "notify_type = #{notifyType,jdbcType=SMALLINT},",
          "content = #{content,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(Remind record);

    @Update({
        "update remind",
        "set remind_time = #{remindTime,jdbcType=TIMESTAMP},",
          "user_id = #{userId,jdbcType=BIGINT},",
          "status = #{status,jdbcType=SMALLINT},",
          "msg_type = #{msgType,jdbcType=SMALLINT},",
          "title = #{title,jdbcType=VARCHAR},",
          "mobile = #{mobile,jdbcType=VARCHAR},",
          "is_at_all = #{isAtAll,jdbcType=SMALLINT},",
          "pic_url = #{picUrl,jdbcType=VARCHAR},",
          "create_at = #{createAt,jdbcType=TIMESTAMP},",
          "update_at = #{updateAt,jdbcType=TIMESTAMP},",
          "time_unit = #{timeUnit,jdbcType=VARCHAR},",
          "interval_time = #{intervalTime,jdbcType=INTEGER},",
          "notify_type = #{notifyType,jdbcType=SMALLINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Remind record);
}