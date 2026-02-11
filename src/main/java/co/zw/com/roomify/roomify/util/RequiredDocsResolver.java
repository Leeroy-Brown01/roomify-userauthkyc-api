package co.zw.com.roomify.roomify.util;

import co.zw.com.roomify.roomify.enums.KycDocumentType;
import co.zw.com.roomify.roomify.enums.UserType;

import java.util.EnumSet;
import java.util.Set;

public final class RequiredDocsResolver {

    private RequiredDocsResolver() {}

    public static Set<KycDocumentType> required(UserType userType) {
        return switch (userType) {
            case GENERAL_TENANT ->
                    EnumSet.of(KycDocumentType.ID_FRONT, KycDocumentType.ID_BACK, KycDocumentType.SELFIE);
            case STUDENT_TENANT ->
                    EnumSet.of(KycDocumentType.STUDENT_ID, KycDocumentType.SELFIE);
            case GENERAL_LANDLORD ->
                    EnumSet.of(KycDocumentType.ID_FRONT, KycDocumentType.ID_BACK, KycDocumentType.PROOF_OF_OWNERSHIP, KycDocumentType.SELFIE);
            case BOARDING_HOUSE_OWNER ->
                    EnumSet.of(KycDocumentType.ID_FRONT, KycDocumentType.ID_BACK, KycDocumentType.PROOF_OF_OWNERSHIP, KycDocumentType.SELFIE);
        };
    }

    public static Set<KycDocumentType> optional(UserType userType) {
        return switch (userType) {
            case GENERAL_TENANT -> EnumSet.of(KycDocumentType.UTILITY_BILL);
            case STUDENT_TENANT -> EnumSet.of(KycDocumentType.PROOF_OF_ENROLLMENT);
            case GENERAL_LANDLORD -> EnumSet.of(KycDocumentType.UTILITY_BILL, KycDocumentType.RATES_BILL, KycDocumentType.AUTHORIZATION_LETTER);
            case BOARDING_HOUSE_OWNER -> EnumSet.of(KycDocumentType.BUSINESS_REGISTRATION, KycDocumentType.UTILITY_BILL, KycDocumentType.RATES_BILL, KycDocumentType.AUTHORIZATION_LETTER);
        };
    }
}
