//public class Main {
//    public static void main(String[] args) {
//        ERyder bike1 = new ERyder("B001",80,true,120);
//        bike1.printBikeDetails();
//        System.out.println("----------------------------------");
//
//        ERyder bike2 = new ERyder("B001", 75, true, 123.45);
//        bike2.ride();
//        bike2.printBikeDetails();
//    }
//}
//public class Main {
//    public static void main(String[] args)  throws Exception {
//        String sent1 = "I was very satisfied with the service.";
//        String sent2 = "The e-Bike is quite comfortable to ride.";
//        String sent3 = "The battery life of the e-Bike is impressive.";
//        String sent4 = "The customer support was helpful and responsive.";
//        String sent5 = "I would recommend this e-Bike to my friends and family.";
//        Feedback feedback = new Feedback("John", "Walker", "3422278532@qq.com");
//        feedback.analyzeFeedback(false, sent1, sent2, sent3, sent4, sent5);
//        System.out.println(feedback);
//    }
//}

//public class Main {
//    public static void main(String[] args) {
//        ERyder bike1 = new ERyder("B001",80,true,150);
//        ERyder bike2 = new ERyder("B002",75,false,120,"user_john",1234567);
//
//        bike1.printRideDetails(25);
//        System.out.println("----------------------------------");
//        bike2.printRideDetails(35);
//    }
//}

import java.util.Scanner;

//public class Main {
//    public class uMain {
//        public static void main(String[] args) {
//            UserRegistration userRegistration = new UserRegistration();
//            userRegistration.registration();
//            System.out.println(userRegistration);
//        }
//    }
//}

public class Main {
    public static void main(String[] args) {
        AdminPanel adminPanel = new AdminPanel();
        adminPanel.userManagementOptions();
    }
}