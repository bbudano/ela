package hr.bbudano.ela.team.service;

import hr.bbudano.ela.team.dto.TeamView;
import hr.bbudano.ela.team.mapper.TeamMapper;
import hr.bbudano.ela.team.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    @GetMapping
    public Page<TeamView> getTeams(Pageable pageable) {
        return teamRepository
                .findAll(pageable)
                .map(teamMapper::toGroupView);
    }

}
