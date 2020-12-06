package infrastructure.Data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserFileDataMapper implements UserDataMapper {

    List<User> list = new ArrayList<>();

    public UserFileDataMapper() {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("users.txt")));) {
            String rb = null;
            while ((rb = reader.readLine()) != null) {
                String[] splitedUser = rb.split(";");

                try {
                    String s = rb.split(";")[3];
                } catch (ArrayIndexOutOfBoundsException ex) {
                    continue;
                }


                list.add(new User(splitedUser[0], splitedUser[1], splitedUser[2], splitedUser[3]));

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findUserByEmail(String email) {

        for (User user : list) {

            if (user != null && user.getUserEmail().equals(email))
                return user;
        }
        throw new UserNotFoundException(String.format("Can't find user with this email", email));
    }

    @Override
    public User findUserByUsername(String name) {

        for (User user : list) {

            if (user != null && user.getUsername().equals(name))
                return user;
        }
        throw new UserNotFoundException(String.format("Can't find user with this name", name));
    }


    public List<User> getAll() {
        return list;

    }

}
