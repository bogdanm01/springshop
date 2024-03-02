package com.bogdanm.springshop.util.validation;

@FunctionalInterface
public interface ValidationRule<T> {
    ValidationResult validate(T objectToValidate, ValidationResult validationResult);

    default void applyValidationRule(T toValidate, ValidationResult validationResult, boolean skipOnExistingErrors) {
        if (skipOnExistingErrors && validationResult.isNotValid()) {
            return;
        }

        validate(toValidate, validationResult);
    }
}
