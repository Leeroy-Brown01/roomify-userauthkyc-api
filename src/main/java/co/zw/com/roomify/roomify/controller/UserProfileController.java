package co.zw.com.roomify.roomify.controller;

import co.zw.com.roomify.roomify.dto.common.ApiResponse;
import co.zw.com.roomify.roomify.service.UserProfileService;
import co.zw.com.roomify.roomify.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserProfileController {

    private final UserProfileService userProfileService;
    private final StorageService storageService;

    @GetMapping("/profile")
    public ApiResponse<?> getProfile() {
        return ApiResponse.ok(userProfileService.getMyProfile());
    }

    @PutMapping("/profile")
    public ApiResponse<?> updateProfile(@RequestBody Object request) {
        // We’ll replace Object with correct request DTOs (tenant/landlord) next.
        return ApiResponse.ok(userProfileService.updateMyProfile(request), "Profile updated successfully");
    }

    @PostMapping(value = "/avatar", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ApiResponse<?> uploadAvatar(@RequestPart("file") MultipartFile file) {
        return ApiResponse.ok(userProfileService.uploadAvatar(file));
    }

    @DeleteMapping("/avatar")
    public ApiResponse<?> deleteAvatar() {
        userProfileService.deleteAvatar();
        return ApiResponse.ok(java.util.Map.of("message", "Profile photo removed successfully"));
    }
}
