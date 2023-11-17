package com.museomaster.museomaster.TypyUzytkownikow.Utils;

import com.museomaster.museomaster.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class PracownikUprawnionyPrzydzielZadanie implements Initializable {
    public TextField input_name_lbl;
    public Button search_button;
    public ComboBox role_combobox;
    public ListView ser_found_list;
    public Button give_task;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        give_task.setOnAction(e-> Model.getInstance().getViewFactory().getPermissionWorkerSelectedMenuItem().set("giveTask"));
    }
}