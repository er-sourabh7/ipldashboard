package com.sourabh.ipldashboard.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Team {

    private long id;
    private String teamName;
    private long totalMatches;
    private long totalWins;
}
