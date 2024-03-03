package com.bogdanm.springshop.util.validation.rules;

import com.bogdanm.springshop.util.validation.ValidationResult;
import com.bogdanm.springshop.util.validation.ValidationRule;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ConstraintValidationRule<T> implements ValidationRule<T> {

    @Override
    public ValidationResult validate(T objectToValidate, ValidationResult validationResult) {
        try (ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory()) {
            final Validator validator = validatorFactory.getValidator();
            Set<ConstraintViolation<T>> constraintViolations = validator.validate(objectToValidate);

            if(!constraintViolations.isEmpty()) {
                constraintViolations.forEach(tConstraintViolation ->
                        validationResult.getMessages().add(
                                tConstraintViolation.getPropertyPath().toString() + ":  " +
                                tConstraintViolation.getMessage()));
            }
        }

        return validationResult;
    }
}
