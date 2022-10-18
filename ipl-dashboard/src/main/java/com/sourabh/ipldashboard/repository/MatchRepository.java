package com.sourabh.ipldashboard.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.sourabh.ipldashboard.model.Match;

public interface MatchRepository extends CrudRepository<Match, Long>{
    
    List<Match> getByTeam1OrTeam2OrderByDateDesc(String teamName1, String teamName2, Pageable pageable);

    default List<Match> findLatestMatchesByTeam(String teamName1, String teamName2){
        Pageable pageable = PageRequest.of(0, 4);
        List<Match> matches = getByTeam1OrTeam2OrderByDateDesc(teamName1, teamName2, pageable);
        return matches;
    }
}
