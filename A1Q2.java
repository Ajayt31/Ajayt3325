import java.util.*;

public class q2{
	public static void main(String []args){
		Scanner sc = new Scanner(System.in);

		LinkedList<String> list1 = new LinkedList<>();
		LinkedList<String> list2 = new LinkedList<>();

        	acceptData(list1,sc,"list1");
		acceptData(list2,sc,"list2");		

		System.out.println("\n\nEntered Lists");
		System.out.println(list1);
                System.out.println(list2);


		int c;
		do{
			System.out.println("\nMenu");
                        System.out.println("\n1.Union");
                        System.out.println("\n2.Intersection");
                        System.out.println("\n3.Exit");
                        System.out.println("\nEnter your choice...");
			c = sc.nextInt();

			switch(c){
				case 1:
					performUnion(list1,list2);
					break;
				case 2:
					performIntersection(list1,list2);
					break;
				case 3:
					break;
				default:
					System.out.println("Invalid Choice");
			}
		}while(c!=3);
	}

	private static void acceptData(LinkedList<String>list,Scanner sc, String listName){
		Set<String>uniqueSet = new HashSet<>();
		System.out.println("Enter element for"+listName+"(comma separated):");
		String[] elements = sc.next().split(",");
		for(String element:elements){
			if(uniqueSet.add(element.trim())){
				list.add(element.trim());
			}else{
				System.out.println("Duplicate ignored"+element.trim());
			}
		}
	}

	public static void performUnion(LinkedList<String> list1,LinkedList<String> list2){
		LinkedList<String>unionList = new LinkedList<>(list1);
		unionList.removeAll(list2);
		unionList.addAll(list2);

		System.out.println("Union of the lists: "+unionList);
	}

	public static void performIntersection(LinkedList<String> list1,LinkedList<String> list2){
			LinkedList<String>intersectionList = new LinkedList<>(list1);
			intersectionList.retainAll(list2);
			System.out.println("Intersection of the lists: "+intersectionList);
		}
	}

