package hr.bbudano.ela.team.controller;

import hr.bbudano.ela.team.dto.TeamView;
import hr.bbudano.ela.team.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/teams")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @GetMapping
    public Page<TeamView> getTeams(Pageable pageable) {
        return teamService.getTeams(pageable);
    }

}
