package com.gmail.rozman.tihamer.validators;

import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;
import org.apache.wicket.validation.ValidationError;

/**
 * Created by trozman on 2015. 09. 23..
 */
public class UserNameValidator implements IValidator<String> {

    private String REGEX_PATTERN = "^[\\pL\\pN\\p{Pc}]*$";

    public void validate(IValidatable<String> validatable) {
        if( ! validatable.getValue().matches(REGEX_PATTERN)) {
            validatable.error(new ValidationError("Error: user name must contain only numbers and letters."));
        }

//        if(validatable.getValue().equals("1")) {
//            validatable.error(new ValidationError("qqq)"));
//        }
    }
}
