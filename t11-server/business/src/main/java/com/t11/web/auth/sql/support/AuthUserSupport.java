package com.t11.web.auth.sql.support;

import com.foundation.sql.AbstractTableSupport;
import com.foundation.sql.SqlUtil;
import com.foundation.sql.TableSupport;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.util.List;
public final class AuthUserSupport extends AbstractTableSupport implements TableSupport {
    public List<SqlColumn> getColumnList() {
        if(null == columnList){
            columnList = SqlUtil.getColumnList(authUserTable);
        }
        return columnList;
    }
    private   List<SqlColumn> columnList;
    public SqlTable getSqlTable(){
        return authUserTable;
    }
    public  AuthUserTable authUserTable = new AuthUserTable();
    public  final class AuthUserTable extends SqlTable {
        public final SqlColumn<String> id = column("id");
        public final SqlColumn<String> username = column("username");
        public final SqlColumn<String> password = column("password");
        public final SqlColumn<String> realName = column("real_name");
        public final SqlColumn<String> lastLoginTime = column("last_login_time");
        public final SqlColumn<String> avatarGroupId = column("avatar_group_id");
        public final SqlColumn<String> mobile = column("mobile");
        public final SqlColumn<String> remark = column("remark");
        public final SqlColumn<Integer> isValid = column("is_valid");
        public final SqlColumn<Integer> sortNum = column("sort_num");
        public final SqlColumn<String> createTime = column("create_time");
        public final SqlColumn<String> updateTime = column("update_time");
        public final SqlColumn<String> createUser = column("create_user");
        public final SqlColumn<String> updateUser = column("update_user");
        public AuthUserTable() {
            super("auth_user");
        }
    }
}