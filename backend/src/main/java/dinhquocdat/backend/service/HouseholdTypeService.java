package dinhquocdat.backend.service;
import dinhquocdat.backend.dto.request.HouseholdTypeRequest;
import dinhquocdat.backend.dto.response.HouseholdTypeResponse;

import java.util.List;

public interface HouseholdTypeService {
    HouseholdTypeResponse create(HouseholdTypeRequest request);
    List<HouseholdTypeResponse> getAll();
    HouseholdTypeResponse getById(Integer id);
    HouseholdTypeResponse update(Integer id, HouseholdTypeRequest request);
    void delete(Integer id);
}