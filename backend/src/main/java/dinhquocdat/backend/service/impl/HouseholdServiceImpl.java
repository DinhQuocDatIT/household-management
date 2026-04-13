package dinhquocdat.backend.service.impl;


import dinhquocdat.backend.dto.request.HouseholdRequest;
import dinhquocdat.backend.dto.response.HouseholdResponse;
import dinhquocdat.backend.entity.Household;
import dinhquocdat.backend.entity.HouseholdType;
import dinhquocdat.backend.entity.Member;
import dinhquocdat.backend.mapper.HouseholdMapper;
import dinhquocdat.backend.repository.HouseholdRepository;
import dinhquocdat.backend.repository.HouseholdTypeRepository;
import dinhquocdat.backend.repository.MemberRepository;
import dinhquocdat.backend.service.HouseholdService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HouseholdServiceImpl implements HouseholdService {

    private final HouseholdRepository householdRepository;
    private final HouseholdTypeRepository householdTypeRepository;
    private final MemberRepository memberRepository;
    private final HouseholdMapper mapper;

    @Override
    public HouseholdResponse create(HouseholdRequest request) {

        Household household = mapper.toEntity(request);

        // set household type (bắt buộc)
        HouseholdType type = householdTypeRepository.findById(request.getHouseholdTypeId())
                .orElseThrow(() -> new RuntimeException("HouseholdType not found"));

        household.setHouseholdType(type);

        // set headMember (optional -> cho phép null)
        if (request.getHeadMemberId() != null) {
            Member head = memberRepository.findById(request.getHeadMemberId())
                    .orElseThrow(() -> new RuntimeException("Member not found"));

            household.setHeadMember(head);
        } else {
            household.setHeadMember(null);
        }

        return mapper.toResponse(householdRepository.save(household));
    }

    @Override
    public List<HouseholdResponse> getAll() {
        return householdRepository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public HouseholdResponse getById(Integer id) {
        Household household = householdRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Household not found"));
        return mapper.toResponse(household);
    }

    @Override
    public HouseholdResponse update(Integer id, HouseholdRequest request) {

        Household household = householdRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Household not found"));

        household.setAddress(request.getAddress());
        household.setActive(request.getActive());

        if (request.getHouseholdTypeId() != null) {
            HouseholdType type = householdTypeRepository.findById(request.getHouseholdTypeId())
                    .orElseThrow(() -> new RuntimeException("HouseholdType not found"));
            household.setHouseholdType(type);
        }

        if (request.getHeadMemberId() != null) {
            Member head = memberRepository.findById(request.getHeadMemberId())
                    .orElseThrow(() -> new RuntimeException("Member not found"));
            household.setHeadMember(head);
        }

        return mapper.toResponse(householdRepository.save(household));
    }

    @Override
    public void delete(Integer id) {
        householdRepository.deleteById(id);
    }
}