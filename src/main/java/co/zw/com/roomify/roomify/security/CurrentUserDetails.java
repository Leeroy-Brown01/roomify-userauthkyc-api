package co.zw.com.roomify.roomify.security;

import co.zw.com.roomify.roomify.enums.UserType;
import lombok.*;

import java.util.UUID;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class CurrentUserDetails {
    private UUID userId;
    private UserType userType;
}
