package com.bogdanm.springshop.shared.validation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class ValidationResult {
    private List<String> messages;

    public ValidationResult() {
        messages = new ArrayList<>();
    }

    public boolean isNotValid() {
        return !isValid();
    }

    public boolean isValid() {
        return messages.isEmpty();
    }
}
