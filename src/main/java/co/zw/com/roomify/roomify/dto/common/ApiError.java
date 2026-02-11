package co.zw.com.roomify.roomify.dto.common;

import lombok.*;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class ApiError {
    private String code;
    private String message;
}
