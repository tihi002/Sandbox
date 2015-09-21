import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;
import org.apache.wicket.validation.ValidationError;

/**
 * Created by trozman on 2015. 09. 21..
 */
public class StringValidator implements IValidator<String> {
    public void validate(IValidatable<String> validatable) {
        if(validatable.getValue().length() <= 2) {
            validatable.error(new ValidationError("Error: length must be longer than 2"));
        }


    }
}
