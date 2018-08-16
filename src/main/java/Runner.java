import db.DBHelper;
import db.DBManager;
import models.Administrator;
import models.Department;
import models.Manager;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Manager manager = new Manager("Big Dave", "JS515799S", 50000, 1000000);
        DBHelper.save(manager);

        Department department = new Department("The sales department", manager);
        DBHelper.save(department);

        Administrator administrator1 = new Administrator("Little Dave", "AS323455P", 25000, manager);
        DBHelper.save(administrator1);

        Administrator administrator2 = new Administrator("Little Davina", "FG3232355P", 25000, manager);
        DBHelper.save(administrator2);

        manager.addAdministrator(administrator1);
        manager.addAdministrator(administrator2);
        DBHelper.update(manager);

        List<Administrator> foundAdministrators = DBManager.getAdministratorsForManager(manager);

        Department foundDepartment = DBManager.getDepartmentForManager(manager);
    }
}
