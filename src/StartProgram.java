import java.util.List;
import java.util.Scanner;
import controller.MuscleCarHelper;
import model.MuscleCar;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static MuscleCarHelper mch = new MuscleCarHelper();

		private static void addAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter the make: ");
			String make = in.nextLine();
			System.out.print("Enter the model: ");
			String model = in.nextLine();
			System.out.print("Enter the year: ");
			int year = in.nextInt();	
			System.out.print("Enter the exterior color: ");
			String exteriorColor = in.next();
			System.out.print("Enter the 0 to 60 MPH time: ");
			double zeroToSixtyTime = in.nextDouble();
			MuscleCar toAdd = new MuscleCar(make, model, year, zeroToSixtyTime, exteriorColor);
			mch.insertItem(toAdd);
		}

		private static void deleteAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter the make: ");
			String make = in.nextLine();
			System.out.print("Enter the model: ");
			String model = in.nextLine();
			System.out.print("Enter the exterior color: ");
			String exteriorColor = in.next();
			System.out.print("Enter the year: ");
			int year = in.nextInt();
			System.out.print("Enter the 0 to 60 MPH time: ");
			double zeroToSixtyTime = in.nextDouble();
			MuscleCar toDelete = new MuscleCar(make, model, year, zeroToSixtyTime, exteriorColor);
			mch.deleteItem(toDelete);
		}

		private static void editAnItem() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Make");
			System.out.println("2 : Search by Model");
			System.out.println("3 : Search by Year");
			System.out.println("4 : Search by Exterior Color");
			System.out.println("5 : Search by 0 to 60 MPH Time");
			int searchBy = in.nextInt();
			in.nextLine();
			List<MuscleCar> foundItems;
			if (searchBy == 1) {
				System.out.print("Enter the make: ");
				String make = in.nextLine();
				foundItems = mch.searchForCarByMake(make);
			} else if (searchBy == 2) {
				System.out.print("Enter the model: ");
				String model = in.nextLine();
				foundItems = mch.searchForCarByModel(model);
			} else if (searchBy == 3) {
				System.out.print("Enter the year: ");
				int year = in.nextInt();
				foundItems = mch.searchForCarByYear(year);
			} else if (searchBy == 4) {
				System.out.print("Enter the exterior color: ");
				String color = in.nextLine();
				foundItems = mch.searchForCarByColor(color);
			} else {
				System.out.print("Enter the model: ");
				double ZeroToSixtyTime = in.nextDouble();
				foundItems = mch.searchForCarByZeroToSixtyTime(ZeroToSixtyTime);
			}
				

			if (!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (MuscleCar l : foundItems) {
					System.out.println(l.getId() + " : " + l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				MuscleCar toEdit = mch.searchForItemById(idToEdit);
				System.out.println("Retrieved " + toEdit.getExteriorColor() + " " + toEdit.getYear()
				+ " " + toEdit.getMake() + " " + toEdit.getModel()
				+ " with a 0 to 60 MPH time of " + toEdit.getZeroToSixtyTime() + " seconds.");
				System.out.println("1 : Update Make");
				System.out.println("2 : Update Model");
				System.out.println("3 : Update Year");
				System.out.println("4 : Update Exterior Color");
				System.out.println("5 : Update 0 to 60 MPH time");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Make: ");
					String newMake = in.nextLine();
					toEdit.setMake(newMake);
				} else if (update == 2) {
					System.out.print("New Model: ");
					String newModel = in.nextLine();
					toEdit.setModel(newModel);
				} else if (update == 3) {
					System.out.print("New Year: ");
					int newYear = in.nextInt();
					toEdit.setYear(newYear);
				} else if (update == 4) {
					System.out.print("New Exterior Color: ");
					String newExteriorColor = in.nextLine();
					toEdit.setModel(newExteriorColor);
				} else if (update == 5) {
					System.out.print("New 0 to 60 MPH time: ");
					double newZeroToSixtyTime = in.nextDouble();
					toEdit.setZeroToSixtyTime(newZeroToSixtyTime);
				}

				mch.updateItem(toEdit);

			} else {
				System.out.println("---- No results found");
			}
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			while (goAgain) {
				System.out.println("*  Select an item:");
				System.out.println("*  1 -- Add an item");
				System.out.println("*  2 -- Edit an item");
				System.out.println("*  3 -- Delete an item");
				System.out.println("*  4 -- View the list");
				System.out.println("*  5 -- Exit the program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAnItem();
				} else if (selection == 2) {
					editAnItem();
				} else if (selection == 3) {
					deleteAnItem();
				} else if (selection == 4) {
					viewTheList();
				} else {
					mch.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			List<MuscleCar> allItems = mch.showAllItems();			
			for(MuscleCar singleItem : allItems) {
				System.out.println(singleItem.returnCarDetails());
			}
		}

	}
