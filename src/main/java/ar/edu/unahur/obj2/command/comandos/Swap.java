package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class Swap extends Command {

    @Override
    public void accion(Programable micro) {
       Integer valorA = micro.getAcumuladorA();
       Integer valorB = micro.getAcumuladorB();
       
       micro.setAcumuladorA(valorB);
       micro.setAcumuladorB(valorA);
    }
}
