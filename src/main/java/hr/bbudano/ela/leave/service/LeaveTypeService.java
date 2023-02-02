package hr.bbudano.ela.leave.service;

import hr.bbudano.ela.leave.dto.CreateLeaveTypeRequest;
import hr.bbudano.ela.leave.dto.LeaveTypeView;
import hr.bbudano.ela.leave.mapper.LeaveTypeMapper;
import hr.bbudano.ela.leave.repository.LeaveTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LeaveTypeService {

    private final LeaveTypeRepository leaveTypeRepository;
    private final LeaveTypeMapper leaveTypeMapper;

    // REST

    public LeaveTypeView createLeaveType(CreateLeaveTypeRequest createLeaveTypeRequest) {
        var leaveType = leaveTypeMapper.toLeave(createLeaveTypeRequest);

        leaveTypeRepository.saveAndFlush(leaveType);

        return leaveTypeMapper.toLeaveTypeView(leaveType);
    }

    @Transactional(readOnly = true)
    public List<LeaveTypeView> getLeaveTypes() {
        return leaveTypeRepository
                .findAll()
                .stream()
                .map(leaveTypeMapper::toLeaveTypeView)
                .toList();
    }

}
