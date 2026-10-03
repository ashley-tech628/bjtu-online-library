package com.t11.web.bookLibrary.sql.support;

import com.foundation.sql.AbstractTableSupport;
import com.foundation.sql.SqlUtil;
import com.foundation.sql.TableSupport;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.util.List;
public final class BookLibrarySupport extends AbstractTableSupport implements TableSupport {
    public List<SqlColumn> getColumnList() {
        if(null == columnList){
            columnList = SqlUtil.getColumnList(bookLibraryTable);
        }
        return columnList;
    }
    private   List<SqlColumn> columnList;
    public SqlTable getSqlTable(){
        return bookLibraryTable;
    }
    public  BookLibraryTable bookLibraryTable = new BookLibraryTable();
    public  final class BookLibraryTable extends SqlTable {
        public final SqlColumn<String> id = column("id");
//        public final SqlColumn<String> createTime = column("create_time");
//        public final SqlColumn<String> updateTime = column("update_time");
        public final SqlColumn<String> createUser = column("create_user");
        public final SqlColumn<String> updateUser = column("update_user");
        public final SqlColumn<String> type = column("type");
        public final SqlColumn<String> title = column("title");
        public final SqlColumn<String> author = column("author");
        public final SqlColumn<String> publicationTime = column("publication_time");
        public final SqlColumn<String> cover = column("cover");
        public final SqlColumn<String> description = column("description");
        public BookLibraryTable() {
            super("book_library");
        }
    }
}