package com.shi.bp.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SampleResponse extends SamplePayload {
	private String returnCode;
	private String returnMessage;

	public SampleResponse(SampleHeader header, SampleBody<?> body) {
		this(header, body, null, null);
	}
	
	public SampleResponse(SampleHeader header, SampleBody<?> body, String returnCode) {
		this(header, body, returnCode, null);
	}
	
	public SampleResponse(SampleHeader header, SampleBody<?> body, String returnCode, String returnMessage) {
		super.setHeader(header);
		super.setBody(body);
		this.returnCode = returnCode;
		this.returnMessage = returnMessage;
	}
}
