package com.javafranclin.handlers;

import java.util.ArrayList;
import java.util.List;

import com.javafranclin.enums.ErrorCodes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErreurDTo {

	private Integer httpCode;

	private ErrorCodes code;

	private String message;

	private List<String> errors = new ArrayList<>();
}
