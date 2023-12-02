public class room {
    private int i=0;
    private int j=0;
    private int number=0;
    private int capacity=0;
    private date [] scheduledStart = new date[100];
    private user [] use = new user[100];
    private int [] scheduledEnd=new int[100];
    private int []a= new int [100];
    public room(int number ,int capacity)
    {
        this.number=number;
        this.capacity=capacity;
    }
    public int getReservation()
    {
        return i;
    }

    public void setScheduledStartof(int yy,int mm,int dd,int tt,int userNumber)
    {
        scheduledStart[i] = new date(yy,mm,dd,tt);
        a[i] = userNumber;
    }
    public void setUserof(String name,String ff,String phoneNum)
    {
        use[j++] = new user(name,ff,phoneNum);
    }
    public void setScheduledEndof(int tt)
    {
        scheduledEnd[i++] = tt;
    }
    
    public int getNumberOfGuest(int i)
    {
        return a[i];
    }
    public int getNumber()                                             
    {                                                                    
       return number;                       
    }
    public int getCapacity()                                             
    {                                                                    
       return capacity;                       
    }  
    public int getYear(int i)
    {
        return scheduledStart[i].getYear();
    } 
    
    public int getMonth(int i)
    {
        return scheduledStart[i].getMonth();
    }
    public int getDay(int i)
    {
        return scheduledStart[i].getDay();
    }  
    public int getStartTime(int i)
    {
        return scheduledStart[i].getTime();
    }
    public String getUserName(int i)
    {
        return use[i].getName();
    }

    public String getPhoneNum(int i)
    {
        return use[i].getPhoneNum();
    }
    public int getEndTime(int i)
    {
        return scheduledEnd[i];
    }
    public void setYear(int i,int k)
    {
        scheduledStart[i].setYear(k);
    } 
    public void setMonth(int i,int k)
    {
        scheduledStart[i].setMonth(k);
    }
    public void setDay(int i,int k)
    {
        scheduledStart[i].setDay(k);
    }  
    public void setStartTime(int i,int k)
    {
        scheduledStart[i].setTime(k);
    }
    public void setEndTime(int i,int k)
    {
        scheduledEnd[i]=k;
    }


}
