package infra.repository.impl;

import domain.Game;
import fileSystem.FileManagement;
import infra.repository.IRepository;

public class GameRepository implements IRepository<Game, Long> {

    private final FileManagement fileManagement;

    public GameRepository() {
        this.fileManagement = new FileManagement("./csv/game.csv");
    }

    @Override
    public void save(Game game) {
        fileManagement.write(game);
    }

    @Override
    public Game find(Long identifier) {
        //TO-DO
        return null;
    }
}
