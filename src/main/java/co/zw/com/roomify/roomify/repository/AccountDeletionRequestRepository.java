package co.zw.com.roomify.roomify.repository;

import co.zw.com.roomify.roomify.entity.AccountDeletionRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AccountDeletionRequestRepository extends JpaRepository<AccountDeletionRequest, UUID> {
    Optional<AccountDeletionRequest> findByUserId(UUID userId);
}
