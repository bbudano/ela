package hr.bbudano.ela.leave.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CreateLeaveRequest(@NotNull(message = "Leave type id can not be null") Long leaveTypeId,
                                 @NotNull(message = "Start date can not be null") LocalDate startDate,
                                 @NotNull(message = "End date can not be null") LocalDate endDate,
                                 String comment) {
}
