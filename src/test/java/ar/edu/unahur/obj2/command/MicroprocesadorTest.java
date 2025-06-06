package ar.edu.unahur.obj2.command;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MicroprocesadorTest {
    ProgramBuilder programBuilder = new ProgramBuilder();
    Microprocesador microprocesador = new Microprocesador();

    @Test
    void HacerAvanzar3PosicionesElPC(){
        programBuilder.nop();
        programBuilder.nop();
        programBuilder.nop();

        microprocesador.run(programBuilder.getProgramas());
        assertEquals(3, microprocesador.getProgramCounter());
    }

    @Test 
    void Sumar20y17EnLosAcumuladoresDeAYByElProgramCounterEsDe4(){
        programBuilder.lodv(20);
        programBuilder.swap();
        programBuilder.lodv(17);
        programBuilder.add();

        microprocesador.run(programBuilder.getProgramas());
        assertEquals(4, microprocesador.getProgramCounter());
        assertEquals(37, microprocesador.getAcumuladorA());
        assertEquals(0, microprocesador.getAcumuladorB());
    }

    @Test
    void ejecutamos9ProcesosYSumamosElAcumuladorAyB(){
        programBuilder.lodv(2);
        programBuilder.str();
        programBuilder.lodv(8);
        programBuilder.swap();
        programBuilder.lodv(5);
        programBuilder.add();
        programBuilder.swap();
        programBuilder.lod(0);
        programBuilder.add();

        microprocesador.run(programBuilder.getProgramas());
        assertEquals(9, microprocesador.getProgramCounter());
        assertEquals(15, microprocesador.getAcumuladorA());
        assertEquals(0, microprocesador.getAcumuladorB());
    }

}
