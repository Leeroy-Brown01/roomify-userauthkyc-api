package co.zw.com.roomify.roomify.entity;

import co.zw.com.roomify.roomify.enums.*;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@Entity
@Table(name = "kyc_profiles",
        indexes = {@Index(name = "idx_kyc_profiles_user_id", columnList = "user_id", unique = true)})
public class KycProfile {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "user_id", nullable = false, unique = true)
    private UUID userId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProfileType roleType; // TENANT / LANDLORD

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private KycStatus status;

    @Enumerated(EnumType.STRING)
    private IdentityDocType identityDocType;

    private Instant submittedAt;
    private Instant reviewedAt;

    private UUID reviewerAdminId;

    @Column(length = 500)
    private String rejectionReason;

    private Instant expiresAt;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;
}
