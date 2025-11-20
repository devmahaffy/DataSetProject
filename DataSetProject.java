import java.io.*;
import java.util.*;
public class DataSetProject {
     public static void main(String[] args) throws FileNotFoundException{
        avgAreaPerMillions("/Users/dmahaffy/Downloads/Housing_Price_Data.csv");
    }

    public static void avgAreaPerMillions(String pathname)throws FileNotFoundException{
        File f = new File(pathname);
        int priceIndex = 0;
        int areaIndex = 1;
        double[] numHousesPerMillion = new double[13];
        double[] areaTotalPerMillion = new double[13];
        int max = 12000000;
        int milIndex = 12;
        for(int i = 12000000; i>0; i-=1000000){
             Scanner sc = new Scanner(f);
            String [] header = sc.nextLine().split(",");
        while(sc.hasNextLine()){
             ArrayList<String> line = new ArrayList<>(Arrays.asList(sc.nextLine().split(",")));
             if(Double.parseDouble(line.get(priceIndex)) >=i && Double.parseDouble(line.get(priceIndex)) <= (i+1000000)){
                numHousesPerMillion[milIndex] = numHousesPerMillion[milIndex] + 1;
                areaTotalPerMillion [milIndex] = areaTotalPerMillion [milIndex] + Double.parseDouble(line.get(areaIndex));
             }
            }
            milIndex--;
        }
        for(int i = 12; i >0; i --){
            Double avg = areaTotalPerMillion[i] / numHousesPerMillion [i];
            System.out.println("The Average Area for " + i + " million dollar houses is: " + Math.round(avg));
        }

    }

}
