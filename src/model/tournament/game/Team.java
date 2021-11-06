package model.tournament.game;

import model.Player;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Team {
    private final String name;
    private final Set<Player> players = new HashSet<>();

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

    public Set<Player> getPlayers() {
        return players;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", players=" + players +
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
