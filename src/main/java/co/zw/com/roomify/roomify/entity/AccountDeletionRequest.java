package co.zw.com.roomify.roomify.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.UUID;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@Entity
@Table(name = "account_deletion_requests",
        indexes = {@Index(name = "idx_del_req_user_id", columnList = "user_id", unique = true)})
public class AccountDeletionRequest {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "user_id", nullable = false, unique = true)
    private UUID userId;

    @Column(length = 500)
    private String reason;

    @CreationTimestamp
    private Instant requestedAt;

    @Column(nullable = false)
    private Instant deletionDate;

    @Column(nullable = false)
    @Builder.Default
    private boolean active = true;
}
