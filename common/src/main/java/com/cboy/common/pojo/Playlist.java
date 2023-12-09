package com.cboy.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class Playlist {
	private Long id;
	private String name;
	private List<Long> songIdList;
	private LocalDateTime createTime;
	private LocalDateTime updateTime;
}