package hr.bbudano.ela.team.mapper;

import hr.bbudano.ela.team.dto.CreateTeamRequest;
import hr.bbudano.ela.team.dto.TeamView;
import hr.bbudano.ela.team.model.Team;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, unmappedTargetPolicy = ReportingPolicy.WARN)
public interface TeamMapper {

    TeamView toTeamView(Team team);

    @Mapping(target = "id", ignore = true)
    Team toTeam(CreateTeamRequest createTeamRequest);

}
