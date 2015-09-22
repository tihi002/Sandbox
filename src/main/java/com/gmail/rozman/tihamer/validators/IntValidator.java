package com.gmail.rozman.tihamer.validators;

import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;
import org.apache.wicket.validation.ValidationError;

/**
 * Created by trozman on 2015. 09. 18..
 */
public class IntValidator implements IValidator<String> {

    public void validate(IValidatable<String> validatable) {
        String value = validatable.getValue();

        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
//            error(validatable, "error");
            validatable.error(new ValidationError("Error: not an integer"));
        }


    }


}
