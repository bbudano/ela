package hr.bbudano.ela.leave.service;

import hr.bbudano.ela.leave.dto.CreateLeaveRequest;
import hr.bbudano.ela.leave.dto.LeaveView;
import hr.bbudano.ela.leave.mapper.LeaveMapper;
import hr.bbudano.ela.leave.repository.LeaveRepository;
import hr.bbudano.ela.leave.repository.LeaveTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LeaveService {

    private final LeaveRepository leaveRepository;
    private final LeaveTypeRepository leaveTypeRepository;
    private final LeaveMapper leaveMapper;

    public LeaveView createLeave(CreateLeaveRequest createLeaveRequest) {
        var leave = leaveMapper.toLeave(createLeaveRequest);

        var leaveType = leaveTypeRepository.findById(createLeaveRequest.leaveTypeId())
                .orElseThrow(() -> new RuntimeException("Leave type not found by id: " + createLeaveRequest.leaveTypeId()));
        leave.setLeaveType(leaveType);

        leaveRepository.saveAndFlush(leave);

        return leaveMapper.toLeaveView(leave);
    }

}
