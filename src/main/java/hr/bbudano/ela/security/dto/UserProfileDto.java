package hr.bbudano.ela.security.dto;

import hr.bbudano.ela.security.Role;

public record UserProfileDto(String email, String firstName, String lastName, Role role, String team) {
}
