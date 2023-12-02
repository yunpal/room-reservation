import java.util.GregorianCalendar;
public class date {
    private int year;
    private int month;
    private int day;
    private int time;
    public date(int yy,int mm, int dd,int tt)
    {
        year=yy;
        month=mm;
        day=dd;
        time =tt;
    }
    public int getYear()
    {
        return year;
    } 
    public int getMonth()
    {
        return month;
    }
    public int getDay()
    {
        return day;
    }  
    public int getTime()
    {
        return time;
    }
    public void setYear(int yy)
    {
        year=yy;
    }
    public void setMonth(int mm)
    {
        month=mm;
    }
    public void setDay(int dd)
    {
        day=dd;
    }
    public void setTime(int tt)
    {
        time=tt;
    }
    static GregorianCalendar gc = new GregorianCalendar();
    public static boolean check(int year,int month,int day,int time)
    {
        if(year<2023)
        {
        System.out.println("연도를 잘못 입력하셨습니다.");
        return true;
        }
        else if(year==2023)
        {
            if((month<3)||month>12)
            {
                System.out.println("달을 잘못 입력하셨습니다.");
            return true;
            }
            else
            {
                if((month==3)||(month==5)||(month==7)||(month==8)||(month==10)||(month==11))
                {
                    if((day<0)||(day>31))
                    {
                        System.out.println("일을 잘못 입력하셨습니다.");
                        return true;
                    }
                    else
                    {
                        if((time<0)||time>24)
                        {
                            System.out.println("시간을 잘못 입력하셨습니다.");
                            return true;
                        }
                        else
                        {
                            return false;
                        }
                    }
                }
                else
                {
                    if((day<0)||(day>30))
                    {
                        System.out.println("일을 잘못 입력하셨습니다.");
                        return true;
                    }
                    else
                    {
                        if((time<0)||time>24)
                        {
                            System.out.println("시간을 잘못 입력하셨습니다.");
                            return true;
                        }
                        else
                        {
                            return false;
                        }
                    }
                }
            }
        }
        else
        {
            if((month<1)||(month>12))
            {
            System.out.println("달을 잘못 입력하셨습니다.");
            return true;
            }
            else
            {
            if (gc.isLeapYear(year))
            {
                if((month==1)||(month==3)||(month==5)||(month==7)||(month==8)||(month==10)||(month==11))
                {
                    if((day<0)||(day>31))
                    {
                        System.out.println("일을 잘못 입력하셨습니다.");
                        return true;
                    }
                    else
                    {
                        if((time<0)||time>24)
                        {
                            System.out.println("시간을 잘못 입력하셨습니다.");
                            return true;
                        }
                        else
                        {
                            return false;
                        }
                    }
                }
                else if(month==2)
                {
                    if((day<0)||(day>29))
                    {
                        System.out.println("일을 잘못 입력하셨습니다.");
                        return true;
                    }
                    else
                    {
                        if((time<0)||time>24)
                        {
                            System.out.println("시간을 잘못 입력하셨습니다.");
                            return true;
                        }
                        else
                        {
                            return false;
                        }
                    }
                }
                else
                {
                    if((day<0)||(day>30))
                    {
                        System.out.println("일을 잘못 입력하셨습니다.");
                        return true;
                    }

                    else
                    {
                        if((time<0)||time>24)
                        {
                            System.out.println("시간을 잘못 입력하셨습니다.");
                            return true;
                        }
                        else
                        {
                            return false;
                        }
                    }
                }
            }
            else
            {
                if((month==1)||(month==3)||(month==5)||(month==7)||(month==8)||(month==10)||(month==11))
                {
                    if((day<0)||(day>31))
                    {
                        System.out.println("일을 잘못 입력하셨습니다.");
                        return true;
                    }

                    else
                    {
                        if((time<0)||time>24)
                        {
                            System.out.println("시간을 잘못 입력하셨습니다.");
                            return true;
                        }
                        else
                        {
                            return false;
                        }
                    }
                }
                else if(month==2)
                {
                    if((day<0)||(day>28))
                    {
                        System.out.println("일을 잘못 입력하셨습니다.");
                        return true;
                    }
                    else
                    {
                        if((time<0)||time>24)
                        {
                            System.out.println("시간을 잘못 입력하셨습니다.");
                            return true;
                        }
                        else
                        {
                            return false;
                        }
                    }
                }
                else
                {
                    if((day<0)||(day>30))
                    {
                        System.out.println("일을 잘못 입력하셨습니다.");
                        return true;
                    }

                    else
                    {
                        if((time<0)||time>24)
                        {
                            System.out.println("시간을 잘못 입력하셨습니다.");
                            return true;
                        }
                        else
                        {
                            return false;
                        }
                    }
                }
            }
            }
        }
        
    }
}
