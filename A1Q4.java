import java.util.*;
import java.io.*;

class student
{
	int rno,age;
	String name;

	public student(int rno,int age,String name)
	{
		this.rno=rno;
		this.age=age;
		this.name=name;
	}
}

class SortByName implements Comparator<student>
{
	public int compare(student a,student b)
	{
		return a.name.compareTo(b.name);
	}
}

class SortByAge implements Comparator<student>
{
	public int compare(student a,student b)
	{
		if(a.age==b.age)
			return 0;
		if(a.age>b.age)
			return 1;
		return -1;
	}
}

class q4
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner (System.in);
		ArrayList<student> a1=new ArrayList<student>();
		a1.add(new student (203,22,"Abhishek"));
		a1.add(new student (205,21,"Gaurav"));
		a1.add(new student (210,20,"Atharva"));
		
		System.out.println("\n-----------------------------------------------------------------------\nSorted by Name:\n");
		Collections.sort(a1,new SortByName());
		for(int i=0;i<a1.size();i++)
		{
			System.out.println("\nName:"+a1.get(i).name+"\nRoll no:"+a1.get(i).rno+"\nAge:"+a1.get(i).age);
		}
		System.out.println("\n--------------------------------------------------------------------------\n Sorted by Age:");
		Collections.sort(a1,new SortByAge());
		for(int i=0;i<a1.size();i++)
                {
                        System.out.println("\nName:"+a1.get(i).name+"\nRoll no:"+a1.get(i).rno+"\nAge:"+a1.get(i).age);
                }

	}
}
