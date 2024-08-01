import domain.Game;
import domain.User;
import dto.GameDto;
import fileSystem.FileInterpreter;
import fileSystem.FileManagement;
import infra.factory.GameFactory;
import infra.factory.UserFactory;
import infra.repository.impl.GameRepository;
import infra.repository.impl.UserRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        Game game1 = new Game(1L, "Mario", "Nintendo", LocalDateTime.now(), "Sinopse", new HashMap<>(), new ArrayList<>());
        Game game2 = new Game(2L, "Mega Man", "Capcom", LocalDateTime.now(), "Sinopse", new HashMap<>(), new ArrayList<>());
        Game game3 = new Game(3L, "Castlevania", "Konami", LocalDateTime.now(), "Sinopse", new HashMap<>(), new ArrayList<>());
        Game game4 = new Game(4L, "Sonic", "Sega", LocalDateTime.now(), "Sinopse", new HashMap<>(), new ArrayList<>());

        GameRepository gameRepository = new GameRepository();

        gameRepository.save(game1);
        gameRepository.save(game2);
        gameRepository.save(game3);
        gameRepository.save(game4);

        FileManagement gameFile = new FileManagement("./csv/game.csv");
        FileInterpreter<GameDto> fi = new FileInterpreter<>();
        GameFactory gameFactory = new GameFactory();

        Collection<Game> games = gameFactory.all(fi.interpret(gameFile.read(), GameDto.class));

        games.forEach(System.out::println);

        User user1 = new User(11L, "Caio", "caio@gmail.com", "123");
        User user2 = new User(12L, "Augusto", "augusto@gmail.com", "123");
        User user3 = new User(13L, "Eduardo", "eduardo@gmail.com", "123");
        User user4 = new User(14L, "Lucas", "lucas@gmail.com", "123");

        UserRepository userRepository = new UserRepository();

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);

        FileManagement userFile = new FileManagement("./csv/user.csv");
        FileInterpreter<User> fiUser = new FileInterpreter<>();
        UserFactory userFactory = new UserFactory();

        Collection<User> users = userFactory.all(fiUser.interpret(userFile.read(), User.class));

        users.forEach(System.out::println);

    }

}
