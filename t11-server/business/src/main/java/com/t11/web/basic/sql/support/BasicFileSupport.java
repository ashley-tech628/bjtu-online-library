package com.t11.web.basic.sql.support;

import com.foundation.sql.AbstractTableSupport;
import com.foundation.sql.SqlUtil;
import com.foundation.sql.TableSupport;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.util.List;
public final class BasicFileSupport extends AbstractTableSupport implements TableSupport {
    public List<SqlColumn> getColumnList() {
        if(null == columnList){
            columnList = SqlUtil.getColumnList(basicFileTable);
        }
        return columnList;
    }
    private   List<SqlColumn> columnList;
    public SqlTable getSqlTable(){
        return basicFileTable;
    }
    public  BasicFileTable basicFileTable = new BasicFileTable();
    public  final class BasicFileTable extends SqlTable {
        public final SqlColumn<String> id = column("id");
        public final SqlColumn<String> fromType = column("from_type");
        public final SqlColumn<String> groupId = column("group_id");
        public final SqlColumn<String> name = column("name");
        public final SqlColumn<String> extName = column("ext_name");
        public final SqlColumn<String> contentType = column("content_type");
        public final SqlColumn<Double> size = column("size");
        public final SqlColumn<String> path = column("path");
        public final SqlColumn<Integer> isValid = column("is_valid");
        public final SqlColumn<Integer> sortNum = column("sort_num");
        public final SqlColumn<String> createTime = column("create_time");
        public final SqlColumn<String> updateTime = column("update_time");
        public final SqlColumn<String> createUser = column("create_user");
        public final SqlColumn<String> updateUser = column("update_user");
        public BasicFileTable() {
            super("basic_file");
        }
    }
}