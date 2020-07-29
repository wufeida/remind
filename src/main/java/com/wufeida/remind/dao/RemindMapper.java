package com.wufeida.remind.dao;

import com.wufeida.remind.model.Remind;
import com.wufeida.remind.model.RemindCriteria;
import com.wufeida.remind.model.RemindWithBLOBs;
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
        "status, type, title, ",
        "mobile, content, ",
        "pic_url)",
        "values (#{remindTime,jdbcType=TIMESTAMP}, #{createAt,jdbcType=TIMESTAMP}, ",
        "#{updateAt,jdbcType=TIMESTAMP}, #{userId,jdbcType=INTEGER}, ",
        "#{status,jdbcType=TINYINT}, #{type,jdbcType=TINYINT}, #{title,jdbcType=VARCHAR}, ",
        "#{mobile,jdbcType=VARCHAR}, #{content,jdbcType=LONGVARCHAR}, ",
        "#{picUrl,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(RemindWithBLOBs record);

    @InsertProvider(type=RemindSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(RemindWithBLOBs record);

    @SelectProvider(type=RemindSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="remind_time", property="remindTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_at", property="createAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_at", property="updateAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="pic_url", property="picUrl", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<RemindWithBLOBs> selectByExampleWithBLOBs(RemindCriteria example);

    @SelectProvider(type=RemindSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="remind_time", property="remindTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_at", property="createAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_at", property="updateAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR)
    })
    List<Remind> selectByExample(RemindCriteria example);

    @Select({
        "select",
        "id, remind_time, create_at, update_at, user_id, status, type, title, mobile, ",
        "content, pic_url",
        "from remind",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="remind_time", property="remindTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_at", property="createAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_at", property="updateAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="pic_url", property="picUrl", jdbcType=JdbcType.LONGVARCHAR)
    })
    RemindWithBLOBs selectByPrimaryKey(Integer id);

    @UpdateProvider(type=RemindSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RemindWithBLOBs record, @Param("example") RemindCriteria example);

    @UpdateProvider(type=RemindSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") RemindWithBLOBs record, @Param("example") RemindCriteria example);

    @UpdateProvider(type=RemindSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Remind record, @Param("example") RemindCriteria example);

    @UpdateProvider(type=RemindSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RemindWithBLOBs record);

    @Update({
        "update remind",
        "set remind_time = #{remindTime,jdbcType=TIMESTAMP},",
          "create_at = #{createAt,jdbcType=TIMESTAMP},",
          "update_at = #{updateAt,jdbcType=TIMESTAMP},",
          "user_id = #{userId,jdbcType=INTEGER},",
          "status = #{status,jdbcType=TINYINT},",
          "type = #{type,jdbcType=TINYINT},",
          "title = #{title,jdbcType=VARCHAR},",
          "mobile = #{mobile,jdbcType=VARCHAR},",
          "content = #{content,jdbcType=LONGVARCHAR},",
          "pic_url = #{picUrl,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(RemindWithBLOBs record);

    @Update({
        "update remind",
        "set remind_time = #{remindTime,jdbcType=TIMESTAMP},",
          "create_at = #{createAt,jdbcType=TIMESTAMP},",
          "update_at = #{updateAt,jdbcType=TIMESTAMP},",
          "user_id = #{userId,jdbcType=INTEGER},",
          "status = #{status,jdbcType=TINYINT},",
          "type = #{type,jdbcType=TINYINT},",
          "title = #{title,jdbcType=VARCHAR},",
          "mobile = #{mobile,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Remind record);
}