package infra.repository.impl;

import domain.Game;
import dto.GameDto;
import fileSystem.FileInterpreter;
import fileSystem.FileManagement;
import infra.fileConverse.GameFileConverse;
import infra.repository.IRepository;

import java.util.Collection;
import java.util.List;

public class GameRepository implements IRepository<Game, Long> {

    private final FileManagement fileManagement;
    private final FileInterpreter fileInterpreter;
    private final GameFileConverse gameFileConverse;

    public GameRepository() {
        this.fileManagement = new FileManagement("./csv/game.csv");
        this.fileInterpreter = new FileInterpreter();
        this.gameFileConverse = new GameFileConverse();
    }

    @Override
    public void save(Game game) {
        fileManagement.write(game);
    }

    @Override
    public Game find(Long identifier) {
        Collection<Game> games = findAll();
        for(Game game : games) {
            if(game.getId().equals(identifier)) {
                return game;
            }
        }
        return null;
    }

    @Override
    public Collection<Game> findAll() {
        return gameFileConverse.all(fileInterpreter.interpret(fileManagement.read(), GameDto.class));
    }


}
