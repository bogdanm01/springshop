package com.bogdanm.springshop.data.web;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

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

    @JsonIgnore
    private HttpStatus httpStatus;

    public static final String SUCCESS_MESSAGE = "Operation completed successfully";

    public static class ApiResponseBuilder<T> {

        public ApiResponseBuilder() {
            this.messages = new ArrayList<>();
        }

        public ApiResponseBuilder<T> addMessage(String message) {
            this.messages.add(message);
            return this;
        }

        /**
         * Api response with BAD_REQUEST http status, a message list and empty content.
         * @param messages list of messages
         * @return ApiResponseBuilder<T> instance
         */
        public ApiResponseBuilder<T> badRequest(List<String> messages) {
            return this.success(false)
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .messages(messages)
                    .content(null);
        }

        /**
         * Api response featuring default success message, without content.
         * @return ApiResponseBuilder<T> instance
         */
        public ApiResponseBuilder<T> successfulOperation() {
            return this.success(true)
                    .addMessage(SUCCESS_MESSAGE);
        }

        /**
         * Api response featuring default success message, with content.
         * @param content Api response content
         * @return ApiResponseBuilder<T> instance
         */
        public ApiResponseBuilder<T> successfulOperation(T content) {
            return this.success(true)
                    .addMessage(SUCCESS_MESSAGE)
                    .content(content);
        }
    }
}
