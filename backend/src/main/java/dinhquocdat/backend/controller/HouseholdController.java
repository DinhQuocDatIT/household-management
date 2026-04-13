package dinhquocdat.backend.controller;

import dinhquocdat.backend.dto.request.HouseholdRequest;
import dinhquocdat.backend.dto.response.HouseholdResponse;
import dinhquocdat.backend.service.HouseholdService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/households")
@RequiredArgsConstructor
public class HouseholdController {

    private final HouseholdService service;

    @PostMapping
    public HouseholdResponse create(@RequestBody HouseholdRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<HouseholdResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public HouseholdResponse getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public HouseholdResponse update(@PathVariable Integer id,
                                    @RequestBody HouseholdRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}