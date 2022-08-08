import java.net.URL;
import java.sql.*;
import java.util.Scanner;
import java.lang.Integer;

public class Main {

    static final String URL_DB_CONNECTION = "jdbc:postgresql://localhost:5432/java";
    static final String DB_USER = "postgres";
    static final String DB_PASS = "1111";

    static Connection conn;

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            try {

            conn = DriverManager.getConnection(URL_DB_CONNECTION, DB_USER, DB_PASS);
            initBD();


            while (true) {
                System.out.println("Press 1, and add new apartment");
                System.out.println("Press 2, to filter by price");
                System.out.println("Press 3, to filter by rooms");

                String s = scanner.nextLine();
                switch (s) {
                    case "1":
                        addApartments(scanner);
                        break;
                    case "2":
                        filterPrice(scanner);
                        break;
                    case "3":
                        filterRoom(scanner);
                        break;
                }

            }
        } finally {
            scanner.close();
            if (conn != null) conn.close();
        }
    }catch (SQLException ex){
            ex.printStackTrace();
            return;
        }

    }

    private static void initBD() throws SQLException {
        Statement st = conn.createStatement();
        try {
            st.execute("drop table if exists Apartments");
            st.execute("create table Apartments (id serial not null PRIMARY KEY," +
                    "street varchar(100) not null," +
                    "room numeric not null, " +
                    "price numeric not null)");
        } finally {
            st.close();
        }

        }
    private static void addApartments(Scanner scanner) throws SQLException {
        System.out.println("Enter the street: ");
        String street = scanner.nextLine();
        System.out.println("Enter the room: ");
        String room = scanner.nextLine();
        int setRoom = Integer.parseInt(room);
        System.out.println("Enter the price: ");
        String price = scanner.nextLine();
        int setPrice = Integer.parseInt(price);

        PreparedStatement ps = conn.prepareStatement("insert into Apartments (street,room,price)" +
                "values (?, ?, ?)");
        try {
            ps.setString(1, street);
            ps.setInt(2, setRoom);
            ps.setInt(3, setPrice);
            ps.executeUpdate();
        } finally {
            ps.close();
        }

    }

    private static void filterRoom(Scanner scanner) throws SQLException {
        System.out.println("Enter count room: ");
        String room = scanner.nextLine();
        int countRoom = Integer.parseInt(room);
        Statement st = conn.createStatement();
        try {
            ResultSet rs = st.executeQuery("select * from Apartments where room = '"+countRoom+"'");
            try {
                ResultSetMetaData md = rs.getMetaData();
                for(int i = 1; i<=md.getColumnCount(); i++)
                    System.out.println(md.getColumnName(i)+"\t\t") ;
                System.out.println();
                while (rs.next()) {
                    for (int i = 1; i <= md.getColumnCount(); i++) {
                            System.out.println(rs.getString(i) + "\t\t");

                    }
                }

            } finally {
                rs.close();
            }
        }finally {
            st.close();
        }
    }

    private static void filterPrice(Scanner scanner) throws SQLException {
        System.out.println("Enter count price: ");
        String price = scanner.nextLine();
        int countPrice = Integer.parseInt(price);
        Statement st = conn.createStatement();
        try {
            ResultSet rs = st.executeQuery("select * from Apartments where room >= '"+countPrice+"'");
            try {
                ResultSetMetaData md = rs.getMetaData();
                for(int i = 1; i<=md.getColumnCount(); i++)
                    System.out.println(md.getColumnName(i)+"\t\t") ;

                while (rs.next()) {
                    for (int i = 1; i <= md.getColumnCount(); i++) {
                            System.out.println(rs.getString(i) + "\t\t");

                    }
                }

            } finally {
                rs.close();
            }
        }finally {
            st.close();
        }
    }
}





