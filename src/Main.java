import domain.Game;
import dto.GameDto;
import fileSystem.FileInterpreter;
import fileSystem.FileManagement;
import infra.factory.GameFactory;
import infra.repository.impl.GameRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Main {

    public static void main(String[] args){

        Game game1 = new Game(1L, "Mario", "Nintendo", LocalDateTime.now(), "Sinopse", new HashMap<>(), new ArrayList<>());
        Game game2 = new Game(2L, "Mega Man", "Capcom", LocalDateTime.now(), "Sinopse", new HashMap<>(), new ArrayList<>());
        Game game3 = new Game(3L, "Castlevania", "Konami", LocalDateTime.now(), "Sinopse", new HashMap<>(), new ArrayList<>());
        Game game4 = new Game(4L, "Sonic", "Sega", LocalDateTime.now(), "Sinopse", new HashMap<>(), new ArrayList<>());

        GameRepository gameRepository = new GameRepository();

        gameRepository.save(game1);
        gameRepository.save(game2);
        gameRepository.save(game3);
        gameRepository.save(game4);

        FileManagement fileManagement = new FileManagement("./csv/game.csv");
        FileInterpreter<GameDto> fi = new FileInterpreter<>();
        GameFactory gameFactory = new GameFactory();

        Collection<Game> games = gameFactory.all(fi.interpret(fileManagement.read(), GameDto.class));

        games.forEach( game -> System.out.println(game.getPublisher()) );


    }

}
