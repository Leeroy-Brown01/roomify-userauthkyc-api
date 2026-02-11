package co.zw.com.roomify.roomify.controller;

import co.zw.com.roomify.roomify.dto.common.ApiResponse;
import co.zw.com.roomify.roomify.enums.KycDocumentType;
import co.zw.com.roomify.roomify.service.KycService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users/kyc")
public class UserKycController {

    private final KycService kycService;

    @GetMapping("/status")
    public ApiResponse<?> status() {
        return ApiResponse.ok(kycService.getStatus());
    }

    @PostMapping("/start")
    public ApiResponse<?> start(@RequestBody Object request) {
        // replace Object with StartKycRequest next
        return ApiResponse.ok(kycService.start(request));
    }

    @GetMapping("/required-documents")
    public ApiResponse<?> requiredDocs() {
        return ApiResponse.ok(kycService.requiredDocuments());
    }

    @PostMapping(value = "/documents", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ApiResponse<?> uploadDocument(@RequestPart("file") MultipartFile file,
                                         @RequestPart("docType") KycDocumentType docType) {
        return ApiResponse.ok(kycService.uploadDocument(docType, file));
    }

    @DeleteMapping("/documents/{id}")
    public ApiResponse<?> deleteDocument(@PathVariable("id") UUID docId) {
        kycService.deleteDocument(docId);
        return ApiResponse.ok(java.util.Map.of("message", "Document removed successfully"));
    }

    @PostMapping("/submit")
    public ApiResponse<?> submit() {
        return ApiResponse.ok(kycService.submit());
    }
}
