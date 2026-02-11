package co.zw.com.roomify.roomify.entity;

import co.zw.com.roomify.roomify.enums.*;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@Entity
@Table(name = "user_profiles",
        indexes = {@Index(name = "idx_user_profiles_user_id", columnList = "user_id", unique = true)})
public class UserProfile {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "user_id", nullable = false, unique = true)
    private UUID userId;

    @Enumerated(EnumType.STRING)
    @Column(name = "profile_type", nullable = false)
    private ProfileType profileType; // TENANT / LANDLORD

    @Enumerated(EnumType.STRING)
    @Column(name = "user_type", nullable = false)
    private UserType userType; // GENERAL_TENANT / STUDENT_TENANT etc.

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String email;

    // Tenant fields
    private String university;
    private String studentId;

    private Integer budgetMin;
    private Integer budgetMax;

    @ElementCollection
    @CollectionTable(name = "user_profile_locations", joinColumns = @JoinColumn(name = "profile_id"))
    @Column(name = "location")
    @Builder.Default
    private List<String> preferredLocations = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private OccupancyPreference occupancyPreference;

    // Landlord fields
    private String organizationName;

    @Column(name = "physical_address")
    private String physicalAddress;

    private String businessRegistrationNumber;

    // common
    private String profilePhotoUrl;

    @Column(length = 500)
    private String bio;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private KycStatus kycStatus = KycStatus.NOT_STARTED;

    @Column(nullable = false)
    @Builder.Default
    private boolean isVerified = false;

    // read-only counters (can be updated by other services later)
    @Builder.Default
    private Integer totalListings = 0;

    @Builder.Default
    private Integer activeListings = 0;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;
}
