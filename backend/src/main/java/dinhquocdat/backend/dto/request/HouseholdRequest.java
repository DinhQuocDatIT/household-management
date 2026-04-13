package dinhquocdat.backend.dto.request;

import lombok.Data;

@Data
public class HouseholdRequest {
    private String address;
    private Integer householdTypeId;
    private Integer headMemberId;
    private Boolean active;
}