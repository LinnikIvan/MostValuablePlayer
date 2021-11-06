package model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Team {
    private String name;
    private Set<Player> players = new HashSet<>();
    private boolean isWon = false;

    public void addPlayer(Player player) {
        if (name.equals(player.getTeamName()))
            players.add(player);
    }

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    public boolean isWon() {
        return isWon;
    }

    public void setWon(boolean won) {
        isWon = won;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", players=" + players +
                ", isWon=" + isWon +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return getName().equals(team.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
