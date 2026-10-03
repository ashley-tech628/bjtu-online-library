package com.foundation.sql.record;

import java.util.List;
import java.util.Map;

public record SelectMapRecord(String sql, List<Object> paramValueList, Map<String, String> joinTableMap) {
}
