package infra.repository.impl;

import domain.User;
import fileSystem.FileInterpreter;
import fileSystem.FileManagement;
import infra.fileConverse.GameFileConverse;
import infra.fileConverse.UserFileConverse;
import infra.repository.IRepository;

import java.util.Collection;

public class UserRepository implements IRepository<User, Long> {

    private final FileManagement fileManagement;
    private final FileInterpreter fileInterpreter;
    private final UserFileConverse userFileConverse;

    public UserRepository() {
        this.fileManagement = new FileManagement("./csv/user.csv");
        this.fileInterpreter = new FileInterpreter();
        this.userFileConverse = new UserFileConverse();
    }

    @Override
    public void save(User user) {
        fileManagement.write(user);
    }

    @Override
    public User find(Long identifier) {
        return null;
    }

    @Override
    public Collection<User> findAll() {
        return userFileConverse.all(fileInterpreter.interpret(fileManagement.read(), User.class));
    }
}
