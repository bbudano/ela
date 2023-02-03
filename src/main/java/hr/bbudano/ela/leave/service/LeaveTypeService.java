package hr.bbudano.ela.leave.service;

import hr.bbudano.ela.exception.ElaException;
import hr.bbudano.ela.leave.dto.CreateLeaveTypeRequest;
import hr.bbudano.ela.leave.dto.LeaveTypeView;
import hr.bbudano.ela.leave.mapper.LeaveTypeMapper;
import hr.bbudano.ela.leave.model.LeaveType;
import hr.bbudano.ela.leave.repository.LeaveTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

    @Transactional(readOnly = true)
    public LeaveTypeView getLeaveType(Long id) {
        var leaveType = getLeaveTypeById(id);

        return leaveTypeMapper.toLeaveTypeView(leaveType);
    }

    // General

    private LeaveType getLeaveTypeById(Long id) {
        return leaveTypeRepository
                .findById(id)
                .orElseThrow(() ->
                        new ElaException("Leave Type not found by id: " + id, HttpStatus.NOT_FOUND)
                );
    }

}
