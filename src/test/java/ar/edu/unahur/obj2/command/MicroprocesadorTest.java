package ar.edu.unahur.obj2.command;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MicroprocesadorTest {
    ProgramBuilder programBuilder = new ProgramBuilder();
    Microprocesador microprocesador = new Microprocesador();

    @Test
    void HacerAvanzar3PosicionesElPC(){
        microprocesador.reset();
        programBuilder.nop();
        programBuilder.nop();
        programBuilder.nop();

        microprocesador.run(programBuilder.getProgramas());
        assertEquals(3, microprocesador.getProgramCounter());
    }

    @Test 
    void Sumar20y17EnLosAcumuladoresDeAYByElProgramCounterEsDe4(){
        microprocesador.reset();
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
        microprocesador.reset();
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

    //Parte 2 - desHacer operaciones

    @Test
    void HacerAvanzar3PosicionesElPCPeroDesHacemosLasAcciones(){
        programBuilder.nop();
        programBuilder.nop();
        programBuilder.nop();

        microprocesador.run(programBuilder.getProgramas());
        microprocesador.desHacer(programBuilder.getProgramas());
        microprocesador.desHacer(programBuilder.getProgramas());
        microprocesador.desHacer(programBuilder.getProgramas());
        assertEquals(0, microprocesador.getProgramCounter());
    }

    @Test 
    void Sumar20y17EnLosAcumuladoresDeAYByElProgramCounterEsDe4PeroDesHacemosLasAcciones(){
        programBuilder.lodv(20);
        programBuilder.swap();
        programBuilder.lodv(17);
        programBuilder.add();

        microprocesador.run(programBuilder.getProgramas());
        microprocesador.desHacer(programBuilder.getProgramas());
        assertEquals(3, microprocesador.getProgramCounter());
        assertEquals(17, microprocesador.getAcumuladorA());
        assertEquals(20, microprocesador.getAcumuladorB());
    }

    // @Test
    // void ejecutamos9ProcesosYSumamosElAcumuladorAyBPeroDesHacemosLasAcciones(){
    //     programBuilder.lodv(2);
    //     programBuilder.str();
    //     programBuilder.lodv(8);
    //     programBuilder.swap();
    //     programBuilder.lodv(5);
    //     programBuilder.add();
    //     programBuilder.swap();
    //     programBuilder.lod(0);
    //     programBuilder.add();

    //     microprocesador.run(programBuilder.getProgramas());
    //     assertEquals(9, microprocesador.getProgramCounter());
    //     assertEquals(15, microprocesador.getAcumuladorA());
    //     assertEquals(0, microprocesador.getAcumuladorB());
    // }

}
