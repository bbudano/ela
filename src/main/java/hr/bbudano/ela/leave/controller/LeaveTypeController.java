package hr.bbudano.ela.leave.controller;

import hr.bbudano.ela.leave.dto.CreateLeaveTypeRequest;
import hr.bbudano.ela.leave.dto.LeaveTypeView;
import hr.bbudano.ela.leave.service.LeaveTypeService;
import hr.bbudano.ela.utils.HttpUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/leave-types")
@RequiredArgsConstructor
public class LeaveTypeController {

    private final LeaveTypeService leaveTypeService;
    private final HttpUtils httpUtils;

    @PostMapping
    public ResponseEntity<LeaveTypeView> createLeaveType(@Valid @RequestBody CreateLeaveTypeRequest createLeaveTypeRequest,
                                          HttpServletRequest httpServletRequest) {
        var leaveType = leaveTypeService.createLeaveType(createLeaveTypeRequest);

        return ResponseEntity
                .created(httpUtils.getLocationUri(httpServletRequest, leaveType.id()))
                .body(leaveType);
    }

    @GetMapping
    public List<LeaveTypeView> getLeaveTypes() {
        return leaveTypeService.getLeaveTypes();
    }

    @GetMapping("/{id}")
    public LeaveTypeView getLeaveType(@PathVariable Long id) {
        return leaveTypeService.getLeaveType(id);
    }

}
