package com.foundation.sql;

import com.framework.web.base.param.BaseParam;
import org.mybatis.dynamic.sql.SqlTable;
import org.mybatis.dynamic.sql.where.AbstractWhereDSL;

public interface DynamicSql {
    void appendCondition(AbstractWhereDSL where, SqlTable sqlTable, BaseParam param);
}
