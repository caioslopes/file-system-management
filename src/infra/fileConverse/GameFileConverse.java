package infra.fileConverse;

import domain.Game;
import fileSystem.FileConverse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class GameFileConverse implements FileConverse<Game> {

    @Override
    public Game generate(String... args) {
        Game.Builder builder = new Game.Builder();
        return builder.requirement(new HashMap<>()).platform(new ArrayList<>()).fromString(args);
    }

    @Override
    public Collection<Game> all(Collection<String[]> dataset){
        Collection<Game> games = new ArrayList<>();
        dataset.forEach( data -> games.add(generate(data)));
        return games;
    }

}
