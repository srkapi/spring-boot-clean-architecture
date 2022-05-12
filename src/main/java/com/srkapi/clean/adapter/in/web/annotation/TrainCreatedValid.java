package com.srkapi.clean.adapter.in.web.annotation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TrainValidator.class)
@Target( { ElementType.TYPE, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface TrainCreatedValid {
    String message() default "Invalid train";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
