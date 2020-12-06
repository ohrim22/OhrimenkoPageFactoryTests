package infrastructure.Data;

public interface UserDataMapper {
     User findUserByEmail(String email);
     User findUserByUsername(String name);


}
