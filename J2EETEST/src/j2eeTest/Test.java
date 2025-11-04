package j2eeTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Connection con = null;
		Statement st = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee_test","root","root");
			
			boolean b =true;
			do {
				System.out.println("1. Insert \n2. Update \n3. Find \n4. Delete \n5. Find All \n6. Exit");
				System.out.print("Choose any operation: ");
				int val = sc.nextInt();
				
				switch(val) {
					case 1: {
						System.out.println("Enter EID: ");
						int eid = sc.nextInt();
						sc.nextLine();
						System.out.println("Enter Name: ");
						String name = sc.nextLine();
						System.out.println("Enter Salary: ");
						double sal = sc.nextDouble();
						sc.nextLine();
						System.out.println("Enter Address: ");
						String addr = sc.nextLine();
						System.out.println("Enter Contact Number: ");
						int num = sc.nextInt();
						sc.nextLine();
						System.out.println("Enter Email: ");
						String email = sc.nextLine();
						System.out.println("Enter Password: ");
						String pass = sc.nextLine();
						
						ps=con.prepareStatement("insert into emp_details values (?,?,?,?,?,?,?)");
						
						ps.setInt(1, eid);
						ps.setString(2, name);
						ps.setDouble(3, sal);
						ps.setString(4, addr);
						ps.setInt(5, num);
						ps.setString(6, email);
						ps.setString(7, pass);
						
						ps.executeUpdate();
						
						System.out.println("Record inserted successfully");
						break;
					}
					case 2: {
						System.out.println("Enter the EID to update the record: ");
						int eid = sc.nextInt();
						
						System.out.println("Enter Name: ");
						sc.nextLine();
						String name = sc.nextLine();
						System.out.println("Enter Salary: ");
						double sal = sc.nextDouble();
						sc.nextLine();
						System.out.println("Enter Address: ");
						String addr = sc.nextLine();
						System.out.println("Enter Contact Number: ");
						int num = sc.nextInt();
						sc.nextLine();
						System.out.println("Enter Email: ");
						String email = sc.nextLine();
						System.out.println("Enter Password: ");
						String pass = sc.nextLine();
						
						ps=con.prepareStatement("update emp_details set ename=?, esal=?, eaddress=?, econtact=?, email=?, password=? where eid=?");
						
						
						ps.setString(1, name);
						ps.setDouble(2, sal);
						ps.setString(3, addr);
						ps.setInt(4, num);
						ps.setString(5, email);
						ps.setString(6, pass);
						ps.setInt(7, eid);
						
						ps.executeUpdate();
						
						System.out.println("Record updated successfully");
						break;
					}
						
					case 3: {
						System.out.println("Enter the EID to fetch the record: ");
						int eid = sc.nextInt();
						
						ps=con.prepareStatement("select * from emp_details where eid=?");
				
						ps.setInt(1, eid);
						
						rs = ps.executeQuery();
						
						System.out.println("Fetched Record: ");
						if (rs.next()) {
					        System.out.println(
					            "EID: " + rs.getInt(1) + " | " +
					            "Name: " + rs.getString(2) + " | " +
					            "Salary: " + rs.getDouble(3) + " | " +
					            "Address: " + rs.getString(4) + " | " +
					            "Contact: " + rs.getInt(5) + " | " +
					            "Email: " + rs.getString(6) + " | " +
					            "Password: " + rs.getString(7)
					        );
					    } else {
					        System.out.println("No record found with EID " + eid);
					    }
						break;
					}
					
					case 4:
						System.out.println("Enter the EID to delete the record: ");
						int eid = sc.nextInt();
						
						ps=con.prepareStatement("delete from emp_details where eid=?");
						
						ps.setInt(1, eid);
						
						ps.executeUpdate();
						
						System.out.println("Record deleted successfully");
						break;
						
					case 5: 
						st = con.createStatement();
						rs = st.executeQuery("select * from emp_details");
						
						System.out.println("Fetched Record: ");
						while (rs.next()) {
					        System.out.println(
						            "EID: " + rs.getInt(1) + " | " +
						            "Name: " + rs.getString(2) + " | " +
						            "Salary: " + rs.getDouble(3) + " | " +
						            "Address: " + rs.getString(4) + " | " +
						            "Contact: " + rs.getInt(5) + " | " +
						            "Email: " + rs.getString(6) + " | " +
						            "Password: " + rs.getString(7)
						        );
						} 
						break;
						
					case 6:
						b=false;
						System.out.println("Exiting");
						break;
						
					default:
						System.out.println("Invalid option");
				}	
			} while (b);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (st != null) st.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
