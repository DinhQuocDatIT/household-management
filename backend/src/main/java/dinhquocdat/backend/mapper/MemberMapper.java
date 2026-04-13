package dinhquocdat.backend.mapper;


import dinhquocdat.backend.dto.request.MemberRequest;
import dinhquocdat.backend.dto.response.MemberResponse;
import dinhquocdat.backend.entity.Member;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "household", ignore = true)
    Member toEntity(MemberRequest request);

    @Mapping(source = "household.id", target = "householdId")
    @Mapping(source = "household.address", target = "householdAddress")
    @Mapping(source = "gender", target = "gender")
    MemberResponse toResponse(Member member);
}