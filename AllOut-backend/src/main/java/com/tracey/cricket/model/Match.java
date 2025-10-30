package com.tracey.cricket.model;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.naming.InvalidNameException;

public class Match {
    private Long id;
    private LocalDate matchDate;
    private String teamA;
    private String teamB;
    private int overs;
    private ArrayList<Player> teamAPlayers;
    private ArrayList<Player> teamBPlayers;
    private MatchState state;

    public Match(Long id, LocalDate matchDate, String teamA, String teamB, int overs) {
        this.id = id;
        this.matchDate = matchDate;
        this.teamA = teamA;
        this.teamB = teamB;
        this.overs = overs;
        this.teamAPlayers = new ArrayList<>();
        this.teamBPlayers = new ArrayList<>();
        this.state = MatchState.SOONTOSTART;
    }

    public Match(Match match) {
        this.id = match.getMatchID();
        this.matchDate = match.getMatchDate();
        this.teamA = match.getTeamAName();
        this.teamB = match.getTeamBName();
        this.overs = match.getOvers();
        try {
            this.teamAPlayers = match.getTeamPlayers(teamA);
            this.teamBPlayers = match.getTeamPlayers(teamB);
        } catch (InvalidNameException e) {
            System.err.println(e.getMessage());
        }
        this.state = match.getMatchState();
        
    }

    public void setTeamPlayers(ArrayList<Player> teamPlayers, String teamName) throws InvalidNameException {
        if (teamName.equalsIgnoreCase(teamA)) {
            this.teamAPlayers = teamPlayers;
        } else if (teamName.equalsIgnoreCase(teamB)) {
            this.teamBPlayers = teamPlayers;
        } else {
            throw new InvalidNameException();
        }
    }

    public void setMatchState(MatchState state) {
        this.state = state;
    }

    public Long getMatchID() {return this.id;}

    public LocalDate getMatchDate() {return this.matchDate;}
    
    public int getOvers() {return this.overs;}

    public String getTeamAName() {return this.teamA;}

    public String getTeamBName() {return this.teamB;}
    public ArrayList<Player> getTeamPlayers(String teamName) throws InvalidNameException {
        ArrayList<Player> teamPlayers = new ArrayList<>();
        
        if (teamName.equalsIgnoreCase(teamA)) {
            for (Player player : teamAPlayers) {
                teamPlayers.add(new Player(player));
            }
        } else if (teamName.equalsIgnoreCase(teamB)) {
            for (Player player : teamBPlayers) {
                teamPlayers.add(new Player(player));
            }
        } else {
            throw new InvalidNameException();
        } 
        return teamPlayers;
    }

    public MatchState getMatchState() {return this.state;}
}