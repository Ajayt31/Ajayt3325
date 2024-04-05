import java.sql.*;
import java.util.*;

class as2q1{
	public static void main(String[]args)throws Exception{
		Scanner sc= new Scanner (System.in);
		Connection conn =null;
		Statement st =null;
		ResultSet rs =null;
		PreparedStatement pst =null;

		try{
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://192.168.16.1/ty205","ty205","");
			if (conn == null){
				System.out.println("connection failed!");
			}

			else{
				int ch, id, sal, result;
				String sql, name;
				System.out.println("\n\nConnection Successful\n");
				st = conn.createStatement();

				do{
					System.out.println("\n1. Enter the details \n2.Modify the record \n3. Delete record \n4.Search \n5. View all \n6. Exit\n");
					System.out.println("Enter your choice: ");
					ch = sc.nextInt();
					switch(ch){
						
						case 1: 
							System.out.println("Enter the id of the employee: ");
							id = sc.nextInt();

							System.out.println("Enter the name of the employee: ");
							name = sc.next();

							System.out.println("Enter the salary of the employe: ");
							sal = sc.nextInt();

							sql = "Insert into emp values (?,?,?)";
							pst = conn.prepareStatement(sql);
							pst.setInt(1,id);
							pst.setString(2,name);
							pst.setInt(3,sal);

							result = pst.executeUpdate();

							if(result == 1){
								System.out.println("Data inserted successfully.\n");
								}
								break;

						case 2: 
							System.out.println("Enter the empid for update");
							id = sc.nextInt();

							System.out.println("Enter the emp name for update");
							name = sc.next();

							System.out.println("Enter the salary");
							sal = sc.nextInt();

							sql = "Update emp SET empname = ?, sal = ? WHERE empid = ?";

							pst = conn.prepareStatement(sql);
							pst.setString(1,name);
							pst.setInt(2,sal);
							pst.setInt(3,id);

							result = pst.executeUpdate();

							if(result == 1){
								System.out.println("Update Successful\n");
							}
							break;

						case 3:
							System.out.println("Enter the id to delete");
							id = sc.nextInt();
							sql = "Delete from emp WHERE empid = ?";
							pst = conn.prepareStatement(sql);
							pst.setInt(1,id);
							result = pst.executeUpdate();
							if(result == 1){
								System.out.println("Delete Successful");
							}
							break;

						case 4:
							System.out.println("Enter id to Search");
							id = sc.nextInt();

							sql = "SELECT * FROM emp WHERE empid = ?";
							pst = conn.prepareStatement(sql);
							pst.setInt(1,id);
							rs = pst.executeQuery();
							while(rs.next()){
								System.out.println("ID:   "+rs.getInt(1));
								System.out.println("Name:   "+rs.getString(2));
								System.out.println("Salary:   "+rs.getInt(3));
							}
							rs.close();
							break;

						case 5:
							rs = st.executeQuery("SELECT * FROM emp");
							while(rs.next()){
								System.out.println("ID:   "+rs.getInt(1)+"\t");
								System.out.println("Name:   "+rs.getString(2)+"\t");
								System.out.println("Sal:   "+rs.getInt(3)+"\t");
							}
							rs.close();
							break;
							
					}
				}while(ch!=6);
			}
		}catch (Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			st.close();
			conn.close();
		}
	}
}

