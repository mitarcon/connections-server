package com.mitarcon.connections.domain;

import java.math.BigInteger;

import lombok.Data;

@Data
public class Greeting {
	private BigInteger id;
	private String text;
}
