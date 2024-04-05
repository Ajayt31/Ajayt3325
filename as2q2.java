import java.sql.*;
import java.io.*;
import java.util.*;

class as2q2
{
	public static void main(String args[])throws Exception
	{
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try
		{
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://192.168.16.1/ty203","ty203","");
			if(con == null)
			{
				System.out.println("Connection Failed");
			}
			else
			{
				int result,id,time,ch,code,d;
				String name, cls,sname;
				System.out.println("Connection Successful");
				st = con.createStatement();
				do{
					System.out.println("\n1.Add record \n2. Display date wise lec \n3. Display class wise tt \n4.Modify record \n5. Exit");
					System.out.println("\nEnter your choice");
					ch = sc.nextInt();
					if(ch == 5)
						break;
					switch(ch){

						case 1:
							System.out.println("Enter teacher id");
							id = sc.nextInt();

							System.out.println("Enter the teacher name");
							name = sc.next();

							ps = con.prepareStatement("Insert into teacher values(?,?)");
							ps.setInt(1,id);
							ps.setString(2,name);

							result = ps.executeUpdate();

							System.out.println("Enter code");
							code = sc.nextInt();
							System.out.println("Enter Sub");
							sname = sc.next();
                                                        System.out.println("Enter date");
							d = sc.nextInt();
                                                        System.out.println("Enter time");
							time = sc.nextInt();
                                                        System.out.println("Enter class");
							cls = sc.next();
                                                        System.out.println("Enter Id");
							id = sc.nextInt();


							ps = con.prepareStatement("insert into workload values(?,?,?,?,?,?)");
							ps.setInt(1,code);
							ps.setString(2,sname);
							ps.setInt(3,d);
							ps.setInt(4,time);
							ps.setString(5,cls);
							ps.setInt(6,id);


							result = ps.executeUpdate();
							
							if(result == 1)
							{
								System.out.println("Teacher added Successfully");
							}
							break;

						case 2:
							System.out.println("Enter teaher name");
							name = sc.next();
							ps = con.prepareStatement("select d,time,class from teacher, workload where teacher.tid = workload.tid AND  tname = (?)");
							ps.setString(1,name);
							rs = ps.executeQuery();
							while(rs.next())
							{
								System.out.println("Date = "+rs.getInt(1)+"\t");
								System.out.println("Time = "+rs.getInt(2)+"\t");
								System.out.println("Class = "+rs.getString(3)+"\n");
							}
							rs.close();
							break;
						case 3:
							System.out.println("Enter class name");
							name = sc.next();
							ps = con.prepareStatement("select d,time from workload where class = ?");
							ps.setString(1,name);
							rs = ps.executeQuery();
							while(rs.next())
							{
								System.out.println("Date = "+rs.getInt(1)+"\t");
								System.out.println("Time = "+rs.getInt(2)+"\t");
							}
							rs.close();
							break;

						case 4: 
							System.out.println("Enter teaher id");
							id = sc.nextInt();
							System.out.println("Ener the updated time");
							time = sc.nextInt();
							System.out.println("Enter the updted class");
							cls = sc.next();

							ps = con.prepareStatement("update workload set time = ?, class = ? where tid = ?");
							ps.setInt(1,time);
							ps.setString(2,cls);
							ps.setInt(3,id);
							result = ps.executeUpdate();
							if(result == 1){
								System.out.println("Teacher info updated Successfully");
							}
							break;
						case 5:
							break;

						default: 
							System.out.println("Invalid input");
							ch = sc.nextInt();
							break;
					}
				}while(ch!=5);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}


