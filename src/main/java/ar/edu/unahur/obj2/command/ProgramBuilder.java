package ar.edu.unahur.obj2.command;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unahur.obj2.command.comandos.*;

public class ProgramBuilder {
    private List<Operable> programas = new ArrayList<>();

    public List<Operable> getProgramas(){
        return programas;
    }

    public void reset(){
        programas = new ArrayList<>();
    }

    public void nop(){
        programas.add(new Nop());
    }

    public void add(){
        programas.add(new Add());
    }

    public void lod(Integer addr){
        programas.add(new Lod(addr));
    }

    public void lodv(Integer val){
        programas.add(new Lodv(val));
    }

    public void str(){
        programas.add(new Str());
    }

    public void swap(){
        programas.add(new Swap());
    }
    
}
