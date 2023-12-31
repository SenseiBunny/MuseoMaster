module com.museomaster.museomaster {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires de.jensd.fx.glyphs.fontawesome;
    requires javafx.media;
    requires jbcrypt;
    requires spring.context.support;


    opens com.museomaster.museomaster to javafx.fxml;
    exports com.museomaster.museomaster;
    exports com.museomaster.museomaster.TypyUzytkownikow;
    exports com.museomaster.museomaster.TypyUzytkownikow.Pracownik;
    exports com.museomaster.museomaster.TypyUzytkownikow.Administrator;
    exports com.museomaster.museomaster.TypyUzytkownikow.Utils;
    exports com.museomaster.museomaster.TypyUzytkownikow.PracownikUprawniony;
    exports com.museomaster.museomaster.TypyUzytkownikow.ZwyklyKonswerwator;
    exports com.museomaster.museomaster.TypyUzytkownikow.Kurator;
    exports com.museomaster.museomaster.Views;
    exports com.museomaster.museomaster.Models;
    exports com.museomaster.museomaster.CellsController;
    exports com.museomaster.museomaster.TypyUzytkownikow.KonserwatorUprawniony;
    exports com.museomaster.museomaster.TypyUzytkownikow.MuseumClient;

}