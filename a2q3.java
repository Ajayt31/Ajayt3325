import java.sql.*;
import java.io.*;
import java.util.Scanner;

class a2q3
{
	static final int total=25;
	public static void main(String args[]) throws Exception
	{
		Scanner sc= new Scanner(System.in);
		Statement st=null;
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement ps=null;
		int flag=0;
		int ch=-1;
		String str="";

		Class.forName("org.postgresql.Driver");
		con=DriverManager.getConnection("jdbc:postgresql://192.168.16.1:5432/ty203","ty203"," ");

		if(con == null)
		{
			System.out.println("Not able to connect to database");
			System.exit(1);
		}

		do
		{
			System.out.println("1.Enter entry in database\n2.Show Attendence table\n3.show out of 10\n4.Exit ");
			ch=sc.nextInt();
			switch(ch)
			{
				case 1:
					{
					System.out.println("Enter rollno,name,class,subject,total attendend");
					int rno=sc.nextInt();
					if(rno>26 && rno<0)
					{
						System.out.println("Total attendent should be less than 26");
						break;
					}
					String name=sc.next();
					String cls=sc.next();
					String sub=sc.next();
					int tattend=sc.nextInt();
					flag=0;

					if(flag==0)
					{
						ps=con.prepareStatement("Insert into attendance values(?,?,?,?,?)");
						ps.setInt(1,rno);
						ps.setString(2,name);
						ps.setString(3,cls);
						ps.setString(4,sub);
						ps.setInt(5,tattend);

						flag=ps.executeUpdate();

						if(flag>0)
							System.out.println("Inserted sucessfully");
						else
							System.out.println("Not able to insert!!");
					}
					else
					{
						System.out.println("This roll no. student is already present!!");
						break;
					}
					}
				break;
				case 2:
				{
					int marks=0;
					st=con.createStatement();
					rs=st.executeQuery("Select * from attendance");
					System.out.println("Rollno\tName\tClass\tSubject\t\tTotal_attend\t\tpercentage");
					while(rs.next())
					{
						System.out.print(""+rs.getInt(1)+" ");
						System.out.print("\t");
						System.out.print(""+rs.getString(2)+"");
						System.out.print("\t");
						System.out.print(""+rs.getString(3)+" ");
						System.out.print("\t\t");
                                                System.out.print(""+rs.getString(4)+"");
						System.out.print("\t\t");
						System.out.print(""+rs.getInt(5)+" ");
						System.out.println("\t\t");
						double per=rs.getInt(5)*100/total;
						System.out.println(per);
                                         
					}
				}
				break;

				case 3:
				{
					st=con.createStatement();
					rs=st.executeQuery("Select tattend from attendance");
					System.out.println("Attended out of 10");
					System.out.println("Percentage of attendance|MARKS OUT OF 10");
					while(rs.next())
					{
						double per=rs.getInt(1)*100/total;
						if(per<=100 && per>=90)
							System.out.println("\t"+per+"%\t\t|10");
						else if(per<=90 && per>=80)
                                                        System.out.println("\t"+per+"%\t\t|9");
						else if(per<=90 && per>=70)
                                                        System.out.println("\t"+per+"%\t\t|8");
						else if(per<=70 && per>=60)
                                                        System.out.println("\t"+per+"%\t\t|7");
						else if(per<=60 && per>=50)
                                                        System.out.println("\t"+per+"%\t\t|6");
						else if(per<=50 && per>=40)
                                                        System.out.println("\t"+per+"%\t\t|5");
						else if(per<=40 && per>=30)
                                                        System.out.println("\t"+per+"%\t\t|4");
						else if(per<=30 && per>=20)
                                                        System.out.println("\t"+per+"%\t\t|3");
						else if(per<=20 && per>=10)
                                                        System.out.println("\t"+per+"%\t\t|2");
						else if(per<=10 && per>=1)
                                                        System.out.println("\t"+per+"%\t\t|1");
					}
				}
				break;
				case 4:
				{
					st.close();
					con.close();
					System.exit(-1);
				}
			
			}
		}while(ch > 0 && ch < 5);
	}
}
