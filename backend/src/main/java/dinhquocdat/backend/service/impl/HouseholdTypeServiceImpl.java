package dinhquocdat.backend.service.impl;

import dinhquocdat.backend.dto.request.HouseholdTypeRequest;
import dinhquocdat.backend.dto.response.HouseholdTypeResponse;
import dinhquocdat.backend.entity.HouseholdType;
import dinhquocdat.backend.mapper.HouseholdTypeMapper;
import dinhquocdat.backend.repository.HouseholdTypeRepository;
import dinhquocdat.backend.service.HouseholdTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HouseholdTypeServiceImpl implements HouseholdTypeService {

    private final HouseholdTypeRepository repository;
    private final HouseholdTypeMapper mapper;

    @Override
    public HouseholdTypeResponse create(HouseholdTypeRequest request) {
        HouseholdType entity = mapper.toEntity(request);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public List<HouseholdTypeResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public HouseholdTypeResponse getById(Integer id) {
        HouseholdType type = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("HouseholdType not found"));
        return mapper.toResponse(type);
    }

    @Override
    public HouseholdTypeResponse update(Integer id, HouseholdTypeRequest request) {
        HouseholdType type = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("HouseholdType not found"));

        type.setName(request.getName());

        return mapper.toResponse(repository.save(type));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
