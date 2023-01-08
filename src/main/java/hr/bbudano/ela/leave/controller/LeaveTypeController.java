package hr.bbudano.ela.leave.controller;

import hr.bbudano.ela.leave.dto.LeaveTypeView;
import hr.bbudano.ela.leave.service.LeaveTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/leave-types")
@RequiredArgsConstructor
public class LeaveTypeController {

    private final LeaveTypeService leaveTypeService;

    @GetMapping
    public List<LeaveTypeView> getLeaveTypes() {
        return leaveTypeService.getLeaveTypes();
    }

}
