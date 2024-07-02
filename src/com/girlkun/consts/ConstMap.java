package com.girlkun.consts;
import com.girlkun.models.boss.BossID;
import java.util.Arrays;
import java.util.List;

public class ConstMap {

    public static final int TILE_TOP = 2;

    //type map
    public static final byte MAP_NORMAL = 0;
    public static final byte MAP_OFFLINE = 1;
    public static final byte MAP_DOANH_TRAI = 2;
    public static final byte MAP_BLACK_BALL_WAR = 3;
    public static final byte MAP_BAN_DO_KHO_BAU = 4;
    public static final byte MAP_MA_BU = 5;
    public static final byte MAP_KHI_GA_HUY_DIET = 6;
    public static final byte MAP_BAY_TANG_DIA_NGUC = 7;
    public static final byte MAP_CON_DUONG_RAN_DOC = 8;
    public static final byte MAP_HIRU = 9;
    public static final byte MAP_NRO_NAMEC = 10;

    //type change map
    public static final int CHANGE_CAPSULE = 500;
    public static final int CHANGE_BLACK_BALL = 501;
    public static final int CHANGE_MAP_MA_BU = 502;
    public static final int TIME_START_SUPPORT = 12;   
    public static final int TIME_END_SUPPORT = 20;
    public static final List<Integer> LIST_NV_SUPPORT = Arrays.asList(BossID.KUKU, BossID.MAP_DAU_DINH, BossID.RAMBO, BossID.TDST, BossID.FIDE);
    public static final List<Integer> LIST_NV_FIDE = Arrays.asList();    

}
