package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.fintech.qa.homework.utils.BeforeUtils;
import ru.fintech.qa.homework.utils.db.jdbc.DbServise;

public class Testsjdbc {
    @BeforeAll
    public static void createTables() {
        BeforeUtils.createData();
    }

    @Test
    public void testGetRowFromAnimal() {
        int countRow = 10;
        int countRowFromAnimal = DbServise.executeGetCountRow("select * from animal");
        Assertions.assertEquals(countRow, countRowFromAnimal);
    }
    @Test
    public void testNoInsertRowToAnimal() {
        int countRow = 10;
        DbServise.executeUpdate("insert into animal(id) VALUES(1)");
        DbServise.executeUpdate("insert into animal(id) VALUES(10)");
        DbServise.executeUpdate("insert into animal(id) VALUES(5)");
        int countRowFromAnimal = DbServise.executeGetCountRow("select * from animal");
        Assertions.assertEquals(countRow, countRowFromAnimal);
    }
    @Test
    public void testWorkmanInsertNameIsNull() {
        int countNameNull = 0;
        int workmanNameNull = DbServise.executeUpdate("insert into workman(id) VALUES(7)");
        Assertions.assertEquals(countNameNull, workmanNameNull);
    }
    @Test
    public void testGetRowFromPlaces() {
        int countRow = 6;
        DbServise.executeUpdate("insert into places(id, \"row\",place_num) values(6,4,150)");
        int countRowFromPlacesAfterUpdate = DbServise.executeGetCountRow("select * from places");
                Assertions.assertEquals(countRow, countRowFromPlacesAfterUpdate);
        DbServise.executeUpdate("delete from places where id = 6");
    }
    @Test
   public void testIsThreeRowFromZoo() {
        int countRow = 3;
        int countRowFromZoo = DbServise.executeGetCountRow("select * from zoo where \"name\" = 'Центральный' "
                + "or \"name\" = 'Северный' or \"name\" = 'Западный'");
        Assertions.assertEquals(countRow, countRowFromZoo);
    }
}
