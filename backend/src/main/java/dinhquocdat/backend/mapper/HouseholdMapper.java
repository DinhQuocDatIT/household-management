package dinhquocdat.backend.mapper;

import dinhquocdat.backend.dto.request.HouseholdRequest;
import dinhquocdat.backend.dto.response.HouseholdResponse;
import dinhquocdat.backend.entity.Household;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface HouseholdMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "householdType", ignore = true)
    @Mapping(target = "headMember", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Household toEntity(HouseholdRequest request);

    @Mapping(source = "householdType.id", target = "householdTypeId")
    @Mapping(source = "householdType.name", target = "householdTypeName")
    @Mapping(source = "headMember.id", target = "headMemberId")
    HouseholdResponse toResponse(Household entity);
}