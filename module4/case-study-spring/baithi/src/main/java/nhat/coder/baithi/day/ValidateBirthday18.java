package nhat.coder.baithi.day;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = Birthday18ConstraintValidation.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateBirthday18 {
    String message() default "You must greater than 18 to book service!!!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
