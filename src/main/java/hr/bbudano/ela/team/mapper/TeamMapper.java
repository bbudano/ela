package hr.bbudano.ela.team.mapper;

import hr.bbudano.ela.team.dto.CreateTeamRequest;
import hr.bbudano.ela.team.dto.TeamView;
import hr.bbudano.ela.team.dto.UpdateTeamRequest;
import hr.bbudano.ela.team.model.Team;
import org.mapstruct.*;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, unmappedTargetPolicy = ReportingPolicy.WARN)
public interface TeamMapper {

    @Named("toTeamView")
    TeamView toTeamView(Team team);

    @Mapping(target = "id", ignore = true)
    Team toTeam(CreateTeamRequest createTeamRequest);

    @Mapping(target = "id", ignore = true)
    void mapTeam(@MappingTarget Team team, UpdateTeamRequest updateTeamRequest);

}
