package customPackage;

import customPackage.people.Manager;

public class BusinessCluster {
    public static void main(String[] args) {
        Company company = new Company();
        Manager manager = new Manager("Johnson", 45);
        company.manager = manager;
    }
}
