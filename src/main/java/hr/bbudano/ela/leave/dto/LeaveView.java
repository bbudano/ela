package hr.bbudano.ela.leave.dto;

import java.time.LocalDate;

public record LeaveView(Long id, LeaveTypeView leaveType, LocalDate startDate, LocalDate endDate, String comment) {
}
