import java.sql.*;
import java.util.Scanner;

public class KlientDataBase {

    static final String DB_URL ="jdbc:postgresql://localhost:5432/postgres";
    static final String DB_USER ="postgres";
    static final String DB_PASS ="1111";

    static Connection conn;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try{
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            try{
                while(true){
                    System.out.println("Create new DataBASe  press 0: ");
                    System.out.println("1. Add new client");
                    System.out.println("2. Add new product");
                    System.out.println("3. Add new order");
                    System.out.println("4. Show oll client and order");
                    System.out.println("Clear databasa");
                    String s = scanner.nextLine();
                    switch (s){
                        case "0" :
                            initBD();
                            break;
                        case "1" :
                            addClient(scanner);
                            break;
                        case "2" :
                            addProduct(scanner);
                            break;
                        case "3" :
                            addOrder(scanner);
                            break;
                        case "4" :
                            showClientAndOrder();
                            break;
                        case "5" :
                            deleteDB();
                            break;
                    }

                }



            } finally {
                scanner.close();
                if(conn != null) conn.close();
            }


        } catch (SQLException ex){
            ex.printStackTrace();
            return;
        }
    }

    private static void deleteDB() throws SQLException {
        Statement st = conn.createStatement();
        try {
            st.execute("drop table if exists Orders");
            st.execute("drop table if exists Product");
            st.execute("drop table if exists Client");



        } finally {
           st.close();
        }
    }

    private static void initBD() throws SQLException {
        Statement st = conn.createStatement();
        try {

            st.execute("create table Client (id serial not null PRIMARY KEY," +
                    "name varchar(100) not null," +
                    "age numeric not null)");

            st.execute("create table Product (id serial not null PRIMARY KEY," +
                    "name varchar(100) not null," +
                    "quantity numeric not null)");

            st.execute("create table Orders (id serial not null PRIMARY KEY," +
                    "client_id serial not null," +
                    "foreign key (client_id) references Client(id)," +
                    "product_id serial not null,"+
                    "foreign key (product_id) references Product(id),"+
                    "quantity numeric not null)");

        } finally {
            st.close();
        }
    }

    private static void showClientAndOrder() throws SQLException {
        Statement st = conn.createStatement();
        try {

            ResultSet rs = st.executeQuery("select * from Client left join Orders on (Orders.client_id = Client.id)");
            try {
                ResultSetMetaData md = rs.getMetaData();
                for(int i = 1; i<=md.getColumnCount(); i++)
                    System.out.print(md.getColumnName(i)+"\t\t") ;
                System.out.println();
                while (rs.next()) {
                    for (int i = 1; i <= md.getColumnCount(); i++)
                        System.out.print(rs.getString(i) + "\t\t");
                        System.out.println();

                }

            } finally {
                rs.close();
            }
        }finally {
            st.close();
        }


        }


    private static void addOrder(Scanner scanner) throws SQLException {
        System.out.println("Enter the client ID: ");
        String clientID = scanner.nextLine();
        int setClientID = Integer.parseInt(clientID);
        System.out.println("Enter the product ID: ");
        String productID = scanner.nextLine();
        int setProductID = Integer.parseInt(productID);
        System.out.println("Enter the quantity: ");
        String quantity = scanner.nextLine();
        int setQuantity = Integer.parseInt(quantity);

        PreparedStatement ps = conn.prepareStatement("insert into Orders (client_id, product_id, quantity)" +
                "values (?, ?, ?)");
        try {
            ps.setInt(1, setClientID);
            ps.setInt(2, setProductID);
            ps.setInt(3,setQuantity);

            ps.executeUpdate();
        } finally {
            ps.close();
        }
    }


    private static void addProduct(Scanner scanner) throws SQLException {
        System.out.println("Enter the name: ");
        String name = scanner.nextLine();
        System.out.println("Enter the quantity: ");
        String quantity = scanner.nextLine();
        int setQuantity = Integer.parseInt(quantity);

        PreparedStatement ps = conn.prepareStatement("insert into Product (name, quantity)" +
                "values (?, ?)");
        try {
            ps.setString(1, name);
            ps.setInt(2, setQuantity);

            ps.executeUpdate();
        } finally {
            ps.close();
        }
    }


    private static void addClient(Scanner scanner) throws SQLException {
        System.out.println("Enter the name: ");
        String name = scanner.nextLine();
        System.out.println("Enter the age: ");
        String age = scanner.nextLine();
        int setAge = Integer.parseInt(age);


        PreparedStatement ps = conn.prepareStatement("insert into Client (name, age)" +
                "values (?, ?)");
        try {
            ps.setString(1, name);
            ps.setInt(2, setAge);

            ps.executeUpdate();
        } finally {
            ps.close();
        }
    }
}
