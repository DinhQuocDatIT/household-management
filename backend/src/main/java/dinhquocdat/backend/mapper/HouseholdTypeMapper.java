package dinhquocdat.backend.mapper;

import dinhquocdat.backend.dto.request.HouseholdTypeRequest;
import dinhquocdat.backend.dto.response.HouseholdTypeResponse;
import dinhquocdat.backend.entity.HouseholdType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HouseholdTypeMapper {

    @Mapping(target = "id", ignore = true)
    HouseholdType toEntity(HouseholdTypeRequest request);

    HouseholdTypeResponse toResponse(HouseholdType entity);
}