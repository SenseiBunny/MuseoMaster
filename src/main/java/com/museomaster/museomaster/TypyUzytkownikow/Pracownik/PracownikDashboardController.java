package com.museomaster.museomaster.TypyUzytkownikow.Pracownik;

import com.museomaster.museomaster.CellsController.UserCellFactory;
import com.museomaster.museomaster.CellsController.assignedTask;
import com.museomaster.museomaster.CellsController.assignedTaskFactory;
import com.museomaster.museomaster.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class PracownikDashboardController implements Initializable {
    public ListView task_list_listview;
    public ListView ended_task_list_listview;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initData();
        task_list_listview.setItems(Model.getInstance().getTasks());
        task_list_listview.setCellFactory(e->new assignedTaskFactory());
    }

    public void initData(){
        Model.getInstance().clearTasks();
        Model.getInstance().setTasks();
    }
}
