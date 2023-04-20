package lk.ijse.prabhash.orm.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.prabhash.orm.bo.BOFactory;
import lk.ijse.prabhash.orm.bo.custom.PendingKeyMoneyBO;
import lk.ijse.prabhash.orm.dto.CustomDTO;
import lk.ijse.prabhash.orm.view.tm.CustomTM;
import lombok.SneakyThrows;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class PendingKeyMoneyFormController implements Initializable {
   /* public TableView <CustomTM>tblReservation;*/
    public JFXTextField txtStudentId;
    public JFXComboBox<String> cmbPaymentStatus;
    public JFXButton btnUpdate;
    public JFXTextField txtDate;
    public JFXTextField txtName;
    public TableColumn colReservationId;
    public TableColumn colStudentId;
    public TableColumn colName;
    public TableColumn colDate;
    public TableColumn colPaymentStatus;
    public JFXTextField txtReservationId;
    final private PendingKeyMoneyBO pendingKeyMoneyBO = (PendingKeyMoneyBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.PENDINGKEYMONEY);
    public TableColumn colType;
    public TableColumn colRoomTypeId;
    public TableColumn colKeyMoney;
    public JFXTextField txtType;
    public JFXTextField txtRoomTypeId;
    public JFXTextField txtKeyMoney;
    public TableView  <CustomTM>tblReservation;



    @SneakyThrows
    @Override

    public void initialize(URL location, ResourceBundle resources){
        loadAllData();
        setCellValueFactory();

     colReservationId.setCellValueFactory(new PropertyValueFactory<>("res_id"));
        colStudentId.setCellValueFactory(new PropertyValueFactory<>("student_id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colRoomTypeId.setCellValueFactory(new PropertyValueFactory<>("room_type_id"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colKeyMoney.setCellValueFactory(new PropertyValueFactory<>("key_money"));
        colPaymentStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        cmbPaymentStatus.getItems().addAll("Paid","Paid Later");

tblReservation.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->{
    btnUpdate.setDisable(newValue == null);


    if (newValue != null){
        txtReservationId.setText(newValue.getRes_id());
        txtStudentId.setText(newValue.getStudent_id());
        txtName.setText(newValue.getName());
        txtRoomTypeId.setText(newValue.getRoom_type_id());
        txtType.setText(newValue.getType());
        System.out.println("waduna");
        txtKeyMoney.setText(String.valueOf(newValue.getKey_money()));
        cmbPaymentStatus.setValue(newValue.getType());
        txtDate.setText(String.valueOf(newValue.getDate()));
    }
        });
  /*      tblReservation.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {*/


/*
            if (newValue!= null){
                txtReservationId.setText(newValue.getRes_id());
                txtName.setText(newValue.getName());
                txtRoomTypeId.setText(newValue.getRoom_type_id());
                txtStudentId.setText(newValue.getStudent_id());
                txtType.setText(newValue.getType());
                txtKeyMoney.setText(String.valueOf(newValue.getKey_money()));
                cmbPaymentStatus.setValue(newValue.getStatus());
                txtDate.setText(String.valueOf(newValue.getDate()));
            }
        });

        cmbPaymentStatus.getItems().addAll("Paid","Paid Later");
*/

    }


    private void setCellValueFactory() {
        colReservationId.setCellValueFactory(new PropertyValueFactory("resID"));
        colStudentId.setCellValueFactory(new PropertyValueFactory("studentID"));
        colName.setCellValueFactory(new PropertyValueFactory("name"));
        colRoomTypeId.setCellValueFactory(new PropertyValueFactory("roomTypeID"));
        colType.setCellValueFactory(new PropertyValueFactory("type"));
        colKeyMoney.setCellValueFactory(new PropertyValueFactory("keyMoney"));
        colPaymentStatus.setCellValueFactory(new PropertyValueFactory("status"));
        colDate.setCellValueFactory(new PropertyValueFactory("date"));

    }

    private void loadAllData() throws Exception {
       try {


            List<CustomDTO>allCus=pendingKeyMoneyBO.getAllPendingKeyMoneyReservationsUsingReservationStatus();
            for (CustomDTO dto:allCus) {
                tblReservation.getItems().add(
            new CustomTM(dto.getRes_id(),dto.getStudent_id(),dto.getName(),dto.getRoom_type_id(),dto.getType(),dto.getKey_money(),dto.getStatus(),dto.getDate())

                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

   /*   tblReservation.setItems(FXCollections.observableArrayList(pendingKeyMoneyBO.getAllPendingKeyMoneyReservationsUsingReservationStatus().stream().map(dto -> {
            return new CustomTM(dto.getRes_id(),dto.getStudent_id(),dto.getName(),dto.getRoom_type_id(),dto.getType(),dto.getKey_money(),dto.getStatus(),dto.getDate());
        }).collect(Collectors.toList())));*/


}

    public void btnUpdateOnAction(ActionEvent actionEvent) {

        try {
            boolean b = pendingKeyMoneyBO.updateReservationUsingId(txtReservationId.getText(), String.valueOf(cmbPaymentStatus.getValue()));
            if (b=true){
             loadAllData();
                new Alert(Alert.AlertType.CONFIRMATION,"Updated").show();
            }
            tblReservation.getItems().remove(tblReservation.getSelectionModel().getSelectedItem());



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnAddOnAction(ActionEvent actionEvent) {

    }


}
