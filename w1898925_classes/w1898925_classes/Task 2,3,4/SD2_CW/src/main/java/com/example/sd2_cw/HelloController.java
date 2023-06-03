package com.example.sd2_cw;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController extends passenger {

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
       mainMethod();
    }

    @FXML
    protected void viewWaitingList(){
        String one="" , two="", three="", four="", five="", six="";
        for (int i=0; i< count1; i++){
            one = one + (queue1[i].getfName() +" "+ queue1[i].getsName()+"\n");
        }
//        for (int i=0; i< count2; i++){
//            two = two + (queue2[i].getfName() +" "+ queue2[i].getsName()+"\n");
//        }
//        for (int i=0; i< count3; i++){
//            three = three + (queue3[i].getfName() +" "+ queue3[i].getsName()+"\n");
//        }
//        for (int i=0; i< count4; i++){
//            four = four + (queue4[i].getfName() +" "+ queue4[i].getsName()+"\n");
//        }
//        for (int i=0; i< count5; i++){
//            five = five + (queue5[i].getfName() +" "+ queue5[i].getsName()+"\n");
//        }
        for (int i=0; i< count6; i++){
            six = six + (waitingQueue[i].getfName() +" "+ waitingQueue[i].getsName()+"\n");
        }
        welcomeText.setText("QUEUE 1:\n" + one + " \n" + "QUEUE 2:\n" + two + " \n" + "QUEUE 3:\n" + three + " \n" + "QUEUE 4:\n" + four + " \n" + "QUEUE 5:\n" + five + " \n" + "WAITING QUEUE:\n" + six);
    }
}