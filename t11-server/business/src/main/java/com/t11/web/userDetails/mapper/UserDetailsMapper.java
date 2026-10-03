package com.t11.web.userDetails.mapper;


import com.t11.web.userDetails.entity.UserDetailsEntity;
import org.apache.ibatis.annotations.*;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import java.util.List;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.GeneralInsertStatementProvider;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
@Mapper
public interface UserDetailsMapper{

    @InsertProvider(type= SqlProviderAdapter.class, method="generalInsert")
    int insert(GeneralInsertStatementProvider insertStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("userDetailsMap")
    UserDetailsEntity get(SelectStatementProvider selectStatement);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("userDetailsMap")
    List<UserDetailsEntity> list(SelectStatementProvider selectStatement);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultType(String.class)
    <T> T getString(SelectStatementProvider selectStatement);
}
