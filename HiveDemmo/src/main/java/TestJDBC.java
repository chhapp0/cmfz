import java.sql.*;

/**
 * Created by ljf on 2017/7/7.
 */
public class TestJDBC {
    public static void main(String[] args) throws Exception{
        Class.forName("org.apache.hive.jdbc.HiveDriver");
        Connection conn= DriverManager.getConnection("jdbc:hive2://192.168.239.137:10000/baizhi");
        String sql="select name from t_user_external";
        PreparedStatement ps=conn.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            String name = rs.getString(1);
            //String name1 = rs.getString(2);
            //String country = rs.getString(1);
            //String state = rs.getString(2);
            System.out.println(name+"=============");
        }
        rs.close();
        conn.close();
    }
}
