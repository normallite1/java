package Case1;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Case1.Meny;


public abstract class AbstractDAO {
    private Connection conn;
    private String table;


    public AbstractDAO(Connection conn, String table) {
        this.conn = conn;
        this.table = table;
    }

    public void initDB() {
        try {
            Statement st = conn.createStatement();
            try {
                st.execute("DROP TABLE IF EXISTS Meny");
                st.execute("CREATE TABLE Meny (id serial not null PRIMARY KEY, name varchar(20) " +
                        "not null, price int not null, weight int not null, discount int)");
            } finally {
                st.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void addMeny(Meny m) throws IllegalAccessException, SQLException {
        Field[] fields = m.getClass().getDeclaredFields();

        StringBuilder names = new StringBuilder();
        StringBuilder values = new StringBuilder();
        for (Field f : fields) {
            f.setAccessible(true);
            names.append(f.getName()).append(',');
            values.append("'").append(f.get(m)).append("'").append(',');
        }
        names.deleteCharAt(names.length() -1);
        values.deleteCharAt(values.length() -1);

        String sql = "INSERT INTO " + table + "(" + names + ") VALUES(" + values + ")";
        Statement st = conn.createStatement();
        try {

            st.execute(sql);

        } finally {
            st.close();
        }
    }

    public List<Meny> getFilterPrice(int from, int to) {
        List<Meny> meny = new ArrayList<>();
        try {
            try (Statement st = conn.createStatement()) {
                try (ResultSet rs = st.executeQuery("SELECT * FROM " + table + " WHERE price BETWEEN " +
                        from + " AND " + to)) {
                    ResultSetMetaData md = rs.getMetaData();
                    while (rs.next()) {
                        Meny m = new Case1.Meny();


                            m.setName(rs.getString(2));
                            m.setPrice(rs.getInt(3));
                            m.setWeight(rs.getInt(4));
                            m.setDiscount(rs.getInt(5));


                            meny.add(m);

                    }
                }
            }
            return meny;
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return meny;
    }

    public List<Meny> getDiscountMeny() {
        List<Meny> meny = new ArrayList<>();
        Meny m = new Meny();
        Field[] fields = m.getClass().getDeclaredFields();
        Field id = null;

        for (Field f : fields) {
            if (f.isAnnotationPresent(Discount.class)) {
                id = f;
                id.setAccessible(true);
                break;
            }
        }
            try {
                try (Statement st = conn.createStatement()) {
                    try (ResultSet rs = st.executeQuery("SELECT * FROM " + table + " WHERE " + id.getName() +
                            " > 0")) {
                        ResultSetMetaData md = rs.getMetaData();
                        while (rs.next()) {

                            Meny mm = new Case1.Meny();

                            mm.setName(rs.getString(2));
                            mm.setPrice(rs.getInt(3));
                            mm.setWeight(rs.getInt(4));
                            mm.setDiscount(rs.getInt(5));

                            meny.add(mm);
                        }
                    }
                }
                return meny;
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        return meny;
    }



    public List<Meny> getWeightOneKG(){
        List<Meny> meny1 = new ArrayList<>();
        int i = 0;
        Meny m1 = new Meny();
        Field[] fields = m1.getClass().getDeclaredFields();
        Field id = null;

        for (Field f : fields) {
            if (f.isAnnotationPresent(Weight.class)) {
                id = f;
                id.setAccessible(true);
                break;
            }
        }
            try {
                try (Statement st = conn.createStatement()) {
                    try (ResultSet rs = st.executeQuery("SELECT * FROM " + table + " WHERE " + id.getName() +
                            " > 0")) {
                        ResultSetMetaData md = rs.getMetaData();
                        while (rs.next()) {
                            if(i<1000) {

                                Meny mm = new Case1.Meny();

                                mm.setName(rs.getString(2));
                                mm.setPrice(rs.getInt(3));
                                mm.setWeight(rs.getInt(4));
                                mm.setDiscount(rs.getInt(5));

                                meny1.add(mm);
                                i+=rs.getInt(4);
                            }
                        }
                    }
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        return meny1;
    }
}

