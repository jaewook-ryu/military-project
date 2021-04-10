public class ArmyBandSoldier extends Soldier
{
    private String specialty;
    private int bedPosition = 0; // 생활관 침대 위치

    public ArmyBandSoldier(String name){
        super(name);
    }
    
    public ArmyBandSoldier(String name, String entryDate)
    {
        super(name, entryDate);
    }
    
    public ArmyBandSoldier(String name, String entryDate, String specialty)
    {
        super(name, entryDate);
        this.specialty = specialty;
    }
    
    public ArmyBandSoldier(String name, String entryDate, String specialty, String livingPost)
    {
        super(name, entryDate);
        this.specialty = specialty;
        this.setLivingPost(livingPost);
    }
    
    
    public String toString()
    {
        String tempString;
        tempString = this.getRank() + " " + this.getName() + '\n' + this.getSpecialty();

        return tempString;
    }
    
    
    public void setSpecialty(String specialty)
    {
        this.specialty = specialty;
    }
    
    public void setBedPosition(int bedPosition)
    {
        this.bedPosition = bedPosition;
    }
    
    public String getSpecialty()
    {
        return this.specialty;
    }
    
    public int getBedPosition()
    {
        return this.bedPosition;
    }
}