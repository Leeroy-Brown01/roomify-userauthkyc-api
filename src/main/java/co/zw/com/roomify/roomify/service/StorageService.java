package co.zw.com.roomify.roomify.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface StorageService {
    String uploadAvatar(UUID userId, MultipartFile file);
    void deleteAvatar(UUID userId);

    String uploadKycDocument(UUID userId, String docType, MultipartFile file);
    void deleteKycDocument(String fileUrl);
}
