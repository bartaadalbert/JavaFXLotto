package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.*;

public class Controller implements Initializable {
    //<editor-fold desc="Variables">
    final int MAX=59;
    final int MIN=1;

    private int textnum1;
    private int textnum2;
    private int textnum3;
    private int textnum4;
    private int textnum5;
    //</editor-fold>

    //<editor-fold desc="FXML anotations">
   @FXML
    Pane basePane;
    @FXML
    Pane alertPane;
    @FXML
    Label alertLabel;
    @FXML
    Label checkLabel;
    @FXML
    Label getNum1;
    @FXML
    Label getNum2;
    @FXML
    Label getNum3;
    @FXML
    Label getNum4;
    @FXML
    Label getNum5;
    @FXML
    TextField setNum1;
    @FXML
    TextField setNum2;
    @FXML
    TextField setNum3;
    @FXML
    TextField setNum4;
    @FXML
    TextField setNum5;
    //</editor-fold>


    /**
     * @param event

     */
    @FXML
    private void alertOK(ActionEvent event){
        alertPane.setVisible(false);
        basePane.setOpacity(1);
        basePane.setDisable(false);
    }

   @FXML
   private void click(ActionEvent event){

    ArrayList<Integer> ranres= randomArray();
       System.out.println(ranres);
    Set<Integer> neznayu=new HashSet<>();
    if (calculate()!=null) {
        neznayu.add(ranres.get(0));
        neznayu.add(ranres.get(1));
        neznayu.add(ranres.get(2));
        neznayu.add(ranres.get(3));
        neznayu.add(ranres.get(4));
        neznayu.addAll(ranres);
        neznayu.addAll(calculate());

        resultCheck(neznayu.size());
    }
        getNum1.setText(""+ranres.get(0));
        getNum2.setText(""+ranres.get(1));
        getNum3.setText(""+ranres.get(2));
        getNum4.setText(""+ranres.get(3));
        getNum5.setText(""+ranres.get(4));

}
/** dfdsgfdsfdsfdsfdsfdsfsfsdfdsfdsfsdfds*/
private ArrayList<Integer> randomArray(){
       ArrayList<Integer> my =new ArrayList<>();
       for (int i=1; i<=MAX; i++){
           my.add(i);
       }
    Random random =new Random();
       ArrayList<Integer> arr =new ArrayList<>();
       for (int i=0; i<5; i++){
          // int x=
           arr.add( my.remove(random.nextInt(my.size())));
       }

    return arr;
}


public void initialize(URL url, ResourceBundle resourceBundle){
    System.out.println("1raz");
    DB db= new DB();

}

private ArrayList<Integer> calculate() {
    try {
        textnum1 = Integer.parseInt(setNum1.getText());
        textnum2 = Integer.parseInt(setNum2.getText());
        textnum3 = Integer.parseInt(setNum3.getText());
        textnum4 = Integer.parseInt(setNum4.getText());
        textnum5 = Integer.parseInt(setNum5.getText());
    } catch (Exception e) {
        // System.err.println(e);}
        alertWindow("fill the empty boxes!!!!");
        return null;
    }

//    if (textnum1<MIN || textnum1>MAX || textnum2<MIN || textnum2>MAX || textnum3<MIN || textnum3>MAX || textnum4<MIN || textnum4>MAX || textnum5<MIN || textnum5>MAX){
//        alertWindow("The numbers out of bounds");
//        return;
//    }

    Set<Integer> numbers= new HashSet<>();
    numbers.add(textnum1);
    numbers.add(textnum2);
    numbers.add(textnum3);
    numbers.add(textnum4);
    numbers.add(textnum5);



    ArrayList<Integer> userNumbers= new ArrayList<>(numbers);
    for (Integer numb: userNumbers
    ) {
        if (numb<MIN||numb>MAX){
            alertWindow("The numbers out of bounds");
        }
    }if (numbers.size()<5){
        alertWindow("set different numbers");
        return null;
    }
return userNumbers;

}

private void alertWindow(String a){
    alertPane.setVisible(true);
    alertLabel.setText(a);
    basePane.setOpacity(0.3);
    basePane.setDisable(true);
}

private void resultCheck(int a){
    switch (a){
        case 10:
            checkLabel.setText("you guess 0 numbers");
            break;
        case 9:
            checkLabel.setText("you guess 1 numbers");
            break;
        case 8:
            checkLabel.setText("you guess 2 numbers");
            break;
        case 7:
            checkLabel.setText("you guess 3 numbers");
            break;
        case 6:
            checkLabel.setText("you guess 4 numbers");
            break;
        case 5:
            checkLabel.setText("you guess 5 numbers");
            break;
    }
}

}
