package model;

import javax.swing.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Company {
    private String companyName;
    private static List<Proyect> proyectList;

    public Company(String companyName, List proyectList) {
        this.companyName = companyName;
        this.proyectList = new ArrayList<>();
    }

    public void addProyect(Proyect proyect) {
        proyectList.add(proyect);

    }
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Proyect> getProyectList() {
        return new ArrayList<>(proyectList);
    }

    public void setProyectList(List<Proyect> proyectList) {
        this.proyectList = new ArrayList<>(proyectList);
    }

        public static Company companyRegisterWithUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What's the name of your company?");
        String companyname = scanner.nextLine();
        List<Proyect> proyectList = new ArrayList<>();
        Company company = new Company(companyname, proyectList);
        return company;
    }




    public String toString() {
        return "Company{" +
                "companyName='" + companyName + '\'' +
                ", projectList=" + proyectList +
                '}';
    }
    public static Proyect findProject(String projectName) {
        for (Proyect project : proyectList) {
            if (project.getName().equals(projectName)) {
                return project;
            }
        }
        return null;
    }
}
