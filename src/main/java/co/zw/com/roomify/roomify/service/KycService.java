package co.zw.com.roomify.roomify.service;

import co.zw.com.roomify.roomify.enums.KycDocumentType;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface KycService {
    Object getStatus();
    Object start(Object request);

    Object requiredDocuments();
    Object uploadDocument(KycDocumentType docType, MultipartFile file);
    void deleteDocument(UUID docId);

    Object submit();
}
