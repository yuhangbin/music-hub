package com.cboy.common.db;

/**
 * @author yuhangbin
 * @date 2023/10/27
 **/
public interface MySQLClientFactory {

	MySQLClient create(MySQLProperties properties);
}
