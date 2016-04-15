/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

/**
 *
 * @author BINH
 */
public class DEMO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Sup s = new Sup();
        System.out.println("VIP");
    }
    
}
class Super{
    public Super(){
        System.out.println("it none arg supper");
    }
    public Super(int a){
        System.out.println("super with a arg: "+a);
    }
}
class Sup extends Super{
    public Sup(){
        super();
        System.out.println("Sub Class");
    }
}
    