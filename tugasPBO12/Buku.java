/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugasPBO12;

/**
 *
 * @author user
 */
import java.io.*;

class Buku implements Serializable { 
    private static final long serialVersionUID = 1L; 
    private String judul; 
    private String pengarang; 
    private int tahunTerbit; 
    
    public Buku(String judul, String pengarang, int tahunTerbit) { 
        this.judul = judul; 
        this.pengarang = pengarang; 
        this.tahunTerbit = tahunTerbit; 
    } 
    
    public String toString() { 
        return "Judul: " + judul + "\nPengarang: " + pengarang + "\nTahun Terbit: " + tahunTerbit; 
    } 
}
