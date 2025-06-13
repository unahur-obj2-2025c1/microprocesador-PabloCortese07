package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public abstract class Command implements Operable {

    protected Programable microUndo;
    
    public abstract void accion(Programable micro);

    @Override
    public void execute(Programable micro){
        microUndo = micro.copy();
        this.accion(micro);
        micro.incProgramCounter();
    }

    @Override
    public void undo(Programable micro){
        micro.copyFrom(this.microUndo);
    }

}
