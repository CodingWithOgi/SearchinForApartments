import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        File file = new File("testData_Apartments.txt");

        Scanner input = null;
        List<Apartment> list = new ArrayList<>();
        /*
        //VIN, counter insurances
        Map<String, Integer> insCars = new HashMap<>();
        //VIN, owners
        Map<String, Set<String>> vinOwners = new HashMap<>();

        Map<String, Car> insRegNo = new HashMap<>();*/
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
        if(list.get(0).city!="София" && list.get(0).getCity()!="Бургас" && list.get(0).getCity()!="Варна"){
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
            }
        }
        File file2 = new File("output.txt");
        if (file.exists()) {
            System.out.println("File already exists");
            System.exit(1);
        }
        PrintWriter output = null;
        try {
            output = new PrintWriter(file2);

//            4. да запишем във файла сортирани данни за колите
//            6. регНомер на колата - , бр. соств, бр. застраховки
//            output.print("John T Smith ");
//            output.println(90);
//            output.print("Eric K Jones ");
//            output.println(85);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            output.close();
        }
    }

}
