package com.shi.bp.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SamplePayload<T> {
	private SampleHeader header;
	private SampleBody<T> body;
}
