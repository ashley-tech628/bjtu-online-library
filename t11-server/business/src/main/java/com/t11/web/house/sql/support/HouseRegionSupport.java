package com.t11.web.house.sql.support;

import com.foundation.sql.AbstractTableSupport;
import com.foundation.sql.SqlUtil;
import com.foundation.sql.TableSupport;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.util.List;
public final class HouseRegionSupport extends AbstractTableSupport implements TableSupport {
    public List<SqlColumn> getColumnList() {
        if(null == columnList){
            columnList = SqlUtil.getColumnList(houseRegionTable);
        }
        return columnList;
    }
    private   List<SqlColumn> columnList;
    public SqlTable getSqlTable(){
        return houseRegionTable;
    }
    public  HouseRegionTable houseRegionTable = new HouseRegionTable();
    public  final class HouseRegionTable extends SqlTable {
        public final SqlColumn<String> id = column("id");
        public final SqlColumn<String> createTime = column("create_time");
        public final SqlColumn<String> updateTime = column("update_time");
        public final SqlColumn<String> createUser = column("create_user");
        public final SqlColumn<String> updateUser = column("update_user");
        public final SqlColumn<String> code = column("code");
        public final SqlColumn<String> name = column("name");
        public final SqlColumn<String> shortName = column("short_name");
        public final SqlColumn<Integer> landArea = column("land_area");
        public final SqlColumn<Integer> constructionArea = column("construction_area");
        public final SqlColumn<Integer> roadArea = column("road_area");
        public final SqlColumn<Integer> greenArea = column("green_area");
        public final SqlColumn<Integer> constructionNum = column("construction_num");
        public final SqlColumn<String> ownerStatus = column("owner_status");
        public final SqlColumn<String> estateCardGroupId = column("estate_card_group_id");
        public final SqlColumn<Integer> sortNum = column("sort_num");
        public HouseRegionTable() {
            super("house_region");
        }
    }
}