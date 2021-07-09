package Util;

import java.awt.*;
import java.util.ArrayList;

public class MyColor {
    private static ArrayList<Color> listmau= new ArrayList<>();
    public static void initMau()
    {
        listmau.add(new Color(255, 154, 141));
        listmau.add(new Color(145, 191, 191));
        listmau.add(new Color(220, 137, 150));
        listmau.add(new Color(25, 149, 173));
        listmau.add(new Color(76, 170, 246));
        listmau.add(new Color(255, 216, 156));
        listmau.add(Color.MAGENTA);
        listmau.add(Color.YELLOW);
        listmau.add(new Color(79, 217, 55));

        listmau.add(new Color(197, 79, 212));

        listmau.add(new Color(215, 137, 52));

        listmau.add(new Color(54, 154, 206));

        listmau.add(new Color(197, 224, 46));
    }
    public static Color colorVIP = new Color(248, 245, 241);
    public static Color colorDon = new Color(229, 169, 140);
    public static Color colorDoi = new Color(30, 161, 167);
    public static Color colorFull = new Color(76, 170, 246);
    public static Color colorThanhVien = new Color(255, 216, 156);
    public static Color colorThuong = new Color(145, 191, 191);
    public static Color xanhlam = new Color(71, 200, 255);
    public static Color dathanhtoan = new Color(255, 154, 141);
    public static Color chuathanhtoan = new Color(145, 191, 191);
    public static Color nenhoadon = new Color(74, 83, 107);
    public static Color panel1 = Color.WHITE;
    public static Color panel2 = new Color(198, 215, 235);
    public static Color button = new Color(102, 165, 173);
    public static Color getMauBySo(Integer i)
    {
        return listmau.get(i);
    }
    public static Integer getSoByMau(Color color)
    {
        return listmau.indexOf(color);
    }

}
