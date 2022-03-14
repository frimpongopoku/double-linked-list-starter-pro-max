import sun.tools.java.Environment;

public class App {
    InputHelper helper = new InputHelper();
    StudentList list = new StudentList();

    public static void main(String[] args) throws Exception {

        //--- Testing IDisplayable class
//        TestingIDisplayable displayer = new TestingIDisplayable();
//        displayer.display();

        //-- Testing Student class
//        Student student = new Student("Mobi Dick","full-time");
//        student.display();


        //--- Testing StudentList display
        StudentList list = new StudentList(); // Dont comment this part out, all the parts below for testing depend on this
        list.createDummyList(); // Dont comment this part out, all the parts below for testing depend on this
//        list.display(); // Test list display
//
        //---- Testing StudentList insertion
//        Student newStudent = new Student("Sunday Guy","part-time",23);
//        list.insert(new Node(newStudent),1);
//        list.display(); Testing what list looks like after insertion

        //---- Testing StudentList item deletion with position
        list.delete(0); // "Monday Guy" should be removed after here
//        list.display();


        // --- Testing StudentList find with studentId
//            Student found = list.findById(2);
//            if(found != null) found.display(); // "Tuesday Guy" should be printed here
//            else System.out.println("Sorry, could not find any user with that Id");

        // --- Testing StudentList find with studentName
//        Student found = list.findByName("Wednesday Guy");
//        if(found != null) found.display(); // "Wednesday Guy" should be printed here
//        else System.out.println("Sorry, could not find any user with that Name");

        // --- Testing StudentList saving to file
//        list.saveToFile("first-file.txt");
//        ------------------ Remove parts for testing code after you have copied the content of the console into a document like the assignment says -----

        //-------------- APP BEGINNING HERE --------------
        App app = new App();
        System.out.println("Welcome to the student admin work book.\nPlease choose an option from the menu displayed below");
        app.launchMenu();

    }

    public void launchMenu() {

        System.out.print("\nA. Add Student");
        System.out.print("\tB. Find Student By Id");
        System.out.print("\tC. Find Student By Name");
        System.out.print("\tD. Display Students");
        System.out.print("\nE. Load Students From File");
        System.out.print("\tQ. Quit\n");

        char character = helper.readCharacter("Enter menu option", "ABCDEFQ");
        switch (character) {
            case 'A': {
                addStudent();
                break;
            }
            case 'B': {
                findStudentById();
                break;
            }
            case 'C': {
                findStudentByName();
                break;
            }
            case 'D': {
                displayStudents();
                break;
            }
            case 'E': {
                loadStudentsFromFile();
                break;
            }
            case 'Q': {
                quit();
                break;
            }
        }

    }

    public void addStudent() {
        String name = helper.readString("Name of new student");
        String cat = helper.readString("Student enrollment type(full-time/part-time)");
        Student student = new Student(name, cat, list.length+1);
        list.add(new Node(student));
        launchMenu();
    }

    public void findStudentById() {
        int id = helper.readInt("Whats the ID of the student you are looking for?");
        Student student = list.findById(id);
        if (student == null) System.out.println("Sorry, could not find student with this ID");
        else student.display();
        launchMenu();
    }

    public void findStudentByName() {
        String name = helper.readString("Whats the name of the student you are looking for?");
        Student student = list.findByName(name);
        if (student == null) System.out.println("Sorry, could not find student with this name");
        else student.display();
        launchMenu();
    }

    public void displayStudents() {
        list.display();
        launchMenu();
    }

    public void loadStudentsFromFile() {

    }

    public void quit() {
        if (list.length > 0) {
            String filename = helper.readString("How should we save your list? (Filename)");
            if (filename.isEmpty()) filename = "New-save.txt";
            list.saveToFile(filename);
            System.out.println(String.format("Your file has been saved as %s. Thanks for using the student admin work book, see you soon!", filename));
        }
    }


}
