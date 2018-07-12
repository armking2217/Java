package dz2;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class mainMass {
    public static Scanner enter= new Scanner(System.in);
    public static void main(String[] args) {
        String[][] mass = new String[4][4];
        for (int i = 0; i <mass.length ; i++) {
            for (int j = 0; j <mass[0].length ; j++) {
                System.out.printf("Введите [%d][%d] элемент массива\n", i,j);
                mass[i][j]=enter.nextLine();
            }
        }
        try {
            System.out.println(dzMeth(mass));
        }
        catch(MyArraySizeException e){
            e.printStackTrace();
        }
        catch (MyArrayDataException e){
            System.out.printf("В ячейке [%d][%d]", e.getA(),e.getB());
            e.printStackTrace();
        }
      //  finally {
      //      System.out.println(mass[0][0]+"ffffffffff");
        // }
    }

    public  static int dzMeth (String[][] mass) throws MyArraySizeException ,MyArrayDataException  {

        if(mass.length!=4 || mass[0].length!=4) throw new MyArraySizeException("Введите массив 4*4, а не "+ mass.length+"*"+mass[0].length);
        String arr="012345-6789";
        int m=0;
            for (int s=0,i = 0; i < mass.length; i++) {
                for (int j = 0; j < mass[0].length; j++) {
                    for (int k = 0; k <mass[i][j].length() ; k++) {
                        for (int l = 0; l <arr.length() ; l++) if(mass[i][j].charAt(k)==arr.charAt(l)) s=1;
                        if(s==0) throw new MyArrayDataException("Введите правильную строку", i,j);
                        s=0;
                    }
                    m+=parseInt(mass[i][j]);
                }
            }
        return m;
    }




}

class MyArraySizeException extends Exception {
       public MyArraySizeException(String message) {
            super(message);
        }
 }

class MyArrayDataException extends Exception  {
    private int a,b;
    public MyArrayDataException(String message, int a,int b) {
        super(message);
        this.a=a;
        this.b=b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}


