package co.zw.com.roomify.roomify.service.impl;

import co.zw.com.roomify.roomify.enums.KycDocumentType;
import co.zw.com.roomify.roomify.service.KycService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
public class KycServiceImpl implements KycService {
    @Override
    public Object getStatus() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public Object start(Object request) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public Object requiredDocuments() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public Object uploadDocument(KycDocumentType docType, MultipartFile file) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void deleteDocument(UUID docId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public Object submit() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}

