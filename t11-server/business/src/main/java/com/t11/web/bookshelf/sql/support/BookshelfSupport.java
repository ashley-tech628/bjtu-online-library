package com.t11.web.bookshelf.sql.support;

import com.foundation.sql.AbstractTableSupport;
import com.foundation.sql.SqlUtil;
import com.foundation.sql.TableSupport;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.util.List;

public class BookshelfSupport extends AbstractTableSupport implements TableSupport {
    public List<SqlColumn> getColumnList() {
        if(null == columnList){
            columnList = SqlUtil.getColumnList(bookshelfTable);
        }
        return columnList;
    }
    private   List<SqlColumn> columnList;
    public SqlTable getSqlTable(){
        return bookshelfTable;
    }
    public BookshelfSupport.BookshelfTable bookshelfTable = new BookshelfSupport.BookshelfTable();
    public  final class BookshelfTable extends SqlTable {
        public final SqlColumn<String> id = column("id");
        public final SqlColumn<String> name = column("name");
        public final SqlColumn<String> allbooks = column("allbooks");

        public BookshelfTable() {
            super("bookshelf");
        }
    }
}

