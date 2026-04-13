package dinhquocdat.backend.dto.response;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HouseholdResponse {
    private Integer id;
    private String address;
    private Integer householdTypeId;
    private String householdTypeName;
    private Integer headMemberId;
    private Boolean active;
    private LocalDateTime createdAt;
}