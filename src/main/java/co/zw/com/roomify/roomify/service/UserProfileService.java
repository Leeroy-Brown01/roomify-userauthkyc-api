package co.zw.com.roomify.roomify.service;

import org.springframework.web.multipart.MultipartFile;

public interface UserProfileService {
    Object getMyProfile();
    Object updateMyProfile(Object request);

    Object uploadAvatar(MultipartFile file);
    void deleteAvatar();
}
