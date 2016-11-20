package pages.searchPage;

public enum Hotel {
    AirBnb("airbnb"), BookingCom("");//TODO add for booking

    String partner;

    Hotel(String partner){
        this.partner = partner;
    }


    @Override
    public String toString(){
        return partner;
    }
}
