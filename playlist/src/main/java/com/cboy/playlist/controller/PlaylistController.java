package com.cboy.playlist.controller;

import com.cboy.common.pojo.Playlist;
import com.cboy.common.pojo.PlaylistDetails;
import com.cboy.common.pojo.Result;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author yuhangbin
 * @date 2023/10/27
 **/
@RestController
@RequestMapping(path = "/playlist")
public class PlaylistController {

	@HystrixCommand(fallbackMethod = "fallback")
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public Result<Playlist> getPlaylistById(@RequestParam("playlistId")Long id) {
		return null;
	}

	public Result<Playlist> fallback(Long id) {
		return Result.success(new Playlist());
	}
}
