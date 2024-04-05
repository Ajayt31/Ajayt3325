import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class q1{
	public static void main(String []args){
		Map<String,String> contactTable = new HashMap<>();

		contactTable.put("Abhishek","123456788");
                contactTable.put("Gaurav","123456788");
                contactTable.put("Yash","123456788");


		System.out.println("Contact Details: ");
		for(Map.Entry<String,String> entry:contactTable.entrySet()){
			System.out.println(entry.getKey()+":"+entry.getValue());
		}


		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name to search...");
		String searchPerson = sc.nextLine();

		if(contactTable.containsKey(searchPerson)){
			System.out.println("Contact no. for "+searchPerson+":"+contactTable.get(searchPerson));
		}else{
			System.out.println("Person not in contact");
		}
	}
}

