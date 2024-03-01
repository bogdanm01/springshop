package com.bogdanm.springshop.shared.web;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@JsonPropertyOrder({"success", "messages", "content"})
public class ApiResponse<T> {
    private boolean success;
    private List<String> messages;
    private T content;

    public static class ApiResponseBuilder<T> {

        // called when calling ApiResponse.builder()
        public ApiResponseBuilder() {
            this.messages = new ArrayList<>();
        }

        public ApiResponseBuilder<T> addMessage(String message) {
            this.messages.add(message);
            return this;
        }

        public ApiResponseBuilder<T> badRequest(List<String> messages) {
            return this.success(false)
                    .messages(messages)
                    .content(null);
        }

        public ApiResponseBuilder<T> badRequest(String message) {
            return this.success(false)
                    .addMessage(message)
                    .content(null);
        }

        public ApiResponseBuilder<T> successfulOperation() {
            return this.success(true)
                    .addMessage("Operation completed successfully");
        }

        public ApiResponseBuilder<T> successfulOperation(T content) {
            return this.success(true)
                    .addMessage("Operation completed successfully")
                    .content(content);
        }
    }
}
