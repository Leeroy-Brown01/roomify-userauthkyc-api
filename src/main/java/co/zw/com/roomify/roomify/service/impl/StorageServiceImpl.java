package co.zw.com.roomify.roomify.service.impl;

import co.zw.com.roomify.roomify.service.StorageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
public class StorageServiceImpl implements StorageService {
    @Override
    public String uploadAvatar(UUID userId, MultipartFile file) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void deleteAvatar(UUID userId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public String uploadKycDocument(UUID userId, String docType, MultipartFile file) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void deleteKycDocument(String fileUrl) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}

