package dinhquocdat.backend.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MemberResponse {
    private Integer id;
    private Integer householdId;
    private String householdAddress;
    private String fullName;
    private LocalDate dateOfBirth;
    private String gender;
    private String cccd;
    private String hometown;
    private String address;
    private String relationship;
}