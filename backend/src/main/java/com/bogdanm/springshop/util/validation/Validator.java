package com.bogdanm.springshop.util.validation;

import java.util.LinkedHashMap;
import java.util.Map;

public class Validator<T> {

    // validationRule, skipOnExistingErrors
    private final Map<ValidationRule<T>, Boolean> validationRules;

    public Validator(Map<ValidationRule<T>, Boolean> validationRules) {
        this.validationRules = validationRules;
    }

    public ValidationResult validate(T objectToValidate) {
        var validationResult = new ValidationResult();

        for (var rule : validationRules.entrySet()) {
            rule.getKey().applyValidationRule(objectToValidate, validationResult, rule.getValue());
        }

        return validationResult;
    }

    public ValidationResult validateRule(T objectToValidate, ValidationRule<T> validationRule) {
        return validationRule.validate(objectToValidate, new ValidationResult());
    }

    public static <T> ValidatorBuilder<T> builder() {
        return new ValidatorBuilder<T>();
    }

    public static class ValidatorBuilder<T> {

        private final Map<ValidationRule<T>, Boolean> validationRules;

        private ValidatorBuilder() {
            validationRules = new LinkedHashMap<>();
        }

        public ValidatorBuilder<T> addRule(ValidationRule<T> validationRule, Boolean skipOnExistingErrors) {
            validationRules.put(validationRule, skipOnExistingErrors);
            return this;
        }

        public ValidatorBuilder<T> addRule(ValidationRule<T> validationRule) {
            validationRules.put(validationRule, false);
            return this;
        }

        public Validator<T> build() {
            return new Validator<>(this.validationRules);
        }
    }
}
