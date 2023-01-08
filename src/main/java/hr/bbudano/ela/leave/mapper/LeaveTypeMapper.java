package hr.bbudano.ela.leave.mapper;

import hr.bbudano.ela.leave.dto.LeaveTypeView;
import hr.bbudano.ela.leave.model.LeaveType;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, unmappedTargetPolicy = ReportingPolicy.WARN)
public interface LeaveTypeMapper {

    LeaveTypeView toLeaveTypeView(LeaveType leaveType);

}
