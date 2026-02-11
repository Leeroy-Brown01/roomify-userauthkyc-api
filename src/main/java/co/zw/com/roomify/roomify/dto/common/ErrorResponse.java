package co.zw.com.roomify.roomify.dto.common;

import lombok.*;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class ErrorResponse {
    private boolean success;
    private ApiError error;

    public static ErrorResponse of(String code, String message) {
        return ErrorResponse.builder()
                .success(false)
                .error(ApiError.builder().code(code).message(message).build())
                .build();
    }
}
