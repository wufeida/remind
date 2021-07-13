package com.wufeida.remind.dao;

import com.wufeida.remind.model.Remind;
import com.wufeida.remind.model.RemindCriteria.Criteria;
import com.wufeida.remind.model.RemindCriteria.Criterion;
import com.wufeida.remind.model.RemindCriteria;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class RemindSqlProvider {

    public String countByExample(RemindCriteria example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("remind");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(RemindCriteria example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("remind");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Remind record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("remind");
        
        if (record.getRemindTime() != null) {
            sql.VALUES("remind_time", "#{remindTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=BIGINT}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=SMALLINT}");
        }
        
        if (record.getMsgType() != null) {
            sql.VALUES("msg_type", "#{msgType,jdbcType=SMALLINT}");
        }
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile() != null) {
            sql.VALUES("mobile", "#{mobile,jdbcType=VARCHAR}");
        }
        
        if (record.getIsAtAll() != null) {
            sql.VALUES("is_at_all", "#{isAtAll,jdbcType=SMALLINT}");
        }
        
        if (record.getPicUrl() != null) {
            sql.VALUES("pic_url", "#{picUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateAt() != null) {
            sql.VALUES("create_at", "#{createAt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateAt() != null) {
            sql.VALUES("update_at", "#{updateAt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTimeUnit() != null) {
            sql.VALUES("time_unit", "#{timeUnit,jdbcType=VARCHAR}");
        }
        
        if (record.getIntervalTime() != null) {
            sql.VALUES("interval_time", "#{intervalTime,jdbcType=INTEGER}");
        }
        
        if (record.getNotifyType() != null) {
            sql.VALUES("notify_type", "#{notifyType,jdbcType=SMALLINT}");
        }
        
        if (record.getContent() != null) {
            sql.VALUES("content", "#{content,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExampleWithBLOBs(RemindCriteria example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("remind_time");
        sql.SELECT("user_id");
        sql.SELECT("status");
        sql.SELECT("msg_type");
        sql.SELECT("title");
        sql.SELECT("mobile");
        sql.SELECT("is_at_all");
        sql.SELECT("pic_url");
        sql.SELECT("create_at");
        sql.SELECT("update_at");
        sql.SELECT("time_unit");
        sql.SELECT("interval_time");
        sql.SELECT("notify_type");
        sql.SELECT("content");
        sql.FROM("remind");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String selectByExample(RemindCriteria example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("remind_time");
        sql.SELECT("user_id");
        sql.SELECT("status");
        sql.SELECT("msg_type");
        sql.SELECT("title");
        sql.SELECT("mobile");
        sql.SELECT("is_at_all");
        sql.SELECT("pic_url");
        sql.SELECT("create_at");
        sql.SELECT("update_at");
        sql.SELECT("time_unit");
        sql.SELECT("interval_time");
        sql.SELECT("notify_type");
        sql.FROM("remind");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Remind record = (Remind) parameter.get("record");
        RemindCriteria example = (RemindCriteria) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("remind");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getRemindTime() != null) {
            sql.SET("remind_time = #{record.remindTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{record.userId,jdbcType=BIGINT}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=SMALLINT}");
        }
        
        if (record.getMsgType() != null) {
            sql.SET("msg_type = #{record.msgType,jdbcType=SMALLINT}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile() != null) {
            sql.SET("mobile = #{record.mobile,jdbcType=VARCHAR}");
        }
        
        if (record.getIsAtAll() != null) {
            sql.SET("is_at_all = #{record.isAtAll,jdbcType=SMALLINT}");
        }
        
        if (record.getPicUrl() != null) {
            sql.SET("pic_url = #{record.picUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateAt() != null) {
            sql.SET("create_at = #{record.createAt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateAt() != null) {
            sql.SET("update_at = #{record.updateAt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTimeUnit() != null) {
            sql.SET("time_unit = #{record.timeUnit,jdbcType=VARCHAR}");
        }
        
        if (record.getIntervalTime() != null) {
            sql.SET("interval_time = #{record.intervalTime,jdbcType=INTEGER}");
        }
        
        if (record.getNotifyType() != null) {
            sql.SET("notify_type = #{record.notifyType,jdbcType=SMALLINT}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{record.content,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("remind");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("remind_time = #{record.remindTime,jdbcType=TIMESTAMP}");
        sql.SET("user_id = #{record.userId,jdbcType=BIGINT}");
        sql.SET("status = #{record.status,jdbcType=SMALLINT}");
        sql.SET("msg_type = #{record.msgType,jdbcType=SMALLINT}");
        sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        sql.SET("mobile = #{record.mobile,jdbcType=VARCHAR}");
        sql.SET("is_at_all = #{record.isAtAll,jdbcType=SMALLINT}");
        sql.SET("pic_url = #{record.picUrl,jdbcType=VARCHAR}");
        sql.SET("create_at = #{record.createAt,jdbcType=TIMESTAMP}");
        sql.SET("update_at = #{record.updateAt,jdbcType=TIMESTAMP}");
        sql.SET("time_unit = #{record.timeUnit,jdbcType=VARCHAR}");
        sql.SET("interval_time = #{record.intervalTime,jdbcType=INTEGER}");
        sql.SET("notify_type = #{record.notifyType,jdbcType=SMALLINT}");
        sql.SET("content = #{record.content,jdbcType=LONGVARCHAR}");
        
        RemindCriteria example = (RemindCriteria) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("remind");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("remind_time = #{record.remindTime,jdbcType=TIMESTAMP}");
        sql.SET("user_id = #{record.userId,jdbcType=BIGINT}");
        sql.SET("status = #{record.status,jdbcType=SMALLINT}");
        sql.SET("msg_type = #{record.msgType,jdbcType=SMALLINT}");
        sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        sql.SET("mobile = #{record.mobile,jdbcType=VARCHAR}");
        sql.SET("is_at_all = #{record.isAtAll,jdbcType=SMALLINT}");
        sql.SET("pic_url = #{record.picUrl,jdbcType=VARCHAR}");
        sql.SET("create_at = #{record.createAt,jdbcType=TIMESTAMP}");
        sql.SET("update_at = #{record.updateAt,jdbcType=TIMESTAMP}");
        sql.SET("time_unit = #{record.timeUnit,jdbcType=VARCHAR}");
        sql.SET("interval_time = #{record.intervalTime,jdbcType=INTEGER}");
        sql.SET("notify_type = #{record.notifyType,jdbcType=SMALLINT}");
        
        RemindCriteria example = (RemindCriteria) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Remind record) {
        SQL sql = new SQL();
        sql.UPDATE("remind");
        
        if (record.getRemindTime() != null) {
            sql.SET("remind_time = #{remindTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=BIGINT}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=SMALLINT}");
        }
        
        if (record.getMsgType() != null) {
            sql.SET("msg_type = #{msgType,jdbcType=SMALLINT}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile() != null) {
            sql.SET("mobile = #{mobile,jdbcType=VARCHAR}");
        }
        
        if (record.getIsAtAll() != null) {
            sql.SET("is_at_all = #{isAtAll,jdbcType=SMALLINT}");
        }
        
        if (record.getPicUrl() != null) {
            sql.SET("pic_url = #{picUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateAt() != null) {
            sql.SET("create_at = #{createAt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateAt() != null) {
            sql.SET("update_at = #{updateAt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTimeUnit() != null) {
            sql.SET("time_unit = #{timeUnit,jdbcType=VARCHAR}");
        }
        
        if (record.getIntervalTime() != null) {
            sql.SET("interval_time = #{intervalTime,jdbcType=INTEGER}");
        }
        
        if (record.getNotifyType() != null) {
            sql.SET("notify_type = #{notifyType,jdbcType=SMALLINT}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{content,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, RemindCriteria example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}