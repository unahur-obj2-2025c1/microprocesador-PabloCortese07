package ar.edu.unahur.obj2.command;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.command.comandos.Operable;
import ar.edu.unahur.obj2.command.excepctions.MicroException;

public class Microprocesador implements Programable {

    private Integer acumuladorA = 0;
    private Integer acumuladorB = 0;
    private Integer programCounter = 0;
    private List<Integer> datos = new ArrayList<>();

    @Override
    public Integer getAcumuladorA() {
        return this.acumuladorA;
    }

    @Override
    public Integer getAcumuladorB() {
        return this.acumuladorB;
    }

    @Override
    public Integer getProgramCounter() {
        return this.programCounter;
    }

    @Override
    public void incProgramCounter() {
        programCounter++;
        
    }
    
    @Override
    public void setAcumuladorA(Integer value) {
        this.acumuladorA = value;
        
    }

    @Override
    public void setAcumuladorB(Integer value) {
        this.acumuladorB = value;
        
    }
    @Override
    public void reset() {
        acumuladorA = 0;
        acumuladorB = 0;
        programCounter = 0;
    }

    @Override
    public void run(List<Operable> operaciones) {
        operaciones.forEach(op -> op.execute(this));
        
    }

    public void desHacer(List<Operable> operaciones){
        Operable ultimaOp = operaciones.getLast();
        ultimaOp.undo(this);
        operaciones.remove(operaciones.size() - 1);
    }


    @Override
    public void setAddr(Integer addr) {
        if(addr > 1023){
            new MicroException("numero fuera de rango");
        }
        datos.add(addr);
    }

    @Override
    public Integer getAddr(Integer addr) {
        if(!(addr >= 0 || addr <= 1023)){
            new MicroException("numero fuera de rango");
        }
        return datos.get(addr);
    }

    
    @Override
    public Programable copy() {
        Microprocesador micro = new Microprocesador();
        micro.acumuladorA = this.acumuladorA;
        micro.acumuladorB = this.acumuladorB;
        micro.programCounter = this.programCounter;
        return micro;
    }

    @Override
    public void copyFrom(Programable programable) {
        programCounter = programable.getProgramCounter();
        acumuladorA = programable.getAcumuladorA();
        acumuladorB = programable.getAcumuladorB();
    }

}