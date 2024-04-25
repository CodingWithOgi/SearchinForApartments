public class Apartment implements Comparable<Apartment>{
    String city;
    int rooms;
    int sqrFt;
    int price;
    String number;

    public Apartment(String city, int rooms, int sqrFt, int price, String number) {
        this.city = city;
        this.rooms = rooms;
        this.sqrFt = sqrFt;
        this.price = price;
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getSqrFt() {
        return sqrFt;
    }

    public void setSqrFt(int sqrFt) {
        this.sqrFt = sqrFt;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    //@Override
    public int compareTo(Apartment b) {
        if((this.getCity().equals("София") || this.getCity().equals("Варна") || this.getCity().equals("Бургас")) && !b.getCity().equals("София") && !b.getCity().equals("Варна") && !b.getCity().equals("Бургас")){
            return -1;
        }else if((b.getCity().equals("София") || b.getCity().equals("Варна") || b.getCity().equals("Бургас")) && !this.getCity().equals("София") && !this.getCity().equals("Варна") && !this.getCity().equals("Бургас")){
            return 1;
        }else{
            if(this.getRooms()==3 && b.getRooms()!=3){
                return -1;
            }else if(this.getRooms()!=3 && b.getRooms()==3){
                return 1;
            }else{
                if(this.getSqrFt()>100 && b.getSqrFt()<=100){
                    return -1;
                }else if(this.getSqrFt()<=100 && b.getSqrFt()>100){
                    return 1;
                }else{
                    return this.getPrice()-b.getPrice();
                }
            }
        }
    }
}
