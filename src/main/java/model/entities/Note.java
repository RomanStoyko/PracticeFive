package model.entities;

public class Note {
    private String firstname;
    private String secondName;
    private String telephone;
    private String date;
    private String adress;

    public Note(){}

    public Note(String firstname, String secondName, String telephone, String date, String adress) {
        this.firstname = firstname;
        this.secondName = secondName;
        this.telephone = telephone;
        this.date = date;
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "Note{" +
                "firstname='" + firstname + '\'' +
                ", secondName='" + secondName + '\'' +
                ", telephone='" + telephone + '\'' +
                ", date='" + date + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }
}
