package util;

import model.Player;
import model.tournament.game.Game;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TournamentGenerator {
    private static final int MAX_GAMES_COUNT = 10;
    private static final int MAX_PLAYERS_COUNT = 11;
    private static final String DESTINATION_FOLDER = "resources";

    public static void main(String[] args) {
        Random random = new Random();

        //create random number of random games
        List<GameType> typeList = new ArrayList<>();
        for (int i = 0; i <= random.nextInt(MAX_GAMES_COUNT); i++) {
            typeList.add(GameType.values()[random.nextInt(GameType.values().length)]);
        }

        //create 2 teams with players for every game
//        List<Team> teams = new ArrayList<>();
//        teams.add(new Team("team alpha"));
//        teams.add(new Team("team beta"));

        List<Game> games = new ArrayList<>();
        List<Player> players = new ArrayList<>();

        //define count of players 1...11
        int playersCount = random.nextInt(MAX_PLAYERS_COUNT) + 1;

        List<String> playersStats;

        clearDirectory();

        for (int i = 0; i < typeList.size(); i++) {
            playersStats = new ArrayList<>();
            GameType type = typeList.get(i);

            playersStats.add(String.valueOf(type));

            String stats;

            switch (type) {
                case BASKETBALL:
                    for (int j = 0; j < playersCount; j++) {
                        stats = String.format("name%d;nick%d;%d;team alpha;%d;%d;%d",
                                j + 1, j + 1, j + 1,
                                random.nextInt(20),
                                random.nextInt(20),
                                random.nextInt(20));
                        playersStats.add(stats);
                        stats = String.format("name%d;nick%d;%d;team beta;%d;%d;%d",
                                j + 1 + playersCount, j + 1 + playersCount, j + 1 + playersCount,
                                random.nextInt(20),
                                random.nextInt(20),
                                random.nextInt(20));
                        playersStats.add(stats);
                    }
                    break;
                case HANDBALL:

                    for (int j = 0; j < playersCount; j++) {
                        String statsa = String.format("name%d;nick%d;%d;team alpha;%d;%d;%d",
                                j + 1, j + 1, j + 1,
                                random.nextInt(20),
                                random.nextInt(20),
                                random.nextInt(20));
                        playersStats.add(statsa);
                        String statsb = String.format("name%d;nick%d;%d;team beta;%d;%d;%d",
                                j + 1 + playersCount, j + 1 + playersCount, j + 1 + playersCount,
                                random.nextInt(20),
                                random.nextInt(20),
                                random.nextInt(20));
                        playersStats.add(statsb);
                    }
//                    playersStats.add("name1;nick1;1;team alpha;15;20");
//                    playersStats.add("name2;nick2;2;team alpha;10;20");
//                    playersStats.add("name3;nick3;3;team beta;12;25");
//                    playersStats.add("name4;nick4;4;team beta;8;25");
                    break;
            }

            System.out.println(playersStats);
            writeFile(playersStats, i + 1);
        }

        GamesHost.main(args);
    }

    private static void clearDirectory() {
        for (File file : new File(DESTINATION_FOLDER).listFiles()) {
            file.delete();
        }
    }

    private static void writeFile(List<String> input, long id) {
        String suffix;
        if (new Random().nextInt(10) > 0) suffix = ".csv";
        else suffix = ".vcs";

        File newFile;
        newFile = new File(DESTINATION_FOLDER + "/game" + id + suffix);
//        System.out.println(newFile.getName());
        try (FileWriter fw = new FileWriter(newFile);
             BufferedWriter bw = new BufferedWriter(fw)) {

            for (String string : input) {
                bw.write(string);
                bw.newLine();
            }

            bw.flush();

        } catch (IOException ignored) {
        }


    }


}
