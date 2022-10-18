package com.sourabh.ipldashboard.repository;

import org.springframework.data.repository.CrudRepository;

import com.sourabh.ipldashboard.model.Team;

public interface TeamRepository extends CrudRepository<Team, Long> {

    Team findByTeamName(String teamName);

}
