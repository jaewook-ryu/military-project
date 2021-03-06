import java.io.*;
import java.util.*;
import java.time.*;

public class TestSoldier {
	public static void main(String[] args) {

		ArrayList<ArmyBandSoldier> armyBand37 = new ArrayList<ArmyBandSoldier>();

		// Test Output streams.
		try {
			FileOutputStream fos = new FileOutputStream("p");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(LocalDateTime.now().toString());
			oos.writeObject(armyBand37);

			oos.close();
		}

		catch (Exception e) {
			System.out.println("Error");
		}

		ArrayList<ArmyBandSoldier> armyBand37Input = new ArrayList<ArmyBandSoldier>();
		String time = null;

		try {
			FileInputStream fis = new FileInputStream("p");
			ObjectInputStream ois = new ObjectInputStream(fis);
			time = (String) ois.readObject();
			armyBand37Input = (ArrayList<ArmyBandSoldier>) ois.readObject();
			ois.close();
		}

		catch (Exception e) {
			System.out.println("Error");
		}

		for (ArmyBandSoldier a : armyBand37Input)
			System.out.println(a);

	}
}