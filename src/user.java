public class user {
    int i=0;
    private String name;
    private String firstname;
    private String phoneNum;
    public user(String nn,String ff,String pp)
    {
        name=nn;
        firstname=ff;
        phoneNum=pp;
    }
    
    public String getName()
    {
        return name+" "+firstname;
    }

    public String getPhoneNum()
    {
        return phoneNum;
    }
    
}
