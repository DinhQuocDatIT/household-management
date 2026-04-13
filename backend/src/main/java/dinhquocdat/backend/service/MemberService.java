package dinhquocdat.backend.service;

import dinhquocdat.backend.dto.request.MemberRequest;
import dinhquocdat.backend.dto.response.MemberResponse;

import java.util.List;

public interface MemberService {

    MemberResponse create(MemberRequest request);

    List<MemberResponse> getAll();

    MemberResponse getById(Integer id);

    MemberResponse update(Integer id, MemberRequest request);

    void delete(Integer id);
}