package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class Str implements Operable {

    @Override
    public void execute(Programable micro) {
        Integer valorACargar = micro.getAcumuladorA();
        micro.setAddr(valorACargar);
        micro.incProgramCounter();
    }

    @Override
    public void undo(Programable micro) {
        // TODO Auto-generated method stub
        
    }

}
