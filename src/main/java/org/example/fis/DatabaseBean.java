/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.example.fis;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Bean that creates the database table
 */
public class DatabaseBean {

    private DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void create() throws Exception {
        JdbcTemplate jdbc = new JdbcTemplate(dataSource);

        String sql = "create table employees (\n"
              + "  employee_id integer primary key,\n"
              + "  first_name varchar(10)\n"
              + ")";
        String insert0 = "insert into employees (employee_id, first_name) values (100, 'Steven')";
        String insert1 = "insert into employees (employee_id, first_name) values (101, 'Neena')";

        System.out.println("Creating table employees ...");

        jdbc.execute(sql);
        jdbc.execute(insert0);
        jdbc.execute(insert1);


        System.out.println("... created table employees");
    }

    public void destroy() throws Exception {
        JdbcTemplate jdbc = new JdbcTemplate(dataSource);

        try {
            jdbc.execute("drop table employee");
        } catch (Throwable e) {
            // ignore
        }
    }
}
