package com.example.WetPlant.core.exception.Validierung;




import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AHVnRValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface AHVNrValidation {
    String message() default "{javax.validation.constraints.AHVNrValidation.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}



