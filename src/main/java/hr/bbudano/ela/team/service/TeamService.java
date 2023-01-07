package hr.bbudano.ela.team.service;

import hr.bbudano.ela.team.dto.CreateTeamRequest;
import hr.bbudano.ela.team.dto.TeamView;
import hr.bbudano.ela.team.mapper.TeamMapper;
import hr.bbudano.ela.team.model.Team;
import hr.bbudano.ela.team.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    // REST

    public TeamView createTeam(CreateTeamRequest createTeamRequest) {
        var team = teamMapper.toTeam(createTeamRequest);
        teamRepository.saveAndFlush(team);
        return teamMapper.toTeamView(team);
    }

    @Transactional(readOnly = true)
    public Page<TeamView> getTeams(Pageable pageable) {
        return teamRepository
                .findAll(pageable)
                .map(teamMapper::toTeamView);
    }

    @Transactional(readOnly = true)
    public TeamView getTeam(Long id) {
        var team = getTeamById(id);
        return teamMapper.toTeamView(team);
    }

    public void deleteTeam(Long id) {
        var team = getTeamById(id);
        teamRepository.delete(team);
    }

    // General

    private Team getTeamById(Long id) {
        return teamRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Team not found by id: " + id));
    }

}
