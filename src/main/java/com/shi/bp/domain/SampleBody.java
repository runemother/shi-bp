package com.shi.bp.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SampleBody<T> {
	private String arg1;
	private String arg2;
	private T data;
}
