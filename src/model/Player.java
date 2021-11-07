package model;

import java.util.Objects;

public abstract class Player {
    protected final String name;
    protected final String nickname;
    protected final int number;
    protected final String teamName;
    protected int ratingPoints;

    protected Player(String name, String nickname, int number, String teamName) {
        this.name = name;
        this.nickname = nickname;
        this.number = number;
        this.teamName = teamName;
    }

    public abstract int getTeamEffectivePoints();

    public void addRatingPoints(int points) {
        ratingPoints += points;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public int getNumber() {
        return number;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getRatingPoints() {
        return ratingPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return getNickname().equals(player.getNickname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNickname());
    }
}
