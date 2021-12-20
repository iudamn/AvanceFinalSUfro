package model;

import data.DataUpdater;
import data.FileReader;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para probar el funcionamiento de ciertos componentes del programa.
 *
 * @author Joaquín Ortiz Castillo
 *
 * */
class UnitTest {

    @Test
    void textReader() {
        ArrayList<String> actual = FileReader.leerArchivo("src/test/testResources/readerTest");
        ArrayList<String> expected = new ArrayList<>();
        expected.add("pato");
        expected.add("purific");
        assertEquals(expected, actual);
    }

    @Test
    void loginTest(){
        Login loginTrue = new Login("userExpected","passExpected");
        loginTrue.logearUsuario("src/test/testResources/usuarioTest");

        Login loginFalse = new Login("userExpectedFalse","passExpectedFalse");
        loginFalse.logearUsuario("src/test/testResources/usuarioTest");

        assertTrue(loginTrue.isLoginState());
        assertFalse(loginFalse.isLoginState());
    }

    @Test //utiliza filereader ya que se acaba de comprobar que funciona.
    void guardarUsuarioTest() {
        int newId = FileReader.leerArchivo("src/test/testResources/registroTest").size() + 1;
        DataUpdater.guardarUsuario("userExpected","passExpected","src/test/testResources/registroTest",newId);
        ArrayList<String> file = FileReader.leerArchivo("src/test/testResources/registroTest");
        String actual = file.get(file.size()-1);
        String expected = "userExpected,passExpected,0,50,50,100,"+(newId-1);
        assertEquals(expected, actual);
    }

    @Test
    void registroCheckTest(){
        ArrayList<String> file = FileReader.leerArchivo("src/test/testResources/usuarioTest");
        String[] actual = file.get(file.size()-1).split(",");
        Login loginTrue = new Login(actual[0],actual[1]);
        Login loginFalse = new Login("expectedToFail","expectedToFail");
        assertTrue(loginTrue.registroCheck("src/test/testResources/usuarioTest"));
        assertFalse(loginFalse.registroCheck("src/test/testResources/usuarioTest"));
    }

    @Test //utiliza filereader ya que se acaba de comprobar que funciona.
    void actualizarUsuarioTest() {
        int a = (int) (Math.random()*5);
        int b = (int) (Math.random()*5);
        int c = (int) (Math.random()*5);
        int d = (int) (Math.random()*5);
        DataUpdater.actualizarUsuario("userExpected","passExpected",a,b,c,d,
                "src/test/testResources/usuarioTest",0);
        ArrayList<String> file = FileReader.leerArchivo("src/test/testResources/usuarioTest");
        String actual = file.get(file.size()-1);
        String expected ="userExpected,passExpected,"+a+","+b+","+c+","+d+",0";
        assertEquals(expected,actual);
    }

    @Test
    void fightExecutionTest(){
        Estudiante estudianteTest = new Estudiante("userExpected","passExpected",0  ,100,50,25,0);
        Enemigo enemigoTest = new Enemigo("enemigoTest",10  ,500,"irrelevant");
        FightExecution fightExecution = new FightExecution(estudianteTest,enemigoTest,0);
        fightExecution.atacar();
        int expectedEstudianteHp = (25-10);
        int expectedEnemigoHp = (500-50);
        assertEquals(expectedEstudianteHp,estudianteTest.getHp());
        assertEquals(expectedEnemigoHp,enemigoTest.getHp());
    }
}