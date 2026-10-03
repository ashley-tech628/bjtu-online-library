package com.foundation.sql;

import com.framework.web.base.param.BaseParam;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.util.List;

public interface TableSupport {
    BaseParam getParam();
    void setParam(BaseParam param);
    String getJoinedEntityPropName();
    void setJoinedEntityPropName(String joinedEntityPropName);
    SqlColumn getJoinedColumn();
    void setJoinedColumn(SqlColumn joinedColumn);
    String getTableAlias();
    void setTableAlias(String tableAlias);
    SqlColumn getJoinColumn();
    void setJoinColumn(SqlColumn joinColumn);
    SqlTable getSqlTable();
    List<SqlColumn> getColumnList();
}
