import java.util.*;

class items
{
	String flavour;
	double price;
	public items(String flavour, double price)
	{
		this.flavour=flavour;
		this.price=price;
	}
}
class q3
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		HashMap<String,Double>hp=new HashMap<String,Double>();
		System.out.println("Enter the number of item:");
		int num=sc.nextInt();
		items i[]=new items[num];
		for(int j=0;j<num;j++)
		{
			System.out.println("Enter the flavour");
			String flavour=sc.next();
			System.out.println("Enter the price");
			double price=sc.nextDouble();
			i[j]=new items(flavour,price);
			if(hp.containsKey(i[j].flavour)&& hp.containsValue(i[j].price))
			{
				System.out.println("Item Exist");
				j--;
			}
			else
			{
				hp.put(i[j].flavour,i[j].price);
			}
		}
	//	System.out.println("hp");

		while(true)
		{
			System.out.println("\n--------------------------------------------------------------------------\nMenu\nEnter your choice");
			System.out.println("\n1.Search\n2.Sort\n3.Exit");
			int ch=sc.nextInt();

			switch(ch)
			{
				case 1:
					System.out.println("Enter the flavour to Search");
					String f=sc.next();
					if(hp.containsKey(f))
					{
						System.out.println("\nFlavour:"+f+"\nprice:\t"+hp.get(f));
					}
					else
					{
						System.out.println("Not Exist\n");
					}
					break;
				case 2:
					List<Map.Entry<String,Double>> list=new ArrayList<>(hp.entrySet());
					Collections.sort(list,new Comparator<Map.Entry<String,Double>>()
							{
								public int compare(Map.Entry<String,Double> e1,Map.Entry<String,Double>e2)
								{
									return (int) (e1.getValue()-e2.getValue());
								}
							});
							for(Map.Entry<String,Double> e:list)
							{
								System.out.println(e.getKey()+":"+e.getValue());
							}
							break;
				case 3:
							System.exit(0);
			}
		}
	}
}
