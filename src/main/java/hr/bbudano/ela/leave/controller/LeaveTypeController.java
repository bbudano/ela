package hr.bbudano.ela.leave.controller;

import hr.bbudano.ela.leave.dto.CreateLeaveTypeRequest;
import hr.bbudano.ela.leave.dto.LeaveTypeView;
import hr.bbudano.ela.leave.service.LeaveTypeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/leave-types")
@RequiredArgsConstructor
public class LeaveTypeController {

    private final LeaveTypeService leaveTypeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LeaveTypeView createLeaveType(@Valid @RequestBody CreateLeaveTypeRequest createLeaveTypeRequest) {
        return leaveTypeService.createLeaveType(createLeaveTypeRequest);
    }

    @GetMapping
    public List<LeaveTypeView> getLeaveTypes() {
        return leaveTypeService.getLeaveTypes();
    }

}
