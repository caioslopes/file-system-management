package fileSystem;

import java.util.Collection;

public interface Factory<T> {

    public T generate(String ...args);

    public Collection<T> all(Collection<String[]> dataset);

}
