package co.zw.com.roomify.roomify.security;

import co.zw.com.roomify.roomify.enums.UserType;
import co.zw.com.roomify.roomify.exception.UnauthorizedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.UUID;

public final class SecurityUtils {

    private SecurityUtils() {}

    public static Authentication auth() {
        Authentication a = SecurityContextHolder.getContext().getAuthentication();
        if (a == null || !a.isAuthenticated()) {
            throw new UnauthorizedException("UNAUTHORIZED", "Missing or invalid access token");
        }
        return a;
    }

    /**
     * Expect principal name to be userId OR a custom principal.
     * If your JWT stores userId in claims, adapt here.
     */
    public static UUID currentUserId() {
        Authentication a = auth();
        Object principal = a.getPrincipal();

        if (principal instanceof CurrentUserDetails cud && cud.getUserId() != null) {
            return cud.getUserId();
        }

        // fallback: principal string is UUID
        try {
            return UUID.fromString(String.valueOf(principal));
        } catch (Exception e) {
            // last fallback: authentication name is UUID
            try {
                return UUID.fromString(a.getName());
            } catch (Exception ex) {
                throw new UnauthorizedException("UNAUTHORIZED", "User id not found in token");
            }
        }
    }

    public static UserType currentUserType() {
        Authentication a = auth();
        Object principal = a.getPrincipal();
        if (principal instanceof CurrentUserDetails cud && cud.getUserType() != null) {
            return cud.getUserType();
        }
        // If you don't have it available yet, you can store userType in UserProfile and read it there.
        throw new UnauthorizedException("UNAUTHORIZED", "User type not found in token");
    }
}
