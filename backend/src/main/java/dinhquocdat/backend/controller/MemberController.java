package dinhquocdat.backend.controller;

import dinhquocdat.backend.dto.request.MemberRequest;
import dinhquocdat.backend.dto.response.MemberResponse;
import dinhquocdat.backend.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public MemberResponse create(@RequestBody MemberRequest request) {
        return memberService.create(request);
    }

    @GetMapping
    public List<MemberResponse> getAll() {
        return memberService.getAll();
    }

    @GetMapping("/{id}")
    public MemberResponse getById(@PathVariable Integer id) {
        return memberService.getById(id);
    }

    @PutMapping("/{id}")
    public MemberResponse update(@PathVariable Integer id,
                                 @RequestBody MemberRequest request) {
        return memberService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        memberService.delete(id);
    }
}