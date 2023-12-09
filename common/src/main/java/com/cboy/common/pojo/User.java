package com.cboy.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author yuhangbin
 * @date 2023/10/29
 **/
@Data
@Builder
@AllArgsConstructor
public class User {
	private Long id;
	private String name;
	private LocalDateTime createTime;
	private LocalDateTime updateTime;
}
