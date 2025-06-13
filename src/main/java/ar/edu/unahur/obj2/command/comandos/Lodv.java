package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class Lodv extends Command {
    private Integer val;

    public Lodv(Integer val){
        this.val = val;
    }

    @Override
    public void accion(Programable micro) {
        micro.setAcumuladorA(val);
    }


}
