package infra.factory;

import domain.Game;
import fileSystem.Factory;

import java.util.ArrayList;
import java.util.Collection;

public class GameFactory implements Factory<Game> {

    @Override
    public Game generate(String... args) {
        return new Game(args);
    }

    public Collection<Game> all(Collection<String[]> dataset){
        Collection<Game> games = new ArrayList<>();
        dataset.forEach( data -> games.add(generate(data)));
        return games;
    }

}
