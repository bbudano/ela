package hr.bbudano.ela.leave.mapper;

import hr.bbudano.ela.leave.dto.CreateLeaveRequest;
import hr.bbudano.ela.leave.dto.LeaveView;
import hr.bbudano.ela.leave.model.Leave;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.WARN, uses = { LeaveTypeMapper.class })
public interface LeaveMapper {

    @Mapping(target = "leaveType", source = "leaveType", qualifiedByName = "toLeaveTypeView")
    LeaveView toLeaveView(Leave leave);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "leaveType", ignore = true)
    Leave toLeave(CreateLeaveRequest createLeaveRequest);

}
