package dinhquocdat.backend.service.impl;

import dinhquocdat.backend.dto.request.MemberRequest;
import dinhquocdat.backend.dto.response.MemberResponse;
import dinhquocdat.backend.entity.Gender;
import dinhquocdat.backend.entity.Household;
import dinhquocdat.backend.entity.Member;
import dinhquocdat.backend.mapper.MemberMapper;
import dinhquocdat.backend.repository.HouseholdRepository;
import dinhquocdat.backend.repository.MemberRepository;
import dinhquocdat.backend.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final HouseholdRepository householdRepository;
    private final MemberMapper memberMapper;

    @Override
    public MemberResponse create(MemberRequest request) {

        Member member = memberMapper.toEntity(request);

        Household household = householdRepository.findById(request.getHouseholdId())
                .orElseThrow(() -> new RuntimeException("Household not found"));

        member.setHousehold(household);

        if (request.getGender() != null) {
            member.setGender(Gender.valueOf(request.getGender()));
        }

        return memberMapper.toResponse(memberRepository.save(member));
    }

    @Override
    public List<MemberResponse> getAll() {
        return memberRepository.findAll()
                .stream()
                .map(memberMapper::toResponse)
                .toList();
    }

    @Override
    public MemberResponse getById(Integer id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found"));

        return memberMapper.toResponse(member);
    }

    @Override
    public MemberResponse update(Integer id, MemberRequest request) {

        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found"));

        member.setFullName(request.getFullName());
        member.setDateOfBirth(request.getDateOfBirth());
        member.setCccd(request.getCccd());
        member.setHometown(request.getHometown());
        member.setAddress(request.getAddress());
        member.setRelationship(request.getRelationship());

        if (request.getGender() != null) {
            member.setGender(Gender.valueOf(request.getGender()));
        }

        if (request.getHouseholdId() != null) {
            Household household = householdRepository.findById(request.getHouseholdId())
                    .orElseThrow(() -> new RuntimeException("Household not found"));
            member.setHousehold(household);
        }

        return memberMapper.toResponse(memberRepository.save(member));
    }

    @Override
    public void delete(Integer id) {
        memberRepository.deleteById(id);
    }
}