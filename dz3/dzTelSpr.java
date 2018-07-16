package dz3;

import jdk.nashorn.api.tree.Tree;

import java.util.*;


public class dzTelSpr {
    public static void main(String[] args) {
        phoneBook first=new phoneBook();
        first.add("Max","89104291078");
        first.add("Marina","980192938");
        first.add("Const","*7729389923");
        first.add("Alex","78219929291");
        first.add("Max","111111111");
        first.add("Vanya","93823782237");
        first.add("Const","23327882373");
        first.add("Semen","23223111111111");
        first.add("Nikita","32738382911");
        first.add("Vera","133311111");
        first.add("Max","115467571111");
        first.add("Max","1111135634541");
        first.add("Max","111111111646");
        first.add("Vasya","1111111345635311");
        first.add("Vera","11353451111111");
        try {
            first.print();
            first.get("Max");
            first.get("Vera");
            first.get("Fedya");
        }
        catch(NoNameExeption e){
            e.printStackTrace();
        }
        /*TreeMap<String,TreeSet<String>> tm=new TreeMap<>();
        Iterator<TreeSet<String>> cool=first.getpB().values().iterator();
        while(cool.hasNext()){
            TreeSet<String> ts=cool.next();
            if(ts.contains("980192938")) cool.remove();
            else System.out.println(ts);
        }
        first.print();*/

    }
}

class NoNameExeption extends Exception{
    String lastname;
    public NoNameExeption(String message,String lastname) {
        super(message +" :"+lastname);
        this.lastname=lastname;

    }
}

class phoneBook{
    private TreeMap<String, TreeSet<String>> pB;
    public phoneBook(){
        pB=new TreeMap<>();
    }
    public phoneBook(TreeMap<String, TreeSet<String>> pB){
        this.pB=pB;
    }
    public void get(String lastname) throws NoNameExeption{
        if(pB.get(lastname)==null) throw new NoNameExeption("Данного имени не существует",lastname);
        else {
            System.out.println(lastname+":");
            System.out.println(pB.get(lastname));
        }
    }
    public void add(String lastname, String number){
        TreeSet<String> arr= new TreeSet<>();
        arr.add(number);
        if(pB.get(lastname)==null) pB.put(lastname,arr);
        else{
            arr.clear();
            arr=pB.get(lastname);
            arr.add(number);
            pB.put(lastname,arr);
        }
    }

    public TreeMap<String, TreeSet<String>> getpB() {
        return pB;
    }

    public void print(){
        System.out.println(pB);
    }
}
