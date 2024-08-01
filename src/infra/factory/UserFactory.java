package infra.factory;

import domain.User;
import fileSystem.Factory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserFactory implements Factory<User> {


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
