package JavaProKruchkovTask2;

public class Employer {
    private String name;
    private double age;
    private String casta;
    public String getName()    {
        return this.name;
    };
    public String getCasta()    {
        return this.casta;
    };
    public Double getAge()    {
        return this.age;
    }
    public Employer( String name,    double age, String casta)    {
        this.name = name;
        this.age = age;
        this.casta = casta;
    }
}
