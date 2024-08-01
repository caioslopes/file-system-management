package infra.repository.impl;

import domain.User;
import fileSystem.FileManagement;
import infra.repository.IRepository;

public class UserRepository implements IRepository<User, Long> {

    private final FileManagement fileManagement;

    public UserRepository() {
        this.fileManagement = new FileManagement("./csv/user.csv");
    }

    @Override
    public void save(User user) {
        fileManagement.write(user);
    }

    @Override
    public User find(Long identifier) {
        return null;
    }
}
