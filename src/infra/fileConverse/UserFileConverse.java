package infra.fileConverse;

import domain.User;
import fileSystem.FileConverse;

import java.util.ArrayList;
import java.util.Collection;

public class UserFileConverse implements FileConverse<User> {


    @Override
    public User generate(String... args) {
        return new User(args);
    }

    @Override
    public Collection<User> all(Collection<String[]> dataset) {
        Collection<User> users = new ArrayList<User>();
        dataset.forEach(user -> users.add(new User(user)));
        return users;
    }
}
