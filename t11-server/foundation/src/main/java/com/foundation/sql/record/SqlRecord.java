package com.foundation.sql.record;

import java.util.List;
import java.util.Map;

public record SqlRecord(String sql, List<Object> paramValueList) {
}
