/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.List;
import java.util.ArrayList;
import DAOdatamovie.datamovieDAO;
import DAOImplement.datamovieimplement;
import model.*;
import view.MainView;

/**
 *
 * @author ASM
 */
public class datamoviecontroller {
    MainView frame;
    datamovieimplement impldatamovie;
    List<datamovie> damov;
    
    public datamoviecontroller(MainView frame){
        this.frame = frame;
        impldatamovie = new datamovieDAO();
        damov = impldatamovie.getAll();
    }
    
     public void isitabel(){
        damov = impldatamovie.getAll();
        modeltabeldatamovie mp = new modeltabeldatamovie(damov);
        frame.getTabelDatamovie().setModel(mp);
    }
     
     public void insert(){
        datamovie damov = new datamovie();
        damov.setJudul(frame.getFJudul().getText());
        damov.setAlur(Double.parseDouble(frame.getFAlur().getText()));
        damov.setPenokohan(Double.parseDouble(frame.getFPenokohan().getText()));
        damov.setAkting(Double.parseDouble(frame.getFAkting().getText()));
        damov.setNilai(damov.calculateNilai());
        impldatamovie.insert(damov);  
    }
     
     public void update(){
        datamovie damov = new datamovie();
        damov.setJudul(frame.getFJudul().getText());
        damov.setAlur(Double.parseDouble(frame.getFAlur().getText()));
        damov.setPenokohan(Double.parseDouble(frame.getFPenokohan().getText()));
        damov.setAkting(Double.parseDouble(frame.getFAkting().getText()));
        damov.setNilai(damov.calculateNilai());
        impldatamovie.update(damov);
    }
     
    public void delete(){
        String judul = frame.getFJudul().getText();
        impldatamovie.delete(judul);
    } 
}
