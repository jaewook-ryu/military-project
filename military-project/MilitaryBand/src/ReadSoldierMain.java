import java.util.*;


public class ReadSoldierMain
{
    public static void main(String [] args)
    {
        
        ReadSoldierFile soldierReader = new ReadSoldierFile();
        soldierReader.readFile("armyBand.txt");
        
        ArrayList<ArmyBandSoldier> a = new ArrayList<ArmyBandSoldier>();
        
        //soldierReader.printSoldierData();
        
        a = soldierReader.getSoldierData();
        
        ArmyBandSoldier b = a.get(1);
        System.out.println(b);
        System.out.println(b.getEntryDate());
        System.out.println(b.getEndDateString());
        System.out.println(b.getPercentage());

        soldierReader.saveObjectStream();
        
        ReadSoldierFile datFromStream = new ReadSoldierFile();
        datFromStream.loadObjectStream();
        
        System.out.println("testing streams");
        ArrayList<ArmyBandSoldier> a2 = new ArrayList<ArmyBandSoldier>();
        a2 = datFromStream.getSoldierData();
        
        ArmyBandSoldier c = a2.get(1);
        System.out.println(c);
        System.out.println(c.getEntryDate());
        System.out.println(c.getEndDateString());
        System.out.println(c.getPercentage());
        
    
    }
}