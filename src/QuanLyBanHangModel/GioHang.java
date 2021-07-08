package QuanLyBanHangModel;

public class GioHang {
    private SanPham sanpham;

    public Integer getChon() {
        return chon;
    }

    @Override
    public String toString() {
        return "GioHang{" +
                "sanpham=" + sanpham +
                ", chon=" + chon +
                ", soluong=" + soluong +
                '}';
    }

    public void setChon(Integer chon) {
        this.chon = chon;
    }

    public GioHang(SanPham sanpham, Integer chon, Integer soluong) {
        this.sanpham = sanpham;
        this.chon = chon;
        this.soluong = soluong;
    }

    private Integer chon;
    private Integer soluong;

    public GioHang(SanPham sanpham) {
        this.sanpham = sanpham;
    }

    public GioHang(SanPham sanpham, Integer soluong) {
        this.sanpham = sanpham;
        this.soluong = soluong;
    }

    public SanPham getSanpham() {
        return sanpham;
    }

    public Integer getSoluong() {
        return soluong;
    }

    public void setSoluong(Integer soluong) {
        this.soluong = soluong;
    }

    public void setSanpham(SanPham sanpham) {
        this.sanpham = sanpham;
    }

    public GioHang() {
    }
}
