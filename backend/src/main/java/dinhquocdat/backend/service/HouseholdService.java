package dinhquocdat.backend.service;

import dinhquocdat.backend.dto.request.HouseholdRequest;
import dinhquocdat.backend.dto.response.HouseholdResponse;

import java.util.List;

public interface HouseholdService {
    HouseholdResponse create(HouseholdRequest request);
    List<HouseholdResponse> getAll();
    HouseholdResponse getById(Integer id);
    HouseholdResponse update(Integer id, HouseholdRequest request);
    void delete(Integer id);
}