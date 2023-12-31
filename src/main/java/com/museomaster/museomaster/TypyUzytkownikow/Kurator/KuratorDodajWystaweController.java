package com.museomaster.museomaster.TypyUzytkownikow.Kurator;

import com.museomaster.museomaster.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

/**
 * Klasa odpowiedzialna za dodawanie wystawy
 */
public class KuratorDodajWystaweController implements Initializable {
    public TextField ex_name_input;
    public ComboBox<String> room_combobox;
    public TextField made_in_input;
    public TextField subject_input;
    public TextField creator_input;
    public DatePicker start_date_datapicker;
    public DatePicker end_date_datapicker;
    public Button create_ex_button;
    public Text error_lbl;

    /**
     * Funckja initialize jest odpowiedizlana za inicjalizację wyświetlanie danych oraz za obsługę zdarzeń
     * @param url -> Lokalizacja używana do rozwiązywania ścieżek względnych dla obiektu root lub null, jeśli lokalizacja nie jest znana.
     * @param resourceBundle -> Zasoby użyte do zlokalizowania obiektu głównego lub null, jeśli obiekt główny nie został zlokalizowany.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initData(); // inicjalizujemy dane
        room_combobox.setItems(Model.getInstance().getRooms()); // wypełniamy listę możlwiymi pomieszczeniam
        create_ex_button.setOnAction(e -> createExhibition()); //
    }
    private void createExhibition(){
        try{
            String nazwa = ex_name_input.getText();
            String sala = room_combobox.getValue();
            String miejsceWyk = made_in_input.getText();
            String tematyka = subject_input.getText();
            String tworca = creator_input.getText();
            LocalDate dataRozp = start_date_datapicker.getValue();
            LocalDate dataZak = end_date_datapicker.getValue();

            Model.getInstance().getDataBaseDriver().createExhibition(nazwa, sala, miejsceWyk, tematyka, tworca, dataRozp, dataZak);
            emptyFields();
            if(Model.getInstance().getDataBaseDriver().getCreateExhibitionSuccessFlag()) {
                error_lbl.setText("Wystawa stworzona!");
                error_lbl.setFill(Color.GREEN);
                Model.getInstance().getExhibitions().clear();
            } else {
                error_lbl.setText("Źle wypełniony formularz..");
                error_lbl.setFill(Color.RED);
            }
        } catch (Exception e){
            System.out.println("ALO");
            error_lbl.setText("Źle wypełniony formularz..");
            error_lbl.setFill(Color.RED);
        }
    }
    private void emptyFields(){
        ex_name_input.setText("");
        room_combobox.setValue(null);
        made_in_input.setText("");
        subject_input.setText("");
        creator_input.setText("");
        start_date_datapicker.setValue(null);
        end_date_datapicker.setValue(null);

    }
    private void initData(){
        Model.getInstance().clearRooms();
        Model.getInstance().setRoom();
    }

}
