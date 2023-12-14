package com.example.mydbfx.Controllers;

import com.example.mydbfx.Models.Inventory;
import com.example.mydbfx.Models.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;


public class InventoryController implements Initializable {
    public Button backBtn;
    public TableView<Inventory> table;
    public TableColumn<Inventory, String> itemId;
    public TableColumn<Inventory, String> qty;
    public TableColumn<Inventory, String> price;
    public TableColumn<Inventory, String> type;
    public TableColumn<Inventory, String> descript;
    public TableColumn<Inventory, String> fit;
    public TableColumn<Inventory, String> color;
    public TableColumn<Inventory, String> supplierId;
    public Button addItemBtn;
    public TextField itemIdField;
    public TextField qtyField;
    public TextField priceField;
    public TextField typeField;
    public TextField descriptField;
    public TextField fitField;
    public TextField colorField;
    public TextField supplierIdField;
    public TextField updateQtyField;
    public Button updateQtyBtn;
    public TextField deleteItemIdField;
    public Button deleteItemBtn;
    public TextField updateItemIdField;
    private ObservableList<Inventory> list;
    private final HashMap<String, Inventory> inventoryHashMap = new HashMap<>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        itemId.setCellValueFactory(new PropertyValueFactory<Inventory, String>("itemId"));
        qty.setCellValueFactory(new PropertyValueFactory<Inventory, String>("qty"));
        price.setCellValueFactory(new PropertyValueFactory<Inventory, String>("price"));
        type.setCellValueFactory(new PropertyValueFactory<Inventory, String>("type"));
        descript.setCellValueFactory(new PropertyValueFactory<Inventory, String>("descript"));
        fit.setCellValueFactory(new PropertyValueFactory<Inventory, String>("fit"));
        color.setCellValueFactory(new PropertyValueFactory<Inventory, String>("color"));
        supplierId.setCellValueFactory(new PropertyValueFactory<Inventory, String>("supplierId"));
        updateContentBox();
    }

    public void updateContentBox() {
        ResultSet result = Model.getInstance().getDatabaseDriver().runQuery("SELECT * FROM Inventory");
        ArrayList<String[]> res = Model.getInstance().getDatabaseDriver().toString(result);
        list = FXCollections.observableArrayList();
        for(String[] data:res) {
            list.add(new Inventory(data[0].trim(), data[1], data[2], data[3], data[4], data[5], data[6], data[7]));
            inventoryHashMap.put(data[0].trim(), list.getLast());
        }
        table.setItems(list);
    }

    public void addItemBtnPressed(ActionEvent actionEvent) {
        if(itemIdField.getText().trim().isEmpty()) {
            itemIdField.setBackground(Background.fill(Color.RED));
        } else if(Integer.parseInt(qtyField.getText())<0) {
            qtyField.setBackground(Background.fill(Color.RED));
        } else {
            try {
                ResultSet result = Model.getInstance().getDatabaseDriver().runQuery("SELECT ItemID FROM Inventory WHERE ItemID = \"" + itemIdField.getText() + "\"");
                if(result.next()) {
                    itemIdField.setBackground(Background.fill(Color.RED));
                } else {
                    String itemid = itemIdField.getText().trim();
                    String qty = qtyField.getText();
                    String price = priceField.getText();
                    String type = typeField.getText();
                    String desc = descriptField.getText();
                    String fit = fitField.getText();
                    String colr = colorField.getText();
                    String supp = supplierIdField.getText();
                    String query = "INSERT INTO Inventory(ItemID, Qty, Price, ClothingType, Descript, Fit, Color, SupplierID) VALUES " +
                            String.format("(%s, %s, %s, '%s', '%s', '%s', '%s', %s)", itemid, qty, price, type, desc, fit, colr, supp);
                    Model.getInstance().getDatabaseDriver().runDMLQuery(query);
                    list.add(new Inventory(itemid, qty, price, type, desc, fit, colr, supp));
                    inventoryHashMap.put(itemid, list.getLast());

                    itemIdField.setBackground(Background.fill(Color.WHITE));
                    qtyField.setText("");
                    qtyField.setBackground(Background.fill(Color.WHITE));
                    priceField.setText("");
                    priceField.setBackground(Background.fill(Color.WHITE));
                    typeField.setText("");
                    typeField.setBackground(Background.fill(Color.WHITE));
                    descriptField.setText("");
                    descriptField.setBackground(Background.fill(Color.WHITE));
                    fitField.setText("");
                    fitField.setBackground(Background.fill(Color.WHITE));
                    colorField.setText("");
                    colorField.setBackground(Background.fill(Color.WHITE));
                    supplierIdField.setText("");
                    supplierIdField.setBackground(Background.fill(Color.WHITE));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateQtyBtnPressed(ActionEvent actionEvent) {
        if(updateItemIdField.getText().trim().isEmpty()) {
            updateItemIdField.setBackground(Background.fill(Color.RED));
        } else if(Integer.parseInt(updateQtyField.getText())<0) {
            updateQtyField.setBackground(Background.fill(Color.RED));
        } else {
            try {
                ResultSet result = Model.getInstance().getDatabaseDriver().runQuery("SELECT ItemID FROM Inventory WHERE ItemID = \"" + updateItemIdField.getText().trim() + "\"");
                if(result.next()) {
                    String query = "UPDATE Inventory SET Qty = " + updateQtyField.getText() + " WHERE ItemID = \"" + updateItemIdField.getText().trim().trim() + "\"";
                    Model.getInstance().getDatabaseDriver().runDMLQuery(query);
                    list.remove(inventoryHashMap.get(updateItemIdField.getText().trim()));
                    inventoryHashMap.get(updateItemIdField.getText().trim()).setQty(updateQtyField.getText());
                    list.add(inventoryHashMap.get(updateItemIdField.getText().trim()));
                    updateQtyField.setText("");
                    updateItemIdField.setBackground(Background.fill(Color.WHITE));
                    updateQtyField.setBackground(Background.fill(Color.WHITE));
                } else {
                    updateItemIdField.setBackground(Background.fill(Color.RED));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteItemBtnPressed(ActionEvent actionEvent) {
        if(deleteItemIdField.getText().trim().isEmpty()) {
            deleteItemIdField.setBackground(Background.fill(Color.RED));
        } else {
            try {
                ResultSet result = Model.getInstance().getDatabaseDriver().runQuery("SELECT ItemID FROM Inventory WHERE ItemID = \"" + deleteItemIdField.getText().trim() + "\"");
                if(result.next()) {
                    String query = "DELETE FROM Inventory WHERE ItemID = \"" + deleteItemIdField.getText().trim() + "\"";
                    Model.getInstance().getDatabaseDriver().runDMLQuery(query);
                    list.remove(inventoryHashMap.get(deleteItemIdField.getText().trim()));
                    deleteItemIdField.setBackground(Background.fill(Color.WHITE));

                } else {
                    deleteItemIdField.setBackground(Background.fill(Color.RED));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void backBtnPressed(ActionEvent actionEvent) {
        Stage stage = (Stage) backBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showMenuHomeWindow();
    }

}
