package hr.bbudano.ela.leave.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateLeaveTypeRequest(@NotBlank(message = "Name can not be blank") String name,
                                     @NotNull(message = "Deducts allowance can not be null") Boolean deductsAllowance) {
}
