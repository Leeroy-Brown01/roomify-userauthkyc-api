package co.zw.com.roomify.roomify.service.impl;

import co.zw.com.roomify.roomify.service.UserProfileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserProfileServiceImpl implements UserProfileService {
    @Override
    public Object getMyProfile() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public Object updateMyProfile(Object request) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public Object uploadAvatar(MultipartFile file) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void deleteAvatar() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}

