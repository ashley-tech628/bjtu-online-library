package com.foundation.sql;

import java.util.List;
public record PageRecord<T>(int pageNo, int pageSize, Long total, List<T> items) {
}
