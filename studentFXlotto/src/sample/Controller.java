package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.*;

public class Controller implements Initializable {
    private final int MAX=49;
    private final int MIN=1;
   // private String a="";


    private int selnum1;
    private int selnum2;
    private int selnum3;
    private int selnum4;
    private int selnum5;

   //private ;

    //<editor-fold desc="FXML elements import">
    @FXML
    Label     lset1;
    @FXML
    Label     lset2;
    @FXML
    Label     lset3;
    @FXML
    Label     lset4;
    @FXML
    Label     lset5;
    @FXML
    TextField tget1;
    @FXML
    TextField tget2;
    @FXML
    TextField tget3;
    @FXML
    TextField tget4;
    @FXML
    TextField tget5;
    @FXML
    Label alertLabel;
    @FXML
    Button alertButton;
    @FXML
    Pane basePane;
    @FXML
    Pane alertPane;
    @FXML
    Label checkLabel;
    //</editor-fold>

    @FXML
    private void alertAction(){
        alertPane.setVisible(false);
        basePane.setOpacity(1);
        basePane.setDisable(false);
       // alertLabel.setText(alertTextGen(a));

    }

@FXML
private void action(){
    textCheck();
    ArrayList<Integer>  arr1= randomNumbers();


    if (textCheck()!=null){
        HashSet<Integer> resnumbers= new HashSet<>();
        resnumbers.addAll(arr1);
        resnumbers.addAll(textCheck());
        checkResult(resnumbers.size());
    }


    lset1.setText(""+arr1.get(0));
    lset2.setText(""+arr1.get(1));
    lset3.setText(""+arr1.get(2));
    lset4.setText(""+arr1.get(3));
    lset5.setText(""+arr1.get(4));
}

    /**
     * @return random number
     */

@Override
public void initialize(URL url, ResourceBundle resourceBundle){
    System.out.println("hi");
    DB db=new DB();

}

    /**
     * @return random ArrayList with 5 random numbers!!!
     */
private ArrayList<Integer> randomNumbers(){

    ArrayList<Integer> my= new ArrayList<>();
    for (int i=MIN; i<=MAX; i++){
        my.add(i);
    }
    Random ran = new Random();
    ArrayList<Integer> arr= new ArrayList<>();
    for(int i = 0; i < 5; i++){
        int x = my.remove(ran.nextInt(my.size()));
       // System.out.print(" "+x);
        arr.add(x);

    }
        return arr;
 }

public ArrayList<Integer> textCheck(){
     try {
         selnum1= Integer.parseInt(tget1.getText());
         selnum2= Integer.parseInt(tget2.getText());
         selnum3= Integer.parseInt(tget3.getText());
         selnum4= Integer.parseInt(tget4.getText());
         selnum5= Integer.parseInt(tget5.getText());
     }catch (Exception e){
         alert("You need write numbers"+"\n"+ "on empty fields!!!");
         return null;
     }

    HashSet<Integer> numbers = new HashSet<>();
     numbers.add(selnum1);
     numbers.add(selnum2);
     numbers.add(selnum3);
     numbers.add(selnum4);
     numbers.add(selnum5);


     ArrayList<Integer> getnumbers= new ArrayList<>(numbers);
    for (Integer num: getnumbers
         ) {
        if (num<MIN || num>MAX){
            alert("The numbers between 1 and 49");
        }
    }
    if (numbers.size()<5){
        alert("The numbers can be uniq!!!");
        return null;
    }
    return getnumbers;


}

private void alert(String a){
    alertPane.setVisible(true);
    basePane.setOpacity(0.3);
    basePane.setDisable(true);
    alertLabel.setText(a);
}

//private void resultCheck(ArrayList<Integer> v){
//    int result=0;
//    for(int i=0; i<v.size(); i++){
//        if (v.get(i) == arr1.get(0) || v.get(i) ==arr1.get(1) || v.get(i) ==arr1.get(2) || v.get(i) ==arr1.get(3) || v.get(i) ==arr1.get(4) ){
//            result++;
//        }
//
//    }
//    switch (result){
//        case 0:
//            System.out.println("jhfjsdfjhdsf");
//        break;
//        case 1:
//            System.out.println("talalt 1");
//            break;
//        case 2:
//            System.out.println("talalt 2");
//    }
//
//}

    private void checkResult(int a){
        switch (a){
            case 10:
                checkLabel.setText("Nem nyert");
                break;
            case 9:
                checkLabel.setText("talalt 1");
                break;
            case 8:
                checkLabel.setText("talalt 2");
                break;
            case 7:
                checkLabel.setText("talalt 3");
                break;
            case 6:
                checkLabel.setText("talalt 4");
                break;
            case 5:
                checkLabel.setText("talalt 5");
                break;
            default:
                System.out.println("write numbers");
                break;
        }
    }

}
