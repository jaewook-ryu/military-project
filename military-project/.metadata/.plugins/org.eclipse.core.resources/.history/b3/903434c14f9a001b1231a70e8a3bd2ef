import java.io.Serializable;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Soldier implements Serializable
{
    private String name;
    
    // Parameters for rank
    private String rank;
    private int rankFlag = 0;
    private ArrayList<String> rankFlagReason = new ArrayList<String>();
    
    // LocalDate objects, mm-dd-yyyy format
    private LocalDate entryDate;
    private LocalDate endDate;
    private int totalService;
    
    // Living post
    private String livingPost;
    
    // Constructors!     
    public Soldier()
    {
        //empty constructor;
    }
    
    public Soldier(String name)
    {
        this.name = name;
    }
    
    public Soldier(String name, String entryDateString)
    {
        this.name = name;
        this.entryDate = LocalDate.parse(entryDateString);
        this.endDate = this.calculateEndDate(entryDateString);
        this.totalService = this.calculateTotalService(entryDateString);
        this.rank = this.calculateRank(this.rankFlag);
    }
    
    private LocalDate calculateEndDate(String entryDateString)
    {
        // 18개월 기준으로 계산한 값
        return ((LocalDate.parse(entryDateString)).plusMonths(18)).minusDays(1);
    }
        
    private int calculateTotalService(String entryDateString)
    {    
        return (int)(LocalDate.parse(entryDateString).until(this.calculateEndDate(entryDateString), ChronoUnit.DAYS));
    }
    
    // Methods for calculating rank
    public void updateRank()
    {
        this.rank = calculateRank(this.rankFlag);
    }
    
    private String calculateRank(int rankFlag)
    {
        int year, month;
        long monthServed;
        
        year = (this.entryDate).getYear();
        month = (this.entryDate).getMonthValue();
        
        LocalDate today = LocalDate.now();
        LocalDate entryDateComp = LocalDate.of(year, month, 1);
        
        
        if(entryDate.getDayOfMonth() != 1)
        {
            monthServed = entryDateComp.until(today, ChronoUnit.MONTHS);
        }
        else
        {
            monthServed = (this.entryDate).until(today, ChronoUnit.MONTHS);
        }
        
        if(monthServed >= 15 - this.rankFlag)
            return "병장";
        else if(monthServed >= 9 - this.rankFlag)
            return "상병";
        else if (monthServed >= 3 - this.rankFlag)
            return "일병";
        else
            return "이병";
    }
    
    // Method to calculate percentage completed
    public double getPercentage()
    {
        LocalDate today = LocalDate.now();
        long timeServed = (this.entryDate).until(today, ChronoUnit.DAYS);
        
        return ((double)timeServed)/this.totalService*100;
    }
    
    // Mutator Methods
    public void setEntryDate(String entryDate)
    {
        this.entryDate = LocalDate.parse(entryDate);
    }
    
    public void setEndDate(String endDate)
    {
        this.endDate = LocalDate.parse(endDate);
    }
    
    public void setRank(String rank)
    {
        this.rank = rank;
    }
    
    public void setRankFlag(int rankFlag)
    {
        this.rankFlag += rankFlag;
    }
    
    public void setRankFlag(int rankFlag, String reason)
    {
        this.rankFlag += rankFlag;
        
        if(this.rankFlagReason.size() == 0)
        {
            this.rankFlagReason = new ArrayList<String>();
            this.rankFlagReason.add(reason);
        }
        
        this.rankFlagReason.add(reason);
    }
    
    public void setLivingPost(String livingPost)
    {
        this.livingPost = livingPost;
    }
    
    
    // toString and compareTo
    public String toString()
    {
        String tempString;
        tempString = this.rank + ' ' + this.name;
        
        return tempString;
    }
    
    public int compareTo(Soldier a)
    {
        return (this.entryDate).compareTo(a.entryDate);
    }
    
    // Public accessor methods
    public String getName()
    {
        return this.name;
    }
    
    public String getEntryDateString()
    {
        return (this.entryDate).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
    
    public LocalDate getEntryDate()
    {
        return this.entryDate;
    }
    
    public String getEndDateString()
    {
        return (this.endDate).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
    
    public LocalDate getEndDate()
    {
        return this.endDate;
    }
    
    public int getTotalService()
    {
        return this.totalService;
    }
    
    public String getRank()
    {
        return this.rank;
    }
    
    public String getLivingPost()
    {
        return this.livingPost;
    }
    
}