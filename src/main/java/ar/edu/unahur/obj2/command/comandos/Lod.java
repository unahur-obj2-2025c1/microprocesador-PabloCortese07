package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class Lod implements Operable {
    private Integer addr;

    public Lod(Integer addr){
        this.addr = addr;
    }

    @Override
    public void execute(Programable micro) {
        Integer valorCargado = micro.getAddr(addr);
        micro.incProgramCounter();
        micro.setAcumuladorA(valorCargado);
    }

    @Override
    public void undo(Programable micro) {
        // TODO Auto-generated method stub
        
    }


}
