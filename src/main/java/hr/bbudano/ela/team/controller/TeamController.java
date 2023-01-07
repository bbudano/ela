package hr.bbudano.ela.team.controller;

import hr.bbudano.ela.team.dto.CreateTeamRequest;
import hr.bbudano.ela.team.dto.TeamView;
import hr.bbudano.ela.team.dto.UpdateTeamRequest;
import hr.bbudano.ela.team.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/teams")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @PostMapping
    public TeamView createTeam(@RequestBody CreateTeamRequest createTeamRequest) {
        return teamService.createTeam(createTeamRequest);
    }

    @GetMapping
    public Page<TeamView> getTeams(Pageable pageable) {
        return teamService.getTeams(pageable);
    }

    @GetMapping("/{id}")
    public TeamView getTeam(@PathVariable Long id) {
        return teamService.getTeam(id);
    }

    @PutMapping("/{id}")
    public TeamView updateTeam(@PathVariable Long id,
                               @RequestBody UpdateTeamRequest updateTeamRequest) {
        return teamService.updateTeam(id, updateTeamRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable Long id) {
        teamService.deleteTeam(id);
    }

}
