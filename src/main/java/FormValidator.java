import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;

/**
 * Created by trozman on 2015. 09. 18..
 */
public class FormValidator implements IValidator {

    public void validate(IValidatable validatable) {
        validatable.getValue();

//        validatable.er
    }
}
