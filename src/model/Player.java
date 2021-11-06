package model;

public abstract class Player {
    protected String name;
    protected String nickname; //unique
    protected int number;
    protected String teamName;
    protected int ratingPoints;

    protected Player(String name, String nickname, int number, String teamName) {
        this.name = name;
        this.nickname = nickname;
        this.number = number;
        this.teamName = teamName;
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

}
