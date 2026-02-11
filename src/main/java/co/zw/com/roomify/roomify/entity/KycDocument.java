package co.zw.com.roomify.roomify.entity;

import co.zw.com.roomify.roomify.enums.KycDocumentStatus;
import co.zw.com.roomify.roomify.enums.KycDocumentType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.UUID;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@Entity
@Table(name = "kyc_documents",
        indexes = {@Index(name = "idx_kyc_docs_kyc_profile_id", columnList = "kyc_profile_id")})
public class KycDocument {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "kyc_profile_id", nullable = false)
    private UUID kycProfileId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private KycDocumentType docType;

    @Column(nullable = false)
    private String fileUrl;

    @CreationTimestamp
    private Instant uploadedAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private KycDocumentStatus status = KycDocumentStatus.PENDING;
}
