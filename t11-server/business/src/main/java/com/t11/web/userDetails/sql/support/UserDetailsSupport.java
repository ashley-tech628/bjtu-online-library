package com.t11.web.userDetails.sql.support;

import com.foundation.sql.AbstractTableSupport;
import com.foundation.sql.SqlUtil;
import com.foundation.sql.TableSupport;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.util.List;
public final class UserDetailsSupport extends AbstractTableSupport implements TableSupport {
    public List<SqlColumn> getColumnList() {
        if(null == columnList){
            columnList = SqlUtil.getColumnList(userDetailsTable);
        }
        return columnList;
    }
    private   List<SqlColumn> columnList;
    public SqlTable getSqlTable(){
        return userDetailsTable;
    }
    public  UserDetailsTable userDetailsTable = new UserDetailsTable();
    public  final class UserDetailsTable extends SqlTable {
        public final SqlColumn<String> user_id = column("user_id");
        public final SqlColumn<String> user_name = column("user_name");
        public final SqlColumn<String> books = column("books");
        public UserDetailsTable() {
            super("user_details");
        }
    }
}
