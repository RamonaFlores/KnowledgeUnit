package model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class EnterpriseSystem {
    private String name;
    private List<Company> companyList;

    public EnterpriseSystem(String name, List companyList) {
        this.name = name;
        this.companyList = new ArrayList<>();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EnterpriseSystem{name='").append(name).append("', companyList=[\n");
        for (Company company : companyList) {
            sb.append("    ").append(company.toString()).append("\n");
        }
        sb.append("], proyectList=[\n");
        for (Company company : companyList) {
            for (Proyect proyect : company.getProyectList()) {
                sb.append("    Company: ").append(company.getCompanyName())
                        .append(", Proyect: {name='").append(proyect.getName())
                        .append("', proyectPlannedBeginDate='").append(proyect.getProyectPlannedBeginDate())
                        .append("', proyectPlannedEndDate='").append(proyect.getProyectPlannedEndDate())
                        .append("', budget=").append(proyect.getBudget())
                        .append(", clientManager=").append(proyect.getClientManager().toString())
                        .append(", proyectManager=").append(proyect.getProyectManager().toString())
                        .append(", stages=").append(proyect.getStages().toString())
                        .append("}\n");
            }
        }
        sb.append("]}");
        return sb.toString();
    }

    public static Proyect createProject() {
        // Get project name from user input
        String projectName = JOptionPane.showInputDialog("Enter project name:");

        // Get planned begin date from user input
        String plannedBeginDate = JOptionPane.showInputDialog("Enter planned begin date (YYYY-MM-DD):");

        // Get planned end date from user input
        String plannedEndDate = JOptionPane.showInputDialog("Enter planned end date (YYYY-MM-DD):");

        // Get budget from user input
        String budgetString = JOptionPane.showInputDialog("Enter budget:");
        Double budget = Double.parseDouble(budgetString);

        // Get client manager from user input
        String clientManagerName = JOptionPane.showInputDialog("Enter client manager name:");
        String clientManagerPhone = JOptionPane.showInputDialog("Enter client manager Phone:");
        String clientManagerId = JOptionPane.showInputDialog("Enter client manager ID:");
        ClientDesignedManager clientManager = new ClientDesignedManager(clientManagerName, clientManagerPhone, clientManagerId);

        // Get project manager from user input
        String projectManagerName = JOptionPane.showInputDialog("Enter project manager name:");
        String projectManagerPhone = JOptionPane.showInputDialog("Enter project manager phone:");
        String projectManagerId = JOptionPane.showInputDialog("Enter project manager ID:");
        ProyectManager projectManager = new ProyectManager(projectManagerName, projectManagerPhone, projectManagerId);

        // Create empty list of employees
        List<Employee> projectEmployees = new ArrayList<>();

        // Create the project object
        Proyect project = new Proyect(projectName, plannedBeginDate, plannedEndDate, budget, clientManager, projectManager, projectEmployees);

        // Add the 6 stages to the project
        for (int i = 1; i <= 6; i++) {
            StageType stageType;
            switch (i) {
                case 1:
                    stageType = StageType.BEGIN;
                    break;
                case 2:
                    stageType = StageType.ANALYSIS;
                    break;
                case 3:
                    stageType = StageType.DESIGN;
                    break;
                case 4:
                    stageType = StageType.EXECUTION;
                    break;
                case 5:
                    stageType = StageType.CLOSUREANDFOLLOWUP;
                    break;
                case 6:
                    stageType = StageType.CONTROL;
                    break;
                default:
                    stageType = StageType.BEGIN;
            }
            Stage stage = new Stage(stageType, null, null, null, null, false);
            project.addStage(stage);
        }

        return project;
    }

    public Proyect selectProject() {
        Company techtoy = CompanyHolder.techtoy;
        Company pearced = CompanyHolder.pearced;
        Company blackInk_tattoos = CompanyHolder.blackInk_tattoos;
        Company male_ManipulatorInc = CompanyHolder.male_ManipulatorInc;
        Company skatenDestroy = CompanyHolder.skatenDestroy;
        String[] companyNames = {"Techtoy", "Pearced", "BlackInk Tattoos", "Male Manipulator . INC", "Skate n Destroy"};
        int companyIndex = JOptionPane.showOptionDialog(null, "Select a Company", "Company Selection",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, companyNames, companyNames[0]);

        Company selectedCompany;
        switch (companyIndex) {
            case 0:
                selectedCompany = techtoy;
                break;
            case 1:
                selectedCompany = pearced;
                break;
            case 2:
                selectedCompany = blackInk_tattoos;
                break;
            case 3:
                selectedCompany = male_ManipulatorInc;
                break;
            case 4:
                selectedCompany = skatenDestroy;
                break;
            default:
                selectedCompany = null;
                break;
        }

        if (selectedCompany == null) {
            JOptionPane.showMessageDialog(null, "Invalid Company Selected");
            return null;
        }

        List<Proyect> projectList = selectedCompany.getProyectList();
        if (projectList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No Projects Found");
            return null;
        }

        String[] projectNames = new String[projectList.size()];
        for (int i = 0; i < projectList.size(); i++) {
            projectNames[i] = projectList.get(i).getName();
        }

        int projectIndex = JOptionPane.showOptionDialog(null, "Select a Project", "Project Selection",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, projectNames, projectNames[0]);

        if (projectIndex >= 0 && projectIndex < projectList.size()) {
            return projectList.get(projectIndex);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Project Selected");
            return null;
        }
    }


    public void addCompany(Company company) {
        companyList.add(company);
    }

    public Stage selectStage(Proyect project) {
        List<Stage> stageList = project.getStageList();
        if (stageList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No Stages Found");
            return null;
        }

        String[] stageNames = new String[stageList.size()];
        for (int i = 0; i < stageList.size(); i++) {
            Stage stage = stageList.get(i);
            String stageName = "Stage " + (i + 1) + " - " + stage.getStageType().toString();
            if (stage.getFinishedState()) {
                stageName += " (finished)";
            }
            stageNames[i] = stageName;
        }

        int stageIndex = JOptionPane.showOptionDialog(null, "Select a Stage", "Stage Selection",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, stageNames, stageNames[0]);

        if (stageIndex >= 0 && stageIndex < stageList.size()) {
            Stage selectedStage = stageList.get(stageIndex);
            selectedStage.setFinishedState(true);
            return selectedStage;
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Stage Selected");
            return null;
        }
    }

    public Employee findEmployee(String id) {
        for (Company company : companyList) {
            for (Proyect project : company.getProyectList()) {
                for (Employee employee : project.getProyectEmployees()) {
                    if (employee.getEmployeeId().equals(id)) {
                        return employee;
                    }
                }
            }
        }
        return null;
    }

    public Employee registerEmployee() {
        // Ask the user if they want to register a new Employee or work with an existing one
         JOptionPane.showMessageDialog(null,"Lets register an Employee") ;
            // Ask the user to input the attributes of the Employee object
            String employeeName = JOptionPane.showInputDialog("Enter the Employee's name:");
            String employeePhone = JOptionPane.showInputDialog("Enter the Employee's phone number:");
            String employeePosition = JOptionPane.showInputDialog("Enter the Employee's job title:");
            String employeeId = JOptionPane.showInputDialog("Enter the employee's ID:");

            // Construct the Employee object
            Employee employee = new Employee(employeeName, employeePhone, employeePosition, employeeId);

            // Ask the user to pick a company
            int companyChoice = JOptionPane.showOptionDialog(null, "Which company?", "Company Selection", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{CompanyHolder.techtoy.getCompanyName(), CompanyHolder.pearced.getCompanyName(), CompanyHolder.blackInk_tattoos.getCompanyName(), CompanyHolder.male_ManipulatorInc.getCompanyName(), CompanyHolder.skatenDestroy.getCompanyName()}, CompanyHolder.techtoy.getCompanyName());

            // Get the chosen company
            Company company = null;
            switch (companyChoice) {
                case 0:
                    company = CompanyHolder.techtoy;
                    break;
                case 1:
                    company = CompanyHolder.pearced;
                    break;
                case 2:
                    company = CompanyHolder.blackInk_tattoos;
                    break;
                case 3:
                    company = CompanyHolder.male_ManipulatorInc;
                    break;
                case 4:
                    company = CompanyHolder.skatenDestroy;
                    break;
            }

            // Ask the user to pick a project of the chosen company
            Proyect project = null;
            while (project == null) {
                String projectName = JOptionPane.showInputDialog("Enter project name:");
                project = company.findProject(projectName);
                if (project == null) {
                    JOptionPane.showMessageDialog(null, "Project not found.");
                }
            }

            // Add the Employee to the Project's EmployeeList
            project.addEmployee(employee);
            JOptionPane.showMessageDialog(null, "Employee Registered successfully");

        return employee;
    }
    public Capsule registerCapsule(){ int stageChoice = JOptionPane.showOptionDialog(null, "In which project stage do you want to add the capsule?", "Capsule Registration", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{StageType.BEGIN.toString(), StageType.ANALYSIS.toString(), StageType.DESIGN.toString(), StageType.EXECUTION.toString(), StageType.CLOSUREANDFOLLOWUP.toString(), StageType.CONTROL.toString()}, StageType.BEGIN.toString());

// Get the chosen stage
        StageType stageType = null;
        switch (stageChoice) {
            case 0:
                stageType = StageType.BEGIN;
                break;
            case 1:
                stageType = StageType.ANALYSIS;
                break;
            case 2:
                stageType = StageType.DESIGN;
                break;
            case 3:
                stageType = StageType.EXECUTION;
                break;
            case 4:
                stageType = StageType.CLOSUREANDFOLLOWUP;
                break;
            case 5:
                stageType = StageType.CONTROL;
                break;
        }

// Ask the user to input the attributes of the Capsule object
        String capsuleName = JOptionPane.showInputDialog("Enter capsule name:");
        String capsuleId = JOptionPane.showInputDialog("Enter capsule ID:");
//Ask the user to input the Capsule type
        int capsuleTypeChoice = JOptionPane.showOptionDialog(null, "Choose the capsule type you're about to register", "Capsule Registration", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{CapsuleType.TECHNICAL.toString(), CapsuleType.MANAGEMENT.toString(), CapsuleType.DOMAIN.toString(), CapsuleType.EXPERIENCE.toString()}, CapsuleType.TECHNICAL.toString());

// Get the chosen capsule Type
        CapsuleType capsuleType = null;
        switch (capsuleTypeChoice) {
            case 0:
                capsuleType = CapsuleType.TECHNICAL;
                break;
            case 1:
                capsuleType = CapsuleType.MANAGEMENT;
                break;
            case 2:
                capsuleType = CapsuleType.DOMAIN;
                break;
            case 3:
                capsuleType = CapsuleType.EXPERIENCE;
                break;
        }
        String capsuleDescription = JOptionPane.showInputDialog("Enter  capsule description:");
        String capsuleLessonLearned = JOptionPane.showInputDialog("Enter the Lesson Learned");
        String capsuleHashtag = JOptionPane.showInputDialog("Enter the capsule's Hashtag");


// Construct the Capsule object
        Capsule capsule = new Capsule(capsuleName, capsuleId, capsuleType, capsuleDescription, capsuleLessonLearned, capsuleHashtag, false, null, false);

// Add the Capsule to the chosen Employee's CapsuleList in the chosen stage
        String employeeId = JOptionPane.showInputDialog("Enter employee ID:");
        Employee employee = findEmployee(employeeId);

// If the Employee is not found, display an error message and return
        if (employee == null) {
            JOptionPane.showMessageDialog(null, "Employee not found.");
            return capsule;
        }
        int companyChoice2 = JOptionPane.showOptionDialog(null, "Which company?", "Company Selection", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{CompanyHolder.techtoy.getCompanyName(), CompanyHolder.pearced.getCompanyName(), CompanyHolder.blackInk_tattoos.getCompanyName(), CompanyHolder.male_ManipulatorInc.getCompanyName(), CompanyHolder.skatenDestroy.getCompanyName()}, CompanyHolder.techtoy.getCompanyName());

        //Ask the user for the company again
        Company company2 = null;
        switch (companyChoice2) {
            case 0:
                company2 = CompanyHolder.techtoy;
                break;
            case 1:
                company2 = CompanyHolder.pearced;
                break;
            case 2:
                company2 = CompanyHolder.blackInk_tattoos;
                break;
            case 3:
                company2 = CompanyHolder.male_ManipulatorInc;
                break;
            case 4:
                company2 = CompanyHolder.skatenDestroy;
                break;
        }
// Ask the user for the project again.
        String projectName = JOptionPane.showInputDialog("Please Enter the project's name Again:");
        Proyect project2 = company2.findProject(projectName);


        project2.addCapsule(capsule, stageType);
        employee.addCapsule(capsule);

        JOptionPane.showMessageDialog(null, "Capsule added successfully.");


        return capsule;
    }
}
