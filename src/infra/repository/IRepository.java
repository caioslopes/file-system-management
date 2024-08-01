package infra.repository;

public interface IRepository<T, I> {

    public void save(T t);

    public T find(I identifier);

}
