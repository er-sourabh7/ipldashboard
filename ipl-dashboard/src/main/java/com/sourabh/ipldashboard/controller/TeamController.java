package com.sourabh.ipldashboard.controller;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sourabh.ipldashboard.model.Match;
import com.sourabh.ipldashboard.model.Team;
import com.sourabh.ipldashboard.repository.MatchRepository;
import com.sourabh.ipldashboard.repository.TeamRepository;

@RestController
@RequestMapping("/team")
public class TeamController {

    TeamRepository teamRepository;
    MatchRepository matchRepository;

    public TeamController(TeamRepository teamRepository, MatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }

    @GetMapping("{teamName}")
    public Team getTeam(@PathVariable String teamName) {

        Team team = teamRepository.findByTeamName(teamName);
        List<Match> matches = matchRepository.findLatestMatchesByTeam(teamName, teamName);
        team.setMatches(matches);
        return team;

    }

}
