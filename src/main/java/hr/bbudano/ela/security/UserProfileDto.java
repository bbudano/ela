package hr.bbudano.ela.security;

import hr.bbudano.ela.employee.model.Role;

public record UserProfileDto(String email, String firstName, String lastName, Role role, String team) {
}
