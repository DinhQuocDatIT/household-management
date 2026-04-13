package dinhquocdat.backend.dto.request;


import lombok.Data;

import java.time.LocalDate;

@Data
public class MemberRequest {
    private Integer householdId;

    private String fullName;
    private LocalDate dateOfBirth;

    private String gender; // "MALE", "FEMALE", ...

    private String cccd;
    private String hometown;
    private String address;
    private String relationship;
}