package hr.bbudano.ela.leave.dto;

import java.time.LocalDate;

public record CreateLeaveRequest(Long leaveTypeId, LocalDate startDate, LocalDate endDate, String comment) {
}
