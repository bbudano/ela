package hr.bbudano.ela.leave.mapper;

import hr.bbudano.ela.leave.dto.CreateLeaveTypeRequest;
import hr.bbudano.ela.leave.dto.LeaveTypeView;
import hr.bbudano.ela.leave.model.LeaveType;
import org.mapstruct.*;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, unmappedTargetPolicy = ReportingPolicy.WARN)
public interface LeaveTypeMapper {

    @Named("toLeaveTypeView")
    LeaveTypeView toLeaveTypeView(LeaveType leaveType);

    @Mapping(target = "id", ignore = true)
    LeaveType toLeave(CreateLeaveTypeRequest createLeaveTypeRequest);

}
