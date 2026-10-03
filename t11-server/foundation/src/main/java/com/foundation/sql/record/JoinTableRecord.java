package com.foundation.sql.record;

import com.foundation.sql.DynamicSql;
import com.foundation.sql.TableSupport;

public  record  JoinTableRecord(TableSupport srcSupport, TableSupport destSupport, DynamicSql destTableSql) {}