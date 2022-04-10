package com.example.application.event;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EventValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Event.class.equals(clazz); // Event 타입인지 확인
    }

    @Override
    public void validate(Object target, Errors errors) {
        // ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "notempty", "Empty title is not allowed");
        Event event = (Event) target;
        if(event.getTitle() == null) {
            errors.rejectValue("title", "notempty", "Empty title is not allowed");
        }
    }
}
