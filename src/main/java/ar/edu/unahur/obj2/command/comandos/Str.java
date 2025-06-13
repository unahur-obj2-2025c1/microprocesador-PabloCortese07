package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class Str extends Command {

    @Override
    public void accion(Programable micro) {
        Integer valorACargar = micro.getAcumuladorA();
        micro.setAddr(valorACargar);
    }

}
