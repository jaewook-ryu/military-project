import java.io.*;
import java.util.*;
import java.time.*;

public class ReadSoldierFile {
	/*
	 * This file reads all the ArmyBandSoldier information from input files, and
	 * stores it in the armyband37 arraylist. After the arraylit is read, it is
	 * stored as a stream. Only when there is an update to the file, will this
	 * filereader excute.
	 */

	private ArrayList<ArmyBandSoldier> data = new ArrayList<ArmyBandSoldier>();
	private LocalDate updateDate;

	public ReadSoldierFile() {
	}

	public ArrayList<ArmyBandSoldier> readFile(String filename) {
		try (BufferedReader reader = new BufferedReader(new FileReader("src/armyBand.txt"))) {
			this.readData(reader);
			return data;
		} catch (BadDataException e) {
			System.out.print(e.getMessage());
		} catch (IOException e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}

		return data;
	}

	private void readData(BufferedReader in) throws IOException {
		String firstLine = in.readLine();
		String date;

		if (firstLine.equals(null)) {
			throw new BadDataException("File is Empty");
		} else if (firstLine.contains("Updated") && firstLine.contains(":")) {
			try {
				String[] dates = firstLine.split(":");
				date = dates[1].trim();
				System.out.println(date);
				this.updateDate = LocalDate.parse(date);

			} catch (ArrayIndexOutOfBoundsException e) {
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println("Issue in update date");
			}

		} else {
			throw new BadDataException("File update date is faulty");
		}

		String line;
		int count = 0;
		String name = "";
		String entryDate = "";
		String specialty = "";
		String livingPost = "";

		// Now read names and relevant information
		while ((line = in.readLine()) != null) {

			if (line.isEmpty()) {
				count = 0;
			}

			try {
				if (count == 0) {
					// do nothing

				} else if (count == 1) {
					name = line.trim();

				} else if (count == 2) {
					entryDate = line.trim();

				} else if (count == 3) {
					specialty = line.trim();

				} else if (count == 4) {
					livingPost = line.trim();

					(this.data).add(new ArmyBandSoldier(name, entryDate, specialty, livingPost));
				}

				count++;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<ArmyBandSoldier> getSoldierData() {
		return this.data;
	}

	public void printSoldierData() {
		for (ArmyBandSoldier a : this.data) {
			System.out.println(a);
		}
	}

	public void saveObjectStream() {
		try {
			FileOutputStream fos = new FileOutputStream("ArmyBandStream");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(this.data);

			oos.close();
		}

		catch (Exception e) {
			System.out.println("Error in saving output stream");
		}
	}

	public void loadObjectStream() {
		try {
			FileInputStream fis = new FileInputStream("ArmyBandStream");
			ObjectInputStream ois = new ObjectInputStream(fis);

			this.data = (ArrayList<ArmyBandSoldier>) ois.readObject();
			ois.close();
		}

		catch (Exception e) {
			System.out.println("Error");
		}
	}

}