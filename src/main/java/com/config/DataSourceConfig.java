package com.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DataSourceConfig {

	@Profile("MSSQL")
	@Bean
	public DataSource dataSource() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		dataSourceBuilder.url("jdbc:sqlserver://localhost;databaseName=aman;encrypt=false;");
		dataSourceBuilder.username("sa");
		dataSourceBuilder.password("datacard1$");
		return dataSourceBuilder.build();
	}


	@Profile("H2")
	@Bean public DataSource h2DataSource() { 
		DataSourceBuilder dataSourceBuilder
		= DataSourceBuilder.create();
		dataSourceBuilder.driverClassName("org.h2.Driver");
		dataSourceBuilder.url("jdbc:h2:mem:test"); dataSourceBuilder.username("SA");
		dataSourceBuilder.password(""); return dataSourceBuilder.build();
		}


}
