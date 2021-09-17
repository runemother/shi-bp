 package com.shi.bp.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SampleHeader {
	private String sourceSystem;
	private String targetSystem;
	private String transactionId;
}
