package com.cboy.application.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuhangbin
 * @date 2023/6/11
 **/
@RestController
public class AppController {

	@RequestMapping(path = "/hello", method = RequestMethod.GET)
	public String hello() {
		return "hello";
	}
}
