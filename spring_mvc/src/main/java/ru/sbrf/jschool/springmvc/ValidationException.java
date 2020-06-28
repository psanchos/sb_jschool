package ru.sbrf.jschool.springmvc;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "invalid request data")
public class ValidationException extends RuntimeException {
}
