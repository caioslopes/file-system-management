import domain.Game;
import fileSystem.FileInterpreter;
import fileSystem.FileManagement;
import infra.repository.impl.GameRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String args[]){

        Game game1 = new Game(1L, "Mario", "Nintendo", LocalDateTime.now(), "Sinopse", new HashMap<>(), new ArrayList<>());
        Game game2 = new Game(2L, "Mega Man", "Nintendo", LocalDateTime.now(), "Sinopse", new HashMap<>(), new ArrayList<>());
        Game game3 = new Game(3L, "Castlevania", "Nintendo", LocalDateTime.now(), "Sinopse", new HashMap<>(), new ArrayList<>());
        GameRepository gameRepository = new GameRepository();

        gameRepository.save(game1);
        gameRepository.save(game2);
        gameRepository.save(game3);

//        gameRepository.find(1L);

        FileManagement fileManagement = new FileManagement("./csv/game.csv");

        FileInterpreter fi = new FileInterpreter();

        try{
            fi.interpret(fileManagement.read(), game1);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
