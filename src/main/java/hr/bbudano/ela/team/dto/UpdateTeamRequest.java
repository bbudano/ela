package hr.bbudano.ela.team.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record UpdateTeamRequest(@NotNull(message = "Name can not be null") String name,
                                @NotNull(message = "Base allowance can not be null")
                                @Min(value = 0, message = "Base allowance can not be a negative number") Integer baseAllowance) {
}
