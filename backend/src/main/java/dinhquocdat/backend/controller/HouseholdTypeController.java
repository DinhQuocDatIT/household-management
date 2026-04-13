package dinhquocdat.backend.controller;


import dinhquocdat.backend.dto.request.HouseholdTypeRequest;
import dinhquocdat.backend.dto.response.HouseholdTypeResponse;
import dinhquocdat.backend.service.HouseholdTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/household-types")
@RequiredArgsConstructor
public class HouseholdTypeController {

    private final HouseholdTypeService service;

    @PostMapping
    public HouseholdTypeResponse create(@RequestBody HouseholdTypeRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<HouseholdTypeResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public HouseholdTypeResponse getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public HouseholdTypeResponse update(@PathVariable Integer id,
                                        @RequestBody HouseholdTypeRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}