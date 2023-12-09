package com.cboy.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author yuhangbin
 * @date 2023/10/29
 **/
@Data
@Builder
@AllArgsConstructor
public class PlaylistDetails {
	private Long id;
	private String name;
	private List<SongDetails> songDetailsList;
	private LocalDateTime createTime;
	private LocalDateTime updateTime;
}
