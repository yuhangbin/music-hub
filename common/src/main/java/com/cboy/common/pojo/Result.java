package com.cboy.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author yuhangbin
 * @date 2023/10/29
 **/
@Data
@Builder
@AllArgsConstructor
public class Result<T> {

	private int code;
	private String msg;
	private T data;

	public static <T> Result<T> success(T data) {
		return new Result<>(0, "success", data);
	}

	public static <T> Result<T> error(T data) {
		return new Result<>(1, "error", data);
	}

	public static Result<Void> success() {
		return new Result<>(0, "", null);
	}
}
