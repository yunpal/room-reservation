import java.io.File;
import java.io.IOException;
import java.util.*;
public class reservation {
    public static void main(String[] args) throws IOException 
    {
        Scanner scanner = new Scanner(new File("./hw2_201820016g/src/room.txt"));
        String str = scanner.next();
        int wholeNum=Integer.valueOf(str);
        room[] conference=new room[wholeNum];
        int i=0;
        while (scanner.hasNext()) {
            str = scanner.next();
            String str1 = scanner.next();
            conference[i]=new room(Integer.valueOf(str),Integer.valueOf(str1));
            i++;
        }
        while(true)
        {
        System.out.print(">");
        Scanner in = new Scanner(System.in);
        str=in.nextLine();
        String[] result = str.split(" ");
        //예약
        int min=0;
        if(result[0].equals("r"))
        {
            int [] arr= new int[wholeNum];
            Arrays.fill(arr, 0);
            int [] array= new int[wholeNum];
            Arrays.fill(array, 0);
            int year=Integer.valueOf(result[1]);
            int month=Integer.valueOf(result[2]);
            int day=Integer.valueOf(result[3]);
            int start=Integer.valueOf(result[4]);
            int duration=Integer.valueOf(result[5]);
            int number=Integer.valueOf(result[6]);
        if(duration>5)
        {
            System.out.println("회의시간이 5시간을 초과하였습니다.");
            continue;
        }
        if(date.check(year,month,day,start))
        {
            continue;
        }
        for(i=0;i<wholeNum;i++)
        {
        if(conference[i].getCapacity()>=Integer.valueOf(result[6]))
        {
            arr[i]=1;
        }
        }
        min=100;
        for(i=0;i<wholeNum;i++)
        {
            if(arr[i]!=0)
            {
                for(int j=0; j<conference[i].getReservation() ; j++)
                {
                if(conference[i].getReservation()!=0)
                {
                if(conference[i].getYear(j)==year)
                {
                    if(conference[i].getMonth(j)==month)
                    {
                        if(conference[i].getDay(j)==day)
                        {
                        for(int k=0;k<=duration;k++)
                        {
                            if(conference[i].getStartTime(j)<=(start+k))
                            {
                                if((conference[i].getEndTime(j)+conference[i].getStartTime(j))>=(start+k))
                                {
                                   
                                    arr[i]=0;
                                }
                            }
                        }
                    }
                    }
                }
                }
                }
            }
        }

        for(i=0;i<wholeNum;i++)
        {
            if(arr[i]!=0)
            {
                min=i;
            }
        }
        if(min==100)
        {
            System.out.println("예약가능한 장소가 없습니다!");
            continue;
        }
        for(i=0;i<wholeNum;i++)
        {
            if(arr[i]!=0)
            {
                if(conference[i].getCapacity()<conference[min].getCapacity())
                   {
                    min =i;
                   } 
            }
        }

        conference[min].setScheduledStartof(year,month,day,start,number);
        conference[min].setScheduledEndof(duration);
        System.out.printf("사용자 정보를 입력하세요(이름,전화번호)>");
        str=in.nextLine();
        result = str.split(" ");
        conference[min].setUserof(result[0],result[1],result[2]);
        System.out.println("다음과 같이 예약되었습니다!");
        String s =conference[min].getNumber()+"호"+"("+conference[min].getCapacity()+")"+", "+year+"년 "+ month+"월"+day+"일 "+ start+"시"+"("+duration+"시간), "+number+"명, "+result[0]+" "+ result[1]+", "+result[2];
        System.out.println(s);
        }
        //예약취소
        if(result[0].equals("c"))
        {
        room[] used =new room[10];
        int[] usedKey = new int [10];
        room tmp;
        int tp;
        int k=0; 
        for(i=0;i<wholeNum;i++)
        {
            for(int j=0;j<conference[i].getReservation();j++)
            {
                if(conference[i].getPhoneNum(j).equals(result[1]))
                {
                    used[k]=conference[i];
                    usedKey[k]=j;
                    k++;
                }
            }
        }
        
        if (k==0)
        {
        System.out.println("예약이 없습니다!");
        }
        else
        {
        for(i=0;i<k;i++)
        {
            for(int j=0;j<k;j++)
            if(used[i].getYear(usedKey[i])<used[j].getYear(usedKey[j]))
            {
    
                tmp =used[i];
                tp=usedKey[i];
                used[i]=used[j];
                usedKey[i]=usedKey[j];
                used[j]=tmp;
                usedKey[j]=tp;
            }
        }
        for(i=0;i<k;i++)
        {
            for(int j=0;j<k;j++)
            if(used[i].getYear(usedKey[i])==used[j].getYear(usedKey[j]))
            {
            if(used[i].getMonth(usedKey[i])<used[j].getMonth(usedKey[j]))
            {
                tmp =used[i];
                tp=usedKey[i];
                used[i]=used[j];
                usedKey[i]=usedKey[j];
                used[j]=tmp;
                usedKey[j]=tp;
            }
            }
        }
        for(i=0;i<k;i++)
        {
            for(int j=0;j<k;j++)
            if(used[i].getYear(usedKey[i])==used[j].getYear(usedKey[j]))
            {
            if(used[i].getMonth(usedKey[i])==used[j].getMonth(usedKey[j]))
            {
            if(used[i].getDay(usedKey[i])<used[j].getDay(usedKey[j]))
            {
                tmp =used[i];
                tp=usedKey[i];
                used[i]=used[j];
                usedKey[i]=usedKey[j];
                used[j]=tmp;
                usedKey[j]=tp;
            }
            }
            }
        }
        for(i=0;i<k;i++)
        {
            for(int j=0;j<k;j++)
            if(used[i].getYear(usedKey[i])==used[j].getYear(usedKey[j]))
            {
            if(used[i].getMonth(usedKey[i])==used[j].getMonth(usedKey[j]))
            {
                if(used[i].getDay(usedKey[i])==used[j].getDay(usedKey[j]))
                {
            if(used[i].getStartTime(usedKey[i])<used[j].getStartTime(usedKey[j]))
            {
                tmp =used[i];
                tp=usedKey[i];
                used[i]=used[j];
                usedKey[i]=usedKey[j];
                used[j]=tmp;
                usedKey[j]=tp;
            }
            }
        }
            }
        }
        int m=0;
        for(i =0;i<k;i++)
       {
        if(used[i].getYear(usedKey[i])>0)
        {
        m++;
        str=used[i].getYear(usedKey[i])+"년 "+ used[i].getMonth(usedKey[i])+"월 "+used[i].getDay(usedKey[i])+"일 "+used[i].getStartTime(usedKey[i])+"시("+used[i].getEndTime(usedKey[i])+"시간), "+used[i].getNumberOfGuest(usedKey[i])+"명, "+used[i].getNumber()+"호";
        System.out.println(m+")"+str);
        }
       }
       int o =0;
       for(i =0;i<k;i++)
       {
       if(used[i].getYear(usedKey[i])==0)
       {
        o++;
       }
        }
        if(o==k)
        {
            System.out.println("취소할 예약이 없습니다.");
            continue;
        }
       System.out.print("취소할 예약을 선택하세요>");
        str=in.nextLine();
        if(str.equals("*"))
        {
            for(int p=0;p<k;p++)
            {
            for(i=0;i<wholeNum;i++)
            
                for(int j=0;j<conference[i].getReservation();j++)
                {
                    if(conference[i].getPhoneNum(j)==used[p].getPhoneNum(usedKey[p]))
                    {
                        if(conference[i].getYear(j)>0)
                        {
                        str=conference[i].getYear(j)+"년 "+conference[i].getMonth(j)+"월 "+conference[i].getDay(j)+"일 "+conference[i].getStartTime(j)+"시("+conference[i].getNumber()+"호), "+conference[i].getNumberOfGuest(j)+"명 예약이 취소되었습니다.";
                        System.out.println(str);
                        conference[i].setYear(j,0);
                        conference[i].setMonth(j,0);
                        conference[i].setDay(j,0);
                        conference[i].setStartTime(j,0);
                        conference[i].setEndTime(j,0);
                        }
                    }
                }
            }
        }
        else
        {int delete=Integer.valueOf(str)-1;
            for(i=0;i<wholeNum;i++)
            {
                for(int j=0;j<conference[i].getReservation();j++)
                {
                    if(conference[i].getPhoneNum(j)==used[delete].getPhoneNum(usedKey[delete]))
                    {
                        str=conference[i].getYear(j)+"년 "+conference[i].getMonth(j)+"월 "+conference[i].getDay(j)+"일 "+conference[i].getStartTime(j)+"시("+conference[i].getNumberOfGuest(j)+"명), "+conference[i].getNumber()+"호 예약이 취소되었습니다.";
                        System.out.println(str);
                        conference[i].setYear(j,0);
                        conference[i].setMonth(j,0);
                        conference[i].setDay(j,0);
                        conference[i].setStartTime(j,0);
                        conference[i].setEndTime(j,0);
                    }
                }
            }
        }
        }
        

 
    }
            //예약현황
        if(result[0].equals("u"))
        {
        room[] used =new room[10];
        int[] usedKey = new int [10];
        room tmp;
        int tp;
        int k=0; 
        for(i=0;i<wholeNum;i++)
        {
            for(int j=0;j<conference[i].getReservation();j++)
            {
                if(conference[i].getPhoneNum(j).equals(result[1]))
                {
                    used[k]=conference[i];
                    usedKey[k]=j;
                    k++;
                }
            }
        }
        if (k==0)
        {
        System.out.println("예약이 없습니다!");
        }
        else
        {
        for(i=0;i<k;i++)
        {
            for(int j=0;j<k;j++)
            if(used[i].getYear(usedKey[i])<used[j].getYear(usedKey[j]))
            {
    
                tmp =used[i];
                tp=usedKey[i];
                used[i]=used[j];
                usedKey[i]=usedKey[j];
                used[j]=tmp;
                usedKey[j]=tp;
            }
        }
        for(i=0;i<k;i++)
        {
            for(int j=0;j<k;j++)
            if(used[i].getYear(usedKey[i])==used[j].getYear(usedKey[j]))
            {
            if(used[i].getMonth(usedKey[i])<used[j].getMonth(usedKey[j]))
            {
                tmp =used[i];
                tp=usedKey[i];
                used[i]=used[j];
                usedKey[i]=usedKey[j];
                used[j]=tmp;
                usedKey[j]=tp;
            }
            }
        }
        for(i=0;i<k;i++)
        {
            for(int j=0;j<k;j++)
            if(used[i].getYear(usedKey[i])==used[j].getYear(usedKey[j]))
            {
            if(used[i].getMonth(usedKey[i])==used[j].getMonth(usedKey[j]))
            {
            if(used[i].getDay(usedKey[i])<used[j].getDay(usedKey[j]))
            {
                tmp =used[i];
                tp=usedKey[i];
                used[i]=used[j];
                usedKey[i]=usedKey[j];
                used[j]=tmp;
                usedKey[j]=tp;
            }
            }
            }
        }
        for(i=0;i<k;i++)
        {
            for(int j=0;j<k;j++)
            if(used[i].getYear(usedKey[i])==used[j].getYear(usedKey[j]))
            {
            if(used[i].getMonth(usedKey[i])==used[j].getMonth(usedKey[j]))
            {
                if(used[i].getDay(usedKey[i])==used[j].getDay(usedKey[j]))
                {
            if(used[i].getStartTime(usedKey[i])<used[j].getStartTime(usedKey[j]))
            {
                tmp =used[i];
                tp=usedKey[i];
                used[i]=used[j];
                usedKey[i]=usedKey[j];
                used[j]=tmp;
                usedKey[j]=tp;
            }
        }
            }
            }
        }
        int m=0;
        for(i =0;i<k;i++)
       {
        if(used[i].getYear(usedKey[i])>0)
        {
            m++;
        str=used[i].getYear(usedKey[i])+"년 "+ used[i].getMonth(usedKey[i])+"월 "+used[i].getDay(usedKey[i])+"일 "+used[i].getStartTime(usedKey[i])+"시("+used[i].getEndTime(usedKey[i])+"시간), "+used[i].getNumberOfGuest(usedKey[i])+"명, "+used[i].getNumber()+"호";
        System.out.println(m+")"+str);
        }
       }
       if(m==0)
       {
        System.out.println("예약이 없습니다!");
       }
        }
    }
    if(result[0].equals("m"))
    {
        int u=0;
        for(i=0;i<wholeNum;i++)
        {
            if(conference[i].getReservation()!=0)
            {
                u=1;
            }
        }
        if(u==1)
        {
            int roomNum=Integer.valueOf(result[1]);
            for(i=0;i<wholeNum;i++)
            {
            if(conference[i].getNumber()==roomNum)
            {
                if(conference[i].getReservation()==0)
                {
                    System.out.println("예약이 없습니다.");
                }
            }
            }
            int tp1;
            int tp2;
            int tp3;
            int tp4;
            int tp5;
            for(i=0;i<wholeNum;i++)
            {    if(conference[i].getReservation()>0)
                {
                for(int p=0;p<conference[i].getReservation();p++)
                {
                for(int j=0;j<conference[i].getReservation();j++)
                {
                if(conference[i].getYear(p)<conference[i].getYear(j))
                {
        
                    tp1 =conference[i].getYear(j);
                    tp2 =conference[i].getMonth(j);
                    tp3 =conference[i].getDay(j);
                    tp4 =conference[i].getStartTime(j);
                    tp5 =conference[i].getEndTime(j);
                    conference[i].setYear(j,conference[i].getYear(p));
                    conference[i].setMonth(j,conference[i].getMonth(p));
                    conference[i].setDay(j,conference[i].getDay(p));
                    conference[i].setStartTime(j,conference[i].getStartTime(p));
                    conference[i].setEndTime(j,conference[i].getEndTime(p));
                    conference[i].setYear(p,tp1);
                    conference[i].setMonth(p,tp2);
                    conference[i].setDay(p,tp3);
                    conference[i].setStartTime(p,tp4);
                    conference[i].setEndTime(p,tp5);
                }
            }
            }
            }
            
            }
            for(i=0;i<wholeNum;i++)
            {  if(conference[i].getReservation()>0)
                {
                for(int p=0;p<conference[i].getReservation();p++)
                {
                for(int j=0;j<conference[i].getReservation();j++)
                {
                if(conference[i].getYear(p)==conference[i].getYear(j))
                {
                if(conference[i].getMonth(p)<conference[i].getMonth(j))
                {
        
                    tp1 =conference[i].getYear(j);
                    tp2 =conference[i].getMonth(j);
                    tp3 =conference[i].getDay(j);
                    tp4 =conference[i].getStartTime(j);
                    tp5 =conference[i].getEndTime(j);
                    conference[i].setYear(j,conference[i].getYear(p));
                    conference[i].setMonth(j,conference[i].getMonth(p));
                    conference[i].setDay(j,conference[i].getDay(p));
                    conference[i].setStartTime(j,conference[i].getStartTime(p));
                    conference[i].setEndTime(j,conference[i].getEndTime(p));
                    conference[i].setYear(p,tp1);
                    conference[i].setMonth(p,tp2);
                    conference[i].setDay(p,tp3);
                    conference[i].setStartTime(p,tp4);
                    conference[i].setEndTime(p,tp5);
                }
            }
            }
        }
    }
            }
            for(i=0;i<wholeNum;i++)
            {  if(conference[i].getReservation()>0)
                {
                for(int p=0;p<conference[i].getReservation();p++)
                {
                for(int j=0;j<conference[i].getReservation();j++)
                {
                if(conference[i].getYear(p)==conference[i].getYear(j))
                {
                if(conference[i].getMonth(p)==conference[i].getMonth(j))
                {
                if(conference[i].getDay(p)<conference[i].getDay(j))
                {
        
                    tp1 =conference[i].getYear(j);
                    tp2 =conference[i].getMonth(j);
                    tp3 =conference[i].getDay(j);
                    tp4 =conference[i].getStartTime(j);
                    tp5 =conference[i].getEndTime(j);
                    conference[i].setYear(j,conference[i].getYear(p));
                    conference[i].setMonth(j,conference[i].getMonth(p));
                    conference[i].setDay(j,conference[i].getDay(p));
                    conference[i].setStartTime(j,conference[i].getStartTime(p));
                    conference[i].setEndTime(j,conference[i].getEndTime(p));
                    conference[i].setYear(p,tp1);
                    conference[i].setMonth(p,tp2);
                    conference[i].setDay(p,tp3);
                    conference[i].setStartTime(p,tp4);
                    conference[i].setEndTime(p,tp5);
                }
            }
        }
            }
        }
            }
            }
            for(i=0;i<wholeNum;i++)
            {
                if(conference[i].getReservation()>0)
                {
                for(int p=0;p<conference[i].getReservation();p++)
                {
                for(int j=0;j<conference[i].getReservation();j++)
                {
                if(conference[i].getYear(p)==conference[i].getYear(j))
                {
                if(conference[i].getMonth(p)==conference[i].getMonth(j))
                {
                    if(conference[i].getDay(p)==conference[i].getDay(j))
                    {
                if(conference[i].getStartTime(p)<conference[i].getStartTime(j))
                {
        
                    tp1 =conference[i].getYear(j);
                    tp2 =conference[i].getMonth(j);
                    tp3 =conference[i].getDay(j);
                    tp4 =conference[i].getStartTime(j);
                    tp5 =conference[i].getEndTime(j);
                    conference[i].setYear(j,conference[i].getYear(p));
                    conference[i].setMonth(j,conference[i].getMonth(p));
                    conference[i].setDay(j,conference[i].getDay(p));
                    conference[i].setStartTime(j,conference[i].getStartTime(p));
                    conference[i].setEndTime(j,conference[i].getEndTime(p));
                    conference[i].setYear(p,tp1);
                    conference[i].setMonth(p,tp2);
                    conference[i].setDay(p,tp3);
                    conference[i].setStartTime(p,tp4);
                    conference[i].setEndTime(p,tp5);
                }
            }
        }
    }
            }
        }
            }
            }
            for(i=0;i<wholeNum;i++)
            {
                if(conference[i].getNumber()==roomNum)
                {
                    for(int j=0;j<conference[i].getReservation();j++)
                    {
                        if(conference[i].getYear(j)>0)
                        {
                        str=conference[i].getYear(j)+"년 "+conference[i].getMonth(j)+"월 "+conference[i].getDay(j)+"일 "+conference[i].getStartTime(j)+"시("+conference[i].getEndTime(j)+"시간), "+conference[i].getNumberOfGuest(j)+"명 ,"+conference[i].getUserName(j)+", "+conference[i].getPhoneNum(j);
                        System.out.println(str);
                        }
                    }
                }
            }
        }
        else
        {
            System.out.println("예약이 없습니다!");
        }
    }

        //전체회의장소
        if(result[0].equals("a"))
        {
            int tp1;
            int tp2;
            int tp3;
            int tp4;
            int tp5;
            for(i=0;i<wholeNum;i++)
            {    if(conference[i].getReservation()>0)
                {
                for(int p=0;p<conference[i].getReservation();p++)
                {
                for(int j=0;j<conference[i].getReservation();j++)
                {
                if(conference[i].getYear(p)<conference[i].getYear(j))
                {
        
                    tp1 =conference[i].getYear(j);
                    tp2 =conference[i].getMonth(j);
                    tp3 =conference[i].getDay(j);
                    tp4 =conference[i].getStartTime(j);
                    tp5 =conference[i].getEndTime(j);
                    conference[i].setYear(j,conference[i].getYear(p));
                    conference[i].setMonth(j,conference[i].getMonth(p));
                    conference[i].setDay(j,conference[i].getDay(p));
                    conference[i].setStartTime(j,conference[i].getStartTime(p));
                    conference[i].setEndTime(j,conference[i].getEndTime(p));
                    conference[i].setYear(p,tp1);
                    conference[i].setMonth(p,tp2);
                    conference[i].setDay(p,tp3);
                    conference[i].setStartTime(p,tp4);
                    conference[i].setEndTime(p,tp5);
                }
            }
            }
            }
            
            }
            for(i=0;i<wholeNum;i++)
            {  if(conference[i].getReservation()>0)
                {
                for(int p=0;p<conference[i].getReservation();p++)
                {
                for(int j=0;j<conference[i].getReservation();j++)
                {
                if(conference[i].getYear(p)==conference[i].getYear(j))
                {
                if(conference[i].getMonth(p)<conference[i].getMonth(j))
                {
        
                    tp1 =conference[i].getYear(j);
                    tp2 =conference[i].getMonth(j);
                    tp3 =conference[i].getDay(j);
                    tp4 =conference[i].getStartTime(j);
                    tp5 =conference[i].getEndTime(j);
                    conference[i].setYear(j,conference[i].getYear(p));
                    conference[i].setMonth(j,conference[i].getMonth(p));
                    conference[i].setDay(j,conference[i].getDay(p));
                    conference[i].setStartTime(j,conference[i].getStartTime(p));
                    conference[i].setEndTime(j,conference[i].getEndTime(p));
                    conference[i].setYear(p,tp1);
                    conference[i].setMonth(p,tp2);
                    conference[i].setDay(p,tp3);
                    conference[i].setStartTime(p,tp4);
                    conference[i].setEndTime(p,tp5);
                }
            }
            }
        }
    }
            }
            for(i=0;i<wholeNum;i++)
            {  if(conference[i].getReservation()>0)
                {
                for(int p=0;p<conference[i].getReservation();p++)
                {
                for(int j=0;j<conference[i].getReservation();j++)
                {
                if(conference[i].getYear(p)==conference[i].getYear(j))
                {
                if(conference[i].getMonth(p)==conference[i].getMonth(j))
                {
                if(conference[i].getDay(p)<conference[i].getDay(j))
                {
        
                    tp1 =conference[i].getYear(j);
                    tp2 =conference[i].getMonth(j);
                    tp3 =conference[i].getDay(j);
                    tp4 =conference[i].getStartTime(j);
                    tp5 =conference[i].getEndTime(j);
                    conference[i].setYear(j,conference[i].getYear(p));
                    conference[i].setMonth(j,conference[i].getMonth(p));
                    conference[i].setDay(j,conference[i].getDay(p));
                    conference[i].setStartTime(j,conference[i].getStartTime(p));
                    conference[i].setEndTime(j,conference[i].getEndTime(p));
                    conference[i].setYear(p,tp1);
                    conference[i].setMonth(p,tp2);
                    conference[i].setDay(p,tp3);
                    conference[i].setStartTime(p,tp4);
                    conference[i].setEndTime(p,tp5);
                }
            }
        }
            }
        }
            }
            }
            for(i=0;i<wholeNum;i++)
            {
                if(conference[i].getReservation()>0)
                {
                for(int p=0;p<conference[i].getReservation();p++)
                {
                for(int j=0;j<conference[i].getReservation();j++)
                {
                if(conference[i].getYear(p)==conference[i].getYear(j))
                {
                if(conference[i].getMonth(p)==conference[i].getMonth(j))
                {
                    if(conference[i].getDay(p)==conference[i].getDay(j))
                    {
                if(conference[i].getStartTime(p)<conference[i].getStartTime(j))
                {
        
                    tp1 =conference[i].getYear(j);
                    tp2 =conference[i].getMonth(j);
                    tp3 =conference[i].getDay(j);
                    tp4 =conference[i].getStartTime(j);
                    tp5 =conference[i].getEndTime(j);
                    conference[i].setYear(j,conference[i].getYear(p));
                    conference[i].setMonth(j,conference[i].getMonth(p));
                    conference[i].setDay(j,conference[i].getDay(p));
                    conference[i].setStartTime(j,conference[i].getStartTime(p));
                    conference[i].setEndTime(j,conference[i].getEndTime(p));
                    conference[i].setYear(p,tp1);
                    conference[i].setMonth(p,tp2);
                    conference[i].setDay(p,tp3);
                    conference[i].setStartTime(p,tp4);
                    conference[i].setEndTime(p,tp5);
                }
            }
        }
    }
            }
        }
            }
            }
            for(i=0;i<wholeNum;i++)
            {
                str=conference[i].getNumber()+"호 ("+conference[i].getCapacity()+"명)";
                System.out.println(str);
                int m=0;
                for(int j=0;j<conference[i].getReservation();j++)
                {
                    if(conference[i].getYear(j)>0)
                    {
                        m++;
                    str=conference[i].getYear(j)+"년 "+ conference[i].getMonth(j)+"월 "+conference[i].getDay(j)+"일 "+conference[i].getStartTime(j)+"시("+conference[i].getEndTime(j)+"시간), "+conference[i].getNumberOfGuest(j)+"명, "+conference[i].getUserName(j)+","+conference[i].getPhoneNum(j);
                    System.out.println(m+") "+str);
                    }
                }
            }
           
        }
        //시스템종료
        if(result[0].equals("q"))
        {
            break;
        }
    }
    }
    
}
