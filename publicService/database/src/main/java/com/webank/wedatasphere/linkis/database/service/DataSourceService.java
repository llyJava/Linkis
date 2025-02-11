/*
 * Copyright 2019 WeBank
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.webank.wedatasphere.linkis.database.service;

import com.webank.wedatasphere.linkis.database.domain.DataSource;
import org.codehaus.jackson.JsonNode;
/**
 * Created by shanhuang on 9/13/18.
 */
public interface DataSourceService {

    void create(DataSource dataSource, String userName) throws Exception;

    void update(DataSource dataSource, String userName) throws Exception;

    void delete(Integer id) throws Exception;

    public String analyseDataSourceSql(DataSource dataSource) throws Exception;

    JsonNode getDirContent(String path, String userName) throws Exception;

    JsonNode getDbs(String userName) throws Exception;

    JsonNode getDbsWithTables(String userName) throws Exception;

    JsonNode queryTables(String database, String userName);

    JsonNode queryTableMeta(String dbName, String tableName, String userName);

    JsonNode getTableSize(String dbName, String tableName, String userName);

    JsonNode getPartitionSize(String dbName, String tableName, String partitionName, String userName);

    JsonNode getPartitions(String dbName, String tableName, String userName);
}