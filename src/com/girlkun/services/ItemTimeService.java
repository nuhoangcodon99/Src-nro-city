package com.girlkun.services;

import com.girlkun.consts.ConstPlayer;
import com.girlkun.models.item.Item;
import static com.girlkun.models.item.ItemTime.*;
import com.girlkun.models.map.ConDuongRanDoc.ConDuongRanDoc;
import com.girlkun.models.map.bando.BanDoKhoBau;
import com.girlkun.models.map.doanhtrai.DoanhTrai;
import com.girlkun.models.player.Fusion;
import com.girlkun.models.player.Player;
import com.girlkun.network.io.Message;
import com.girlkun.services.func.TaiXiu;
import com.girlkun.models.map.KhiGasHuyDiet.KhiGasHuyDiet;
import com.girlkun.models.map.BayTangDiaNguc.BayTangDiaNguc;
import com.girlkun.utils.Logger;
import com.girlkun.models.pariry.pariryManager;


public class ItemTimeService {

    private static ItemTimeService i;

    public static ItemTimeService gI() {
        if (i == null) {
            i = new ItemTimeService();
        }
        return i;
    }

    //gửi cho client
    public void sendAllItemTime(Player player) {
        sendTextDoanhTrai(player);
        sendTextBanDoKhoBau(player);
        if (player.fusion.typeFusion == ConstPlayer.LUONG_LONG_NHAT_THE) {
            sendItemTime(player, player.gender == ConstPlayer.NAMEC ? 3901 : 3790,
                    (int) ((Fusion.TIME_FUSION - (System.currentTimeMillis() - player.fusion.lastTimeFusion)) / 1000));
        }
        if (player.itemTime.isUseBoHuyet) {
            sendItemTime(player, 2755, (int) ((TIME_ITEM - (System.currentTimeMillis() - player.itemTime.lastTimeBoHuyet)) / 1000));
        }
        if (player.itemTime.isUseBoKhi) {
            sendItemTime(player, 2756, (int) ((TIME_ITEM - (System.currentTimeMillis() - player.itemTime.lastTimeBoKhi)) / 1000));
        }
        if (player.itemTime.isUseGiapXen) {
            sendItemTime(player, 2757, (int) ((TIME_ITEM - (System.currentTimeMillis() - player.itemTime.lastTimeGiapXen)) / 1000));
        }
        if (player.itemTime.isUseCuongNo) {
            sendItemTime(player, 2754, (int) ((TIME_ITEM - (System.currentTimeMillis() - player.itemTime.lastTimeCuongNo)) / 1000));
        }
        
        if (player.itemTime.isUseAnDanh) {
            sendItemTime(player, 2760, (int) ((TIME_ITEM - (System.currentTimeMillis() - player.itemTime.lastTimeAnDanh)) / 1000));
        }
        if (player.itemTime.isUseBoHuyetSC) {
            sendItemTime(player, 10714, (int) ((TIME_ITEM - (System.currentTimeMillis() - player.itemTime.lastTimeBoHuyetSC)) / 1000));
        }
        if (player.itemTime.isUseBoKhiSC) {
            sendItemTime(player, 10715, (int) ((TIME_ITEM - (System.currentTimeMillis() - player.itemTime.lastTimeBoKhiSC)) / 1000));
        }
        if (player.itemTime.isUseGiapXenSC) {
            sendItemTime(player, 10712, (int) ((TIME_ITEM - (System.currentTimeMillis() - player.itemTime.lastTimeGiapXenSC)) / 1000));
        }
        
        if (player.itemTime.isUseCuongNoSC) {
            sendItemTime(player, 10716, (int) ((TIME_ITEM - (System.currentTimeMillis() - player.itemTime.lastTimeCuongNoSC)) / 1000));
        }
        if (player.itemTime.isUseAnDanhSC) {
            sendItemTime(player, 10717, (int) ((TIME_ITEM - (System.currentTimeMillis() - player.itemTime.lastTimeAnDanhSC)) / 1000));
        }
        if (player.itemTime.isOpenPower) {
            sendItemTime(player, 3783, (int) ((TIME_OPEN_POWER - (System.currentTimeMillis() - player.itemTime.lastTimeOpenPower)) / 1000));
        }
        if (player.itemTime.isUseMayDo) {
            sendItemTime(player, 2758, (int) ((TIME_MAY_DO - (System.currentTimeMillis() - player.itemTime.lastTimeUseMayDo)) / 1000));
        }
        if (player.itemTime.isUse1trung) {
            sendItemTime(player, 4042, (int) ((TIME_BANH - (System.currentTimeMillis() - player.itemTime.lastTime1trung)) / 1000));
        }
        if (player.itemTime.isUse2trung) {
            sendItemTime(player, 4043, (int) ((TIME_BANH - (System.currentTimeMillis() - player.itemTime.lastTime2trung)) / 1000));
        }
        if (player.itemTime.isUseDacbiet) {
            sendItemTime(player, 4125, (int) ((TIME_BANH - (System.currentTimeMillis() - player.itemTime.lastTimeDacbiet)) / 1000));
        }
        if (player.itemTime.isUseMayDo2) {//2758 icon// cai nay time co cho bằng cái máy dò kia ko
            sendItemTime(player, 2758, (int) ((TIME_MAY_DO2 - (System.currentTimeMillis() - player.itemTime.lastTimeUseMayDo2)) / 1000));
        }
        if (player.itemTime.isUseMayDo3) {//2758 icon// cai nay time co cho bằng cái máy dò kia ko
            sendItemTime(player, 16173, (int) ((TIME_MAY_DO3 - (System.currentTimeMillis() - player.itemTime.lastTimeUseMayDo3)) / 1000));
        }
         if(player.effectSkill.isBienHinh && player.effectSkill.lastTimeBienHinh>=0) {
               sendItemTime(player, 30011, (int) ((150000 - (System.currentTimeMillis() - player.effectSkill.lastTimeBienHinh)) / 1000));
        }
        if (player.itemTime.isEatMeal) {
            sendItemTime(player, player.itemTime.iconMeal, (int) ((TIME_EAT_MEAL - (System.currentTimeMillis() - player.itemTime.lastTimeEatMeal)) / 1000));
        }
        if (player.itemTime.isUseTDLT) {
            sendItemTime(player, 4387,player.itemTime.timeTDLT / 1000);
        }
        if (player.itemTime.istrbhp) {
            sendItemTime(player, 2281, (int) ((TIME_TRB - (System.currentTimeMillis() - player.itemTime.lastTimetrbhp)) / 1000));
        }
        if (player.itemTime.istrbki) {
            sendItemTime(player, 2282, (int) ((TIME_TRB - (System.currentTimeMillis() - player.itemTime.lastTimetrbki)) / 1000));
        }
        if (player.itemTime.istrbsd) {
            sendItemTime(player, 2280, (int) ((TIME_TRB - (System.currentTimeMillis() - player.itemTime.lastTimetrbsd)) / 1000));
        }

    }

    //bật tđlt
    public void turnOnTDLT(Player player, Item item) {
        int min = 0;
        for (Item.ItemOption io : item.itemOptions) {
            if (io.optionTemplate.id == 1) {
                min = io.param;
                io.param = 0;
                break;
            }
        }
        player.itemTime.isUseTDLT = true;
        player.itemTime.timeTDLT = min * 60 * 1000;
        player.itemTime.lastTimeUseTDLT = System.currentTimeMillis();
        sendCanAutoPlay(player);
        sendItemTime(player, 4387, player.itemTime.timeTDLT / 1000);
        InventoryServiceNew.gI().sendItemBags(player);
    }


    //tắt tđlt
    public void turnOffTDLT(Player player, Item item) {
        player.itemTime.isUseTDLT = false;
        for (Item.ItemOption io : item.itemOptions) {
            if (io.optionTemplate.id == 1) {
                io.param += (short) ((player.itemTime.timeTDLT - (System.currentTimeMillis() - player.itemTime.lastTimeUseTDLT)) / 60 / 1000);
                break;
            }
        }
        sendCanAutoPlay(player);
        removeItemTime(player, 4387);
        InventoryServiceNew.gI().sendItemBags(player);
    }

    public void sendCanAutoPlay(Player player) {
        Message msg;
        try {
            msg = new Message(-116);
            msg.writer().writeByte(player.itemTime.isUseTDLT ? 1 : 0);
            player.sendMessage(msg);
        } catch (Exception e) {
            Logger.logException(ItemTimeService.class, e);
        }
    }

    public void sendTextDoanhTrai(Player player) {
        if (player.clan != null && !player.clan.doanhTrai_haveGone
                && player.clan.timeOpenDoanhTrai != 0) {
            int secondPassed = (int) ((System.currentTimeMillis() - player.clan.timeOpenDoanhTrai) / 1000);
            int secondsLeft = (DoanhTrai.TIME_DOANH_TRAI / 1000) - secondPassed;
            sendTextTime(player, DOANH_TRAI, "Doanh trại độc nhãn", secondsLeft);
            if (secondsLeft <=0 || secondsLeft > 1800){
                removeTextDoanhTrai(player);
            }
        }
    }
    public void sendTextKhiGaHuyDiet(Player player) {
        if (player.clan != null && !player.clan.haveGoneKhiGaHuyDiet
                && player.clan.timeOpenKhiGaHuyDiet != 0) {
            int secondPassed = (int) ((System.currentTimeMillis() - player.clan.timeOpenKhiGaHuyDiet) / 1000);
            int secondsLeft = (KhiGasHuyDiet.TIME_KHI_GA_HUY_DIET / 1000) - secondPassed;
            sendTextTime(player, KHI_GA_HUY_DIET, "Khí gas hủy diệt: ", secondsLeft);
        }
    }
    
    public void sendTextBayTangDiaNguc(Player player) {
        if (player.clan != null && !player.clan.haveGoneBayTangDiaNguc
                && player.clan.timeOpenBayTangDiaNguc != 0) {
            int secondPassed = (int) ((System.currentTimeMillis() - player.clan.timeOpenBayTangDiaNguc) / 1000);
            int secondsLeft = (BayTangDiaNguc.TIME_BAY_TANG_DIA_NGUC / 1000) - secondPassed;
            sendTextTime(player, BAY_TANG_DIA_NGUC, "Bảy tầng địa ngục: ", secondsLeft);
        }
    }
    

public void sendTextConDuongRanDoc(Player player) {
        if (player.clan != null && !player.clan.haveGoneConDuongRanDoc
                && player.clan.timeOpenConDuongRanDoc != 0) {
            int secondPassed = (int) ((System.currentTimeMillis() - player.clan.timeOpenConDuongRanDoc) / 1000);
            int secondsLeft = (ConDuongRanDoc.TIME_CON_DUONG_RAN_DOC / 1000) - secondPassed;
            sendTextTime(player, CON_DUONG_RAN_DOC, "Con đường rắn độc: ", secondsLeft);
        }
    }

//    public void sendTextGas(Player player) {
//        if (player.clan != null
//                && player.clan.timeOpenKhiGas != 0) {
//            int secondPassed = (int) ((System.currentTimeMillis() - player.clan.timeOpenKhiGas) / 1000);
//            int secondsLeft = (KhiGaHuyDiet.TIME_KHI_GAS / 1000) - secondPassed;
//            sendTextTime(player, KHI_GASS, "Khí Gas Hủy Diệt: ", secondsLeft);
//        }
//    }
//public void removeTextKhiGas(Player player) {
//        removeTextTime(player, KHI_GASS );
//    }
    public void sendTextTX(Player player) {
        if (TaiXiu.gI().goldTai > 0 || TaiXiu.gI().goldXiu > 0) {
            int secondsLeft = (int) ((TaiXiu.gI().lastTimeEnd - System.currentTimeMillis())/1000);
            sendTextTime(player, TX, "Tài Xỉu", secondsLeft);
            if (secondsLeft <=0){
                removeTextTX(player);
            }
        }
    }
    public void removeTextTX(Player player) {
        removeTextTime(player, TX);
    }
public void sendTextCL(Player player) {
        if (pariryManager.gI().goldChan > 0 || pariryManager.gI().goldLe > 0) {
            int secondsLeft = (int) (pariryManager.time);
            sendTextTime(player, CL, "Chẵn Lẻ", secondsLeft);
            if (secondsLeft <=0){
                removeTextCL(player);
            }
        }
    }
    public void removeTextCL(Player player) {
        removeTextTime(player, CL);
    }

    public void sendTextBanDoKhoBau(Player player) {
        if (player.clan != null
                && player.clan.timeOpenBanDoKhoBau != 0) {
            int secondPassed = (int) ((System.currentTimeMillis() - player.clan.timeOpenBanDoKhoBau) / 1000);
            int secondsLeft = (BanDoKhoBau.TIME_BAN_DO_KHO_BAU / 1000) - secondPassed;
            sendTextTime(player, BAN_DO_KHO_BAU, "Bản đồ kho báu", secondsLeft);
        }
    }
   
    
    
    public void removeTextDoanhTrai(Player player) {
        removeTextTime(player, DOANH_TRAI);
    }
 
    
    
    public void removeTextTime(Player player, byte id) {
        sendTextTime(player, id, "", 0);
    }

    public void sendTextTime(Player player, byte id, String text, int seconds) {
        Message msg;
        try {
            msg = new Message(65);
            msg.writer().writeByte(id);
            msg.writer().writeUTF(text);
            msg.writer().writeShort(seconds);
            player.sendMessage(msg);
            msg.cleanup();
        } catch (Exception e) {
        }
    }
    

    public void sendItemTime(Player player, int itemId, int time) {
        Message msg;
        try {
            msg = new Message(-106);
            msg.writer().writeShort(itemId);
            msg.writer().writeShort(time);
            player.sendMessage(msg);
            msg.cleanup();
        } catch (Exception e) {
        }
    }

    public void removeItemTime(Player player, int itemTime) {
        sendItemTime(player, itemTime, 0);
    }

}
