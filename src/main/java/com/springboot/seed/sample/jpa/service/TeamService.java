package com.springboot.seed.sample.jpa.service;

import com.springboot.seed.sample.jpa.domain.Team;
import com.springboot.seed.sample.jpa.dto.TeamDto;
import com.springboot.seed.sample.jpa.repository.TeamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TeamService {

    private static final Logger log = LoggerFactory.getLogger(TeamService.class);

    @Autowired
    TeamRepository teamRepository;

    public Team save(TeamDto teamDto) {
        return teamRepository.save(Team.builder()
            .teamName(teamDto.getTeamName())
            .build());
    }

    public Team updateTeamName(TeamDto teamDto) {
        Team team = teamRepository.findById(teamDto.getId()).orElse(null);

        if (team != null) {
            team.setTeamName(teamDto.getTeamName());
        }

        return team;
    }

    public List<Team> findAll() {
        return teamRepository.findAll();
    }
}
