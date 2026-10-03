package com.foundation.sql;

import com.framework.web.base.param.BaseParam;
import org.mybatis.dynamic.sql.SqlColumn;

public abstract class AbstractTableSupport implements TableSupport {
    private String tableAlias;
    private String joinedEntityPropName;
    private SqlColumn joinColumn;
    private SqlColumn joinedColumn;
    private BaseParam param;

    public BaseParam getParam() {
        return param;
    }

    public void setParam(BaseParam param) {
        this.param = param;
    }

    public String getJoinedEntityPropName() {
        return joinedEntityPropName;
    }
    public void setJoinedEntityPropName(String joinedEntityPropName) {
        this.joinedEntityPropName = joinedEntityPropName;
    }
    public SqlColumn getJoinedColumn(){
        return joinedColumn;
    }
    public void setJoinedColumn(SqlColumn joinedColumn){
        this.joinedColumn = joinedColumn;
    }

    @Override
    public String getTableAlias() {
        return tableAlias;
    }
    @Override
    public void setTableAlias(String tableAlias) {
        this.tableAlias = tableAlias;
    }
    public SqlColumn getJoinColumn() {
        return joinColumn;
    }
    public void setJoinColumn(SqlColumn joinColumn) {
        this.joinColumn = joinColumn;
    }
}
