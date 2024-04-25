import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        File file = new File("resources/testData_Apartments.txt");

        Scanner input = null;
        List<Apartment> list = new ArrayList<>();
        //Map<String, Integer> cityApartments = new HashMap<>();
        try {
            input = new Scanner(file);

            while (input.hasNext()) {
                String city = input.next();
                int rooms = input.nextInt();
                int sqrFt = input.nextInt();
                int price = input.nextInt();
                String number = input.next();
                Apartment apt = new Apartment(city, rooms, sqrFt, price, number);
                list.add(apt);
            }
        } catch (FileNotFoundException e) {
            e.getMessage();
        } finally {
            input.close();
        }
        Collections.sort(list);
        if(!list.get(0).city.equals("София") && !list.get(0).getCity().equals("Бургас") && !list.get(0).getCity().equals("Варна")){
            try {
                throw new UnsuitableApartmentsException("No apartments matching the descrtiption");
            } catch (UnsuitableApartmentsException e) {
                e.printStackTrace();
            }
        }else{
            if(list.get(0).getRooms()!=3 || list.get(0).getSqrFt()<=100){
                try {
                    throw new UnsuitableApartmentsException("No apartments matching the descrtiption");
                } catch (UnsuitableApartmentsException e) {
                    e.printStackTrace();
                }
            }else{
                File file2 = new File("output.txt");
                /*if (file.exists()) {
                    System.out.println("File already exists");
                    System.exit(1);
                }*/
                PrintWriter output = null;
                try {
                    output = new PrintWriter(file2);
                    /*for(Apartment p:list){
                        output.append(p.getCity()+" "+p.getPrice()+" "+p.getNumber()+"\n");
                    }*/
                    for(int i=0;i<5;i++){
                        Apartment p = list.get(i);
                        if(!p.city.equals("София") && !p.getCity().equals("Бургас") && !p.getCity().equals("Варна") || (p.getSqrFt()<=100 || p.getRooms()!=3)){
                            break;
                        }
                        // proverka za dublirane
                        boolean fl = true;
                        for(int j=i-1;j>=0;j--){
                            if(list.get(j).getNumber().equals(p.getNumber())){
                                fl=false;
                            }
                        }
                        if(fl){
                            output.append(p.getNumber()+'\n');
                        }
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }finally {
                    output.close();
                }
            }
        }

    }

}
