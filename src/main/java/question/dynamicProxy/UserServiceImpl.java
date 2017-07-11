package question.dynamicProxy;

public class UserServiceImpl implements UserService {

    @Override
    public String getName(int id) {
        System.out.println("------getName------");
        return "yexx" + id;
    }

    @Override
    public Integer getAge(int id) {
        System.out.println("------getAge------");
        return id;
    }
}
