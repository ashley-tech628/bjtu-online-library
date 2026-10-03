package com.t11.web.books.sql.support;

import com.foundation.sql.AbstractTableSupport;
import com.foundation.sql.SqlUtil;
import com.foundation.sql.TableSupport;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.util.List;

public class BookRecommedsSupport extends AbstractTableSupport implements TableSupport {

    public List<SqlColumn> getColumnList() {
        if(null == columnList){
            columnList = SqlUtil.getColumnList(bookRecommendsTable);
        }
        return columnList;
    }
    private   List<SqlColumn> columnList;
    public SqlTable getSqlTable(){
        return bookRecommendsTable;
    }

    public BookRecommedsSupport.BookRecommendsTable bookRecommendsTable = new BookRecommedsSupport.BookRecommendsTable();

    public  final class BookRecommendsTable extends SqlTable {
        public final SqlColumn<String> id = column("id");
        public final SqlColumn<String> code = column("code");
        public final SqlColumn<String> name = column("name");
        public final SqlColumn<Integer> isValid = column("is_valid");
        public final SqlColumn<Integer> sortNum = column("sort_num");
        public final SqlColumn<String> createTime = column("create_time");
        public final SqlColumn<String> updateTime = column("update_time");
        public final SqlColumn<String> createUser = column("create_user");
        public final SqlColumn<String> updateUser = column("update_user");
        public BookRecommendsTable() {
            super("auth_role");
        }
    }
}
