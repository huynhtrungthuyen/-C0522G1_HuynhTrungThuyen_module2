package example;

public class Main {
    public static void main(String[] args) {
        HocVien  hv1  =  new  HocVien( );
        HocVien  hv2  = new SinhVien();
        ChuyenVien  hv3  = new ChuyenVien();
        NVChinhThuc  hv4  =  hv3;
        HocVien  hv5  =  hv3;
        HocVien  hv6  =  (HocVien)  hv2;
        HocVien  hv7  =  new NVQuanLy();
        NVChinhThuc  hv8  =  (NVChinhThuc)  hv7;
        SinhVien  hv9  =  new SinhVien();
        HocVien  hv10  =  new  SinhVien( );
        ChuyenVien  hv11  =  new ChuyenVien();
    }
}
