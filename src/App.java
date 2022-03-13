public class App {
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

    }



}
