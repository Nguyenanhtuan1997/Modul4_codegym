package service.IService;

public interface ISeviceUser<E> {
    void add(E e);

    boolean checkUser(String userName, String password);

    int getIdUser(String userName, String password);

}
