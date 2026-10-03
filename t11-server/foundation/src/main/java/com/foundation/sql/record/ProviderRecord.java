package com.foundation.sql.record;

import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;

import java.util.Map;

public record ProviderRecord(SelectStatementProvider provider, Map<String, String> joinTableMap) {
}
