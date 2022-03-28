import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Product {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Integer a;
        while(true){
            System.out.println("1.Add product data");
            System.out.println("2.View All data");
            System.out.println("3.Search using productcode");
            System.out.println("4.Update using product code");
            System.out.println("5.Delete using product code");
            System.out.println("6.Display product data whose price is greate than 50000");
            System.out.println("7.Display the count of products available");
            System.out.println("8.View all products alphabetically");
            System.out.println("9.Exit");
            System.out.println("Enter the choice");
            a = input.nextInt();
            switch (a){
                case 1:
                    try{
                        Connection c = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/ABCDCompany?autoReconnect=true&useSSL=false","root","");
                        String getcode,getname,getbrand,getprice,getmodel,getyear,getexpiry;
                        System.out.println("Enter the product code");
                        getcode = input.next();
                        System.out.println("Enter the product name");
                        getname = input.next();
                        System.out.println("Enter the product brand");
                        getbrand = input.next();
                        System.out.println("Enter the price");
                        getprice = input.next();
                        System.out.println("Enter the model ");
                        getmodel = input.next();
                        System.out.println("Enter the manufacturing year");
                        getyear = input.next();
                        System.out.println("Enter the expiry date");
                        getexpiry = input.next();
                        Statement b = c.createStatement();
                        b.executeUpdate("INSERT INTO `product`(`code`, `name`,`brand`, `price`, `model`, `yearmanufacture`, `expirydate`) " +
                                "VALUES("+getcode+",'"+getname+"','"+getbrand+"',"+getprice+",'"+getmodel+"',"+getyear+","+getexpiry+")");
                        System.out.println("Inserted successfully");
                    }catch (Exception e){
                        System.out.println(e);
                    }break;
                case 2:
                    try{
                        Connection c = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/ABCDCompany?autoReconnect=true&useSSL=false","root","");
                        Statement b = c.createStatement();
                        ResultSet rs = b.executeQuery("SELECT * FROM `product` WHERE 1");
                        while(rs.next()){
                            System.out.println("Productcode is:"+rs.getInt("code"));
                            System.out.println("Product name :"+rs.getString("name"));
                            System.out.println("Brand:"+rs.getString("brand"));
                            System.out.println("Price of product:"+rs.getInt("price"));
                            System.out.println("Model:"+rs.getString("model"));
                            System.out.println("Manufactured Year "+rs.getInt("yearmanufacture"));
                            System.out.println("Expiry date :"+rs.getInt("expirydate"));

                        }
                    }catch (Exception e){
                        System.out.println(e);
                    }break;
                case 3:
                    try{
                        String getCode;
                        System.out.println("Enter the product code to be searched");
                        getCode = input.next();
                        Connection c = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/ABCDCompany?autoReconnect=true&useSSL=false","root","");
                        Statement b = c.createStatement();
                        ResultSet rs = b.executeQuery("SELECT * FROM `product` WHERE `code`="+getCode);
                        while(rs.next()){
                            System.out.println("Productcode is:"+rs.getInt("code"));
                            System.out.println("Product name :"+rs.getString("name"));
                            System.out.println("Brand:"+rs.getString("brand"));
                            System.out.println("Price of product:"+rs.getInt("price"));
                            System.out.println("Model:"+rs.getString("model"));
                            System.out.println("Manufactured Year "+rs.getInt("yearmanufacture"));
                            System.out.println("Expiry date :"+rs.getInt("expirydate"));
                        }
                    }catch (Exception e){
                        System.out.println(e);
                    }break;
                case 4:
                    try{
                        String getcode,getCode,getname,getbrand,getprice,getmodel,getyear,getexpiry;
                        System.out.println("Enter the product code to be updated");
                        getcode = input.next();
                        System.out.println("Enter the new product code");
                        getCode = input.next();
                        System.out.println("Enter the new product name");
                        getname = input.next();
                        System.out.println("Enter the new product brand");
                        getbrand = input.next();
                        System.out.println("Enter the new price");
                        getprice = input.next();
                        System.out.println("Enter the new model ");
                        getmodel = input.next();
                        System.out.println("Enter the new manufacturing year");
                        getyear = input.next();
                        System.out.println("Enter the new expiry date");
                        getexpiry = input.next();
                        Connection c = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/ABCDCompany?autoReconnect=true&useSSL=false","root","");
                        Statement b = c.createStatement();
                        b.executeUpdate("UPDATE `product` SET `code`= "+getCode+",`name`= '"+getname+"',`brand`='"+getbrand+"',`price`="+getprice+",`model`='"+getmodel+"',`yearmanufacture`="+getyear+",`expirydate`="+getexpiry+" WHERE `code`="+getcode);
                        System.out.println("Updated successfully");
                    }catch (Exception e){
                        System.out.println(e);
                    }break;
                case 5:
                    try{
                        String getcode;
                        System.out.println("Enter the product code to be deleted");
                        getcode = input.next();
                        Connection c = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/ABCDCompany?autoReconnect=true&useSSL=false","root","");
                        Statement b = c.createStatement();
                        b.executeUpdate("DELETE FROM `product` WHERE `code`="+getcode);
                        System.out.println("Product deleted");
                    }catch (Exception e){
                        System.out.println(e);
                    }break;
                case 6:
                    try{

                        Connection c = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/ABCDCompany?autoReconnect=true&useSSL=false","root","");
                        Statement b = c.createStatement();
                        ResultSet rs = b.executeQuery("SELECT * FROM `product` WHERE `price` > 50000");
                        while(rs.next()){
                            System.out.println("Productcode is:"+rs.getInt("code"));
                            System.out.println("Product name :"+rs.getString("name"));
                            System.out.println("Brand:"+rs.getString("brand"));
                            System.out.println("Price of product:"+rs.getInt("price"));
                            System.out.println("Model:"+rs.getString("model"));
                            System.out.println("Manufactured Year "+rs.getInt("yearmanufacture"));
                            System.out.println("Expiry date :"+rs.getInt("expirydate"));
                        }
                    }catch (Exception e){
                        System.out.println(e);
                    }break;
                case 7:
                    try{
                        Connection c = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/ABCDCompany?autoReconnect=true&useSSL=false","root","");
                        Statement b = c.createStatement();
                        ResultSet rs = b.executeQuery("SELECT count(*) as count FROM `product`");
                        rs.next();
                        int count = rs.getInt("count");
                        System.out.println("Total items"+count);

                    }catch (Exception e){
                        System.out.println(e);
                    }break;
                case 8:
                    try{
                        Connection c = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/ABCDCompany?autoReconnect=true&useSSL=false","root","");
                        Statement b = c.createStatement();
                        ResultSet rs = b.executeQuery("SELECT * FROM `product` order by `name` asc");
                        while(rs.next()){
                            System.out.println("Productcode is:"+rs.getInt("code"));
                            System.out.println("Product name :"+rs.getString("name"));
                            System.out.println("Brand:"+rs.getString("brand"));
                            System.out.println("Price of product:"+rs.getInt("price"));
                            System.out.println("Model:"+rs.getString("model"));
                            System.out.println("Manufactured Year "+rs.getInt("yearmanufacture"));
                            System.out.println("Expiry date :"+rs.getInt("expirydate"));
                        }
                    }catch (Exception e){
                        System.out.println(e);
                    }break;
                case 9:
                    System.out.println("Exited");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice selection");
                    break;
            }
        }
    }
}