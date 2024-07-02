package com.girlkun.consts;

/**
 *
 * @Stole By Arriety
 *
 */
public class ConstPlayer {
    public static final int[] HEADMONKEY = {192, 195, 196, 199, 197, 200, 198};
    
    // AURA BIẾN HÌNH Ở ĐÂY
    public static final byte[][] AURABIENHINH = {
        {7, 7, 15, 6, 19}, // TD
        {21, 21, 21, 22, 22}, // NM
        {7, 7, 15, 6, 24} // XD
    };
    // SỬA NGOẠI HÌNH TỪ LV 1-5 Ở ĐÂY
    public static final short[][] HEADBIENHINH = {
        {1500, 1503, 1504, 1505, 1506}, // 5 head TD 
        {1507, 1510, 1511, 1512, 1513},// 5 haed NM
        {1514, 1517, 1518, 1519, 1520}, // 5 head XD
    };
    // THÂN NGOẠI HÌNH LV 1-5
    public static final short[] BODYBIENHINH = {1501, 1508, 1515}; // TD /NM/ XD
    public static final short[] LEGBIENHINH = {1502, 1509, 1516}; // TD /NM/ XD

    public static final byte TRAI_DAT = 0;
    public static final byte NAMEC = 1;
    public static final byte XAYDA = 2;

    //type pk
    public static final byte NON_PK = 0;
    public static final byte PK_PVP = 3;
    public static final byte PK_ALL = 5;

    //type fushion
    public static final byte NON_FUSION = 0;
    public static final byte LUONG_LONG_NHAT_THE = 4;
    public static final byte HOP_THE_PORATA = 6;
    public static final byte HOP_THE_PORATA2 = 8;
    public static final byte HOP_THE_PORATA3 = 10;
    public static final byte HOP_THE_PORATA4 = 12;
    public static final byte HOP_THE_PORATA5 = 14;
}
