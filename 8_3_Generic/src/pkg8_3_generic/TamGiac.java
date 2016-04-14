/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8_3_generic;

/**
 *
 * @author hv
 */
public class TamGiac {
    public class Diem{
        private int x,y;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
        public Diem() {
            this.x = 0;
            this.y = 0;
        }
        public Diem(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public double KhoangCach(Diem u){
            double dx,dy;
            dx = x-u.x;
            dy = y-u.y;
            return Math.sqrt(dx*dx+dy*dy);
        }
    }
    private Diem A,B,C;

    public Diem getA() {
        return A;
    }

    public void setA(Diem A) {
        this.A = A;
    }

    public Diem getB() {
        return B;
    }

    public void setB(Diem B) {
        this.B = B;
    }

    public Diem getC() {
        return C;
    }

    public void setC(Diem C) {
        this.C = C;
    }
    public TamGiac(){
        this.A = new Diem();
        this.B = new Diem();
        this.C = new Diem();
    }
    public TamGiac(Diem A, Diem B, Diem C) throws Exception {
        this.A = A;
        this.B = B;
        this.C = C;
        if(!KiemTra(A,B,C))
            throw new Exception("Nhập vào điểm không hợp lệ ! ");
    }
    public TamGiac(int x1,int y1, int x2, int y2, int x3, int y3) throws Exception{
        this.A = new Diem(x1,y1);
        this.B = new Diem(x2,y2);
        this.C = new Diem(x3,y3);
        if(!KiemTra(A,B,C))
            throw new Exception("Nhập vào điểm không hợp lệ ! ");
    }
    private Boolean KiemTra(Diem A, Diem B,Diem C){
        double a,b,c;
        a = A.KhoangCach(B);
        b = B.KhoangCach(C);
        c = C.KhoangCach(A);
        if(a+b>c && b+c>a && c+a>b)
            return true;
        else
            return false;
    }
    public double ChuVi(){
        double a,b,c;
        a = A.KhoangCach(B);
        b = B.KhoangCach(C);
        c = C.KhoangCach(A);
        return a+b+c;
        
    }
    public double DienTich(){
        double a,b,c,p;
        a = A.KhoangCach(B);
        b = B.KhoangCach(C);
        c = C.KhoangCach(A);
        p = (a+b+c)/2;
        return (p*(p-a)*(p-b)*(p-c));
    }
}
