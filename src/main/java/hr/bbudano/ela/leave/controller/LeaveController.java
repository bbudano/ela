package hr.bbudano.ela.leave.controller;

import hr.bbudano.ela.leave.dto.CreateLeaveRequest;
import hr.bbudano.ela.leave.dto.LeaveView;
import hr.bbudano.ela.leave.service.LeaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/leaves")
@RequiredArgsConstructor
public class LeaveController {

    private final LeaveService leaveService;

    @PostMapping
    public LeaveView createLeave(@RequestBody CreateLeaveRequest createLeaveRequest) {
        return leaveService.createLeave(createLeaveRequest);
    }

}
