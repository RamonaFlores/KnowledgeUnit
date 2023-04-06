package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
    public class Proyect {
        private String name;
        private String proyectPlannedBeginDate;
        private String proyectPlannedEndDate;
        private Double budget;
        private ClientDesignedManager clientManager;
        private ProyectManager proyectManager;
        private static List<Stage> stages;

        private List<Employee> proyectEmployees;

        public Proyect(String name, String proyectPlannedBeginDate, String proyectPlannedEndDate,
                       Double budget, ClientDesignedManager clientManager, ProyectManager proyectManager, List<Employee> proyectEmployees) {
            this.name = name;
            this.proyectPlannedBeginDate = proyectPlannedBeginDate;
            this.proyectPlannedEndDate = proyectPlannedEndDate;
            this.budget = budget;
            this.clientManager = clientManager;
            this.proyectManager = proyectManager;
            this.stages = new ArrayList<Stage>();
            this.proyectEmployees = new ArrayList<>(proyectEmployees);

            for (int i = 1; i <= 6; i++) {
                StageType type;
                switch (i) {
                    case 1:
                        type = StageType.BEGIN;
                        break;
                    case 2:
                        type = StageType.ANALYSIS;
                        break;
                    case 3:
                        type = StageType.DESIGN;
                        break;
                    case 4:
                        type = StageType.EXECUTION;
                        break;
                    case 5:
                        type = StageType.CLOSUREANDFOLLOWUP;
                        break;
                    case 6:
                        type = StageType.CONTROL;
                        break;
                    default:
                        type = StageType.BEGIN;
                }
                Stage stage = new Stage(type, null, null, null, null, false);
                this.stages.add(stage);
            }
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getProyectPlannedBeginDate() {
            return proyectPlannedBeginDate;
        }

        public void setProyectPlannedBeginDate(String proyectPlannedBeginDate) {
            this.proyectPlannedBeginDate = proyectPlannedBeginDate;
        }

        public String getProyectPlannedEndDate() {
            return proyectPlannedEndDate;
        }

        public void setProyectPlannedEndDate(String proyectPlannedEndDate) {
            this.proyectPlannedEndDate = proyectPlannedEndDate;
        }

        public Double getBudget() {
            return budget;
        }

        public void setBudget(Double budget) {
            budget = budget;
        }

        public ClientDesignedManager getClientManager() {
            return clientManager;
        }

        public void setClientManager(ClientDesignedManager clientManager) {
            this.clientManager = clientManager;
        }

        public ProyectManager getProyectManager() {
            return proyectManager;
        }

        public void setProyectManager(ProyectManager proyectManager) {
            this.proyectManager = proyectManager;
        }

        public List<Stage> getStages() {
            return stages;
        }

        public void setStages(List<Stage> stages) {
            this.stages = stages;
        }
        public static void addStage(Stage stage){
            stages.add(stage);
        }
        public List<Stage> getStageList() {
            return stages;
        }
        public  void addEmployee(Employee employee){
            proyectEmployees.add(employee);
        }
        public List<Employee> getProyectEmployees(){
            return proyectEmployees;
        }
        public void addCapsule(Capsule capsule, StageType stageType) {
            for (Stage stage : stages) {
                if (stage.getStageType() == stageType) {
                    stage.addCapsule(capsule);
                }
            }
        }
    }

