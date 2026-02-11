package co.zw.com.roomify.roomify.repository;

import co.zw.com.roomify.roomify.entity.KycDocument;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface KycDocumentRepository extends JpaRepository<KycDocument, UUID> {
    List<KycDocument> findByKycProfileId(UUID kycProfileId);
}
