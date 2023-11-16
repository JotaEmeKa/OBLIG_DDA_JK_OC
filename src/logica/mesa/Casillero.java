/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.mesa;

/**
 *
 * @author Octavio
 */
public class Casillero {
    public int universalCellCode;
    public boolean esRojo;

    public Casillero(int universalCellCode, boolean esRojo) {
        this.universalCellCode = universalCellCode;
        this.esRojo = esRojo;
    }

    public int getUniversalCellCode() {
        return universalCellCode;
    }

    public boolean isEsRojo() {
        return esRojo;
    }

    public void setUniversalCellCode(int universalCellCode) {
        this.universalCellCode = universalCellCode;
    }

    public void setEsRojo(boolean esRojo) {
        this.esRojo = esRojo;
    }
    
    
    //Hay que hacer buscar por cellCode

    @Override
    public String toString() {
        return "Casillero{" + "universalCellCode=" + universalCellCode + '}';
    }
    
    
    
    
    
}
