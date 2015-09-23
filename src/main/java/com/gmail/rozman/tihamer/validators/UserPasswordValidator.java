package com.gmail.rozman.tihamer.validators;

import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;
import org.apache.wicket.validation.ValidationError;

/**
 * Created by trozman on 2015. 09. 23..
 */
public class UserPasswordValidator implements IValidator<String> {

    private String REGEX_PATTERN = "\\w";

    public void validate(IValidatable<String> validatable) {
        if(validatable.getValue().length() <= 2) {
            validatable.error(new ValidationError("Error: password length must be longer than 2"));
        }
        if( ! validatable.getValue().matches(REGEX_PATTERN)) {
            validatable.error(new ValidationError("Error: password must contain only numbers and letters (a-z, 0-9)"));
        }
    }
}
