Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

Map<Integer, Integer> hashMap = new hashMap<Integer, Integer>()
{{
    put(1, 2);
    put(5, 3);
    put(7, 2);
}};

hashMap.containsKey(1);
hashMap.containsKey(9);

hashMap.get(5);

hashMap.put(9, 15);

hashMap.remove(9);

hashMap.size();

for(int key: hashMap.keySet())
{
    System.out.println(key);
}

for(int val: hashMap.values())
{
    System.out.println(val);
}

public class Example
{
    public static void main(String[] args)
    {
        Map<Integer, Integer> myHashMap = new HashMap<Integer, Integer>();

        myHashMap.put(4, 83);

        System.out.println(myHashMap.get(4));
        System.out.println(myHashMap.containsKey(4));
        System.out.println(myHashMap.containsKey(854));

        myHashMap.put(8, 327);
        myHashMap.put(4, 82323);

        for(int key: myHashMap.keySet())
        {
            System.out.println(String.format("%d: %d", key, myHashMap.get(key)));
        }
    }
}