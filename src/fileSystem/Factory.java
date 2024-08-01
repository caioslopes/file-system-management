package fileSystem;

public interface Factory<T> {

    public T generate(String ...args);

}
