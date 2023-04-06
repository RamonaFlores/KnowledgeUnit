package ui;
import kotlin.collections.ArrayDeque;
import model.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner console= new Scanner(System.in);
        List<Company> companies=new ArrayList<>();
        Capsule capsule1=new Capsule(null,null,null,null,null,null,null,null,false);
        Company techtoy=CompanyHolder.techtoy;
        Company pearced=CompanyHolder.pearced;
        Company blackInk_tattoos=CompanyHolder.blackInk_tattoos;
        Company male_ManipulatorInc =CompanyHolder.male_ManipulatorInc;
        Company skatenDestroy=CompanyHolder.skatenDestroy;
        companies.add(techtoy);
        companies.add(pearced);
        companies.add(blackInk_tattoos);
        companies.add(male_ManipulatorInc);
        companies.add(skatenDestroy);
        EnterpriseSystem greenSqa = new EnterpriseSystem("GreenSQA",companies);


        Boolean exit= false;
    JOptionPane.showMessageDialog(null,"Welcome to GreenSQA's KnowledgeUnit");
    while(!exit){
        String option= (JOptionPane.showInputDialog(null,"Choose an Action","Knowledge Unit BETA #0.01",JOptionPane.PLAIN_MESSAGE,null,new Object[]{"Choose","Create a Project","Finish a project's Stage","Create a Capsule","Register a Employee","Approve a Capsule"},"Choose")).toString();
        switch(option) {
            case "Create a Project":
               Proyect project= greenSqa.createProject();
                String companyChoice = (String) JOptionPane.showInputDialog(null, "Choose a company to add the project to", "Choose Company", JOptionPane.PLAIN_MESSAGE, null, new Object[]{techtoy.getCompanyName(), pearced.getCompanyName(), blackInk_tattoos.getCompanyName(), male_ManipulatorInc.getCompanyName(),skatenDestroy.getCompanyName()}, techtoy.getCompanyName());
                switch (companyChoice) {
                    case "Techtoy":
                        techtoy.addProyect(project);
                        JOptionPane.showMessageDialog(null,"Just added a new project to Techtoy");
                        break;
                    case "Pearced":
                        pearced.addProyect(project);
                        JOptionPane.showMessageDialog(null,"Just added a new project to Pearced");
                        break;
                    case "BlackInk Tattoos":
                        blackInk_tattoos.addProyect(project);
                        JOptionPane.showMessageDialog(null,"Just added a new project to BlackInk");
                        break;
                    case "Male Manipulator . INC":
                        male_ManipulatorInc.addProyect(project);
                        JOptionPane.showMessageDialog(null,"Just added a new project to Male Manipulator . INC");
                        break;
                    case "Skate n Destroy":
                        skatenDestroy.addProyect(project);
                        JOptionPane.showMessageDialog(null,"Just added a new project to Skate n Destroy");
                        break;
                }
                break;
            case "Finish a project's Stage":
                Proyect selectedProyect=greenSqa.selectProject();
                greenSqa.selectStage(selectedProyect);
                JOptionPane.showMessageDialog(null,"The Selected stage's state was set to Finish. Well Done!");
                break;
            case "Create a Capsule":
                Capsule capsule=greenSqa.registerCapsule();

            case "Register a Employee":
                capsule1.setApproved(true);
                break;
            case "Approve a Capsule":

                break;
            default:
                // code to handle invalid option
                break;
        }
    }


    }
}