package infrastructure.Data;

public class HomeWorkApp {
    public static void main(String[] args) {
        UserFileDataMapper mapper = new UserFileDataMapper();
        System.out.println(mapper.getAll());
        System.out.println(mapper.findUserByEmail("user1@gmail.com"));
        System.out.println(mapper.findUserByUsername("user7"));

    }

}
