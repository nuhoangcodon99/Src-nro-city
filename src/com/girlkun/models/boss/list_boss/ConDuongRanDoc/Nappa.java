package com.girlkun.models.boss.list_boss.ConDuongRanDoc;

import com.girlkun.models.boss.list_boss.KhiGasHuyDiet.*;
import com.girlkun.models.boss.list_boss.BanDoKhoBau.*;
import com.girlkun.models.boss.BossData;
import com.girlkun.models.boss.BossManager;
import com.girlkun.models.boss.BossID;
import com.girlkun.models.boss.Boss;
import com.girlkun.consts.ConstPlayer;
import com.girlkun.models.boss.list_boss.DoanhTraiDocNhan.NinjaAoTimClone;
import com.girlkun.models.item.Item;
import static com.girlkun.models.item.ItemTime.CON_DUONG_RAN_DOC;
import com.girlkun.models.map.bando.BanDoKhoBau;
import com.girlkun.models.map.ItemMap;
import com.girlkun.models.map.Zone;
import com.girlkun.models.player.Player;
import com.girlkun.models.skill.Skill;
import com.girlkun.services.EffectSkillService;
import com.girlkun.services.ItemTimeService;
import com.girlkun.services.Service;
import com.girlkun.services.func.ChangeMapService;
import com.girlkun.utils.Util;


public class Nappa extends Boss {
    private static final int[][] FULL_DEMON = new int[][]{{Skill.DEMON, 1}, {Skill.DEMON, 2}, {Skill.DEMON, 3}, {Skill.DEMON, 4}, {Skill.DEMON, 5}, {Skill.DEMON, 6}, {Skill.DEMON, 7}};
    private int levell;

    public Nappa(Zone zone , int level, int dame, int hp) throws Exception {
        super(BossID.ANDROID_13, new BossData(
                "Nađíc",
                ConstPlayer.TRAI_DAT,
                new short[]{648, 649, 650, -1, -1, -1},
                ((10000 + dame) * level),
                new int[]{((5000000 + hp) * level)},
                new int[]{103},
                (int[][]) Util.addArray(FULL_DEMON),
                new String[]{},
                new String[]{"|-1|Nhóc con"},
                new String[]{},
                60
        ));
        this.zone = zone;
    }

    @Override
    public void reward(Player plKill) {
        if (levell < 20) {
            if (Util.isTrue(10, 100)) {
            ItemMap itemMap;
            itemMap = Util.ratiItem(zone, 1989, 1, this.location.x, this.location.y, plKill.id);
            itemMap.options.add(new Item.ItemOption(50, Util.nextInt(10, 15)));
            itemMap.options.add(new Item.ItemOption(77, Util.nextInt(20, 25)));
            itemMap.options.add(new Item.ItemOption(103, Util.nextInt(10, 15)));
            itemMap.options.add(new Item.ItemOption(30, 0));
            Service.getInstance().dropItemMap(this.zone, itemMap);
            for (Player pl : plKill.clan.membersInGame) {
                ItemTimeService.gI().sendTextTime(pl, (byte) CON_DUONG_RAN_DOC, "Con đường rắn độc sắp kết thúc : ", 30);
                ChangeMapService.gI().goToHome(pl);
                pl.clan.ConDuongRanDoc = null;
                pl.clan.gobosscdrd = false;
                pl.clan.haveGoneConDuongRanDoc = true;
            }  
        } else {
            ItemMap itemMap;
            itemMap = Util.ratiItem(zone, 1989, 1, this.location.x, this.location.y, plKill.id);
            itemMap.options.add(new Item.ItemOption(50, Util.nextInt(10, 15)));
            itemMap.options.add(new Item.ItemOption(77, Util.nextInt(20, 25)));
            itemMap.options.add(new Item.ItemOption(103, Util.nextInt(10, 15)));
            itemMap.options.add(new Item.ItemOption(93, Util.nextInt(1, 7)));
            itemMap.options.add(new Item.ItemOption(30, 0));
            Service.getInstance().dropItemMap(this.zone, itemMap);
            for (Player pl : plKill.clan.membersInGame) {
                ItemTimeService.gI().sendTextTime(pl, (byte) CON_DUONG_RAN_DOC, "Con đường rắn độc sắp kết thúc : ", 30);
                ChangeMapService.gI().goToHome(pl);
                pl.clan.ConDuongRanDoc = null;
                pl.clan.gobosscdrd = false;
                pl.clan.haveGoneConDuongRanDoc = true;
            }  
        }  
        } else if (levell <= 50 && levell >= 20) {
            if (Util.isTrue(10, 100)) {
            ItemMap itemMap;
            itemMap = Util.ratiItem(zone, 1989, 1, this.location.x, this.location.y, plKill.id);
            itemMap.options.add(new Item.ItemOption(50, Util.nextInt(15, 20)));
            itemMap.options.add(new Item.ItemOption(77, Util.nextInt(25, 30)));
            itemMap.options.add(new Item.ItemOption(103, Util.nextInt(15, 20)));
            itemMap.options.add(new Item.ItemOption(30, 0));
            Service.getInstance().dropItemMap(this.zone, itemMap);
            for (Player pl : plKill.clan.membersInGame) {
                ItemTimeService.gI().sendTextTime(pl, (byte) CON_DUONG_RAN_DOC, "Con đường rắn độc sắp kết thúc : ", 30);
                ChangeMapService.gI().goToHome(pl);
                pl.clan.ConDuongRanDoc = null;
                pl.clan.gobosscdrd = false;
                pl.clan.haveGoneConDuongRanDoc = true;
            }  
        } else {
            ItemMap itemMap;
            itemMap = Util.ratiItem(zone, 1989, 1, this.location.x, this.location.y, plKill.id);
            itemMap.options.add(new Item.ItemOption(50, Util.nextInt(15, 20)));
            itemMap.options.add(new Item.ItemOption(77, Util.nextInt(25, 30)));
            itemMap.options.add(new Item.ItemOption(103, Util.nextInt(15, 20)));
            itemMap.options.add(new Item.ItemOption(93, Util.nextInt(1, 7)));
            itemMap.options.add(new Item.ItemOption(30, 0));
            Service.getInstance().dropItemMap(this.zone, itemMap);
            for (Player pl : plKill.clan.membersInGame) {
                ItemTimeService.gI().sendTextTime(pl, (byte) CON_DUONG_RAN_DOC, "Con đường rắn độc sắp kết thúc : ", 30);
                ChangeMapService.gI().goToHome(pl);
                pl.clan.ConDuongRanDoc = null;
                pl.clan.gobosscdrd = false;
                pl.clan.haveGoneConDuongRanDoc = true;
            }  
        }  
        } else if (levell > 50 && levell < 100) {
            if (Util.isTrue(10, 100)) {
            ItemMap itemMap;
            itemMap = Util.ratiItem(zone, 1989, 1, this.location.x, this.location.y, plKill.id);
            itemMap.options.add(new Item.ItemOption(50, Util.nextInt(20, 25)));
            itemMap.options.add(new Item.ItemOption(77, Util.nextInt(30, 35)));
            itemMap.options.add(new Item.ItemOption(103, Util.nextInt(20, 25)));
            itemMap.options.add(new Item.ItemOption(30, 0));
            Service.getInstance().dropItemMap(this.zone, itemMap);
            for (Player pl : plKill.clan.membersInGame) {
                ItemTimeService.gI().sendTextTime(pl, (byte) CON_DUONG_RAN_DOC, "Con đường rắn độc sắp kết thúc : ", 30);
                ChangeMapService.gI().goToHome(pl);
                pl.clan.ConDuongRanDoc = null;
                pl.clan.gobosscdrd = false;
                pl.clan.haveGoneConDuongRanDoc = true;
            }  
        } else {
            ItemMap itemMap;
            itemMap = Util.ratiItem(zone, 1989, 1, this.location.x, this.location.y, plKill.id);
            itemMap.options.add(new Item.ItemOption(50, Util.nextInt(20, 25)));
            itemMap.options.add(new Item.ItemOption(77, Util.nextInt(30, 35)));
            itemMap.options.add(new Item.ItemOption(103, Util.nextInt(20, 25)));
            itemMap.options.add(new Item.ItemOption(93, Util.nextInt(1, 7)));
            itemMap.options.add(new Item.ItemOption(30, 0));
            Service.getInstance().dropItemMap(this.zone, itemMap);
            for (Player pl : plKill.clan.membersInGame) {
                ItemTimeService.gI().sendTextTime(pl, (byte) CON_DUONG_RAN_DOC, "Con đường rắn độc sắp kết thúc : ", 30);
                ChangeMapService.gI().goToHome(pl);
                pl.clan.ConDuongRanDoc = null;
                pl.clan.gobosscdrd = false;
                pl.clan.haveGoneConDuongRanDoc = true;
            }  
        } 
        } else if (levell <= 110 && levell >= 100) {
            if (Util.isTrue(10, 100)) {
            ItemMap itemMap;
            itemMap = Util.ratiItem(zone, 1989, 1, this.location.x, this.location.y, plKill.id);
            itemMap.options.add(new Item.ItemOption(50, Util.nextInt(25, 30)));
            itemMap.options.add(new Item.ItemOption(77, Util.nextInt(35, 40)));
            itemMap.options.add(new Item.ItemOption(103, Util.nextInt(25, 30)));
            itemMap.options.add(new Item.ItemOption(30, 0));
            Service.getInstance().dropItemMap(this.zone, itemMap);
            for (Player pl : plKill.clan.membersInGame) {
                ItemTimeService.gI().sendTextTime(pl, (byte) CON_DUONG_RAN_DOC, "Con đường rắn độc sắp kết thúc : ", 30);
                ChangeMapService.gI().goToHome(pl);
                pl.clan.ConDuongRanDoc = null;
                pl.clan.gobosscdrd = false;
                pl.clan.haveGoneConDuongRanDoc = true;
            }  
        } else {
            ItemMap itemMap;
            itemMap = Util.ratiItem(zone, 1989, 1, this.location.x, this.location.y, plKill.id);
            itemMap.options.add(new Item.ItemOption(50, Util.nextInt(25, 30)));
            itemMap.options.add(new Item.ItemOption(77, Util.nextInt(35, 40)));
            itemMap.options.add(new Item.ItemOption(103, Util.nextInt(25, 30)));
            itemMap.options.add(new Item.ItemOption(93, Util.nextInt(1, 7)));
            itemMap.options.add(new Item.ItemOption(30, 0));
            Service.getInstance().dropItemMap(this.zone, itemMap);
            for (Player pl : plKill.clan.membersInGame) {
                ItemTimeService.gI().sendTextTime(pl, (byte) CON_DUONG_RAN_DOC, "Con đường rắn độc sắp kết thúc : ", 30);
                ChangeMapService.gI().goToHome(pl);
                pl.clan.ConDuongRanDoc = null;
                pl.clan.gobosscdrd = false;
                pl.clan.haveGoneConDuongRanDoc = true;
            }  
        }
        }
    }

    @Override
    public void active() {
        super.active();
    }
    
    @Override
    public int injured(Player plAtt, int damage, boolean piercing, boolean isMobAttack) {
        if (!this.isDie()) {
            if (!piercing && Util.isTrue(this.nPoint.tlNeDon, 1000)) {
                this.chat("Xí hụt");
                return 0;
            }
            damage = this.nPoint.subDameInjureWithDeff(damage/2);
            if (!piercing && effectSkill.isShielding) {
                if (damage > nPoint.hpMax) {
                    EffectSkillService.gI().breakShield(this);
                }
                damage = damage/2;
            }
            this.nPoint.subHP(damage);
            if (this.nPoint.hp == 0) {
                try {
                    
                    new Vegeta(this.zone, plAtt.clan.ConDuongRanDoc.level, Util.nextInt(1000, 10000), BossID.SAIBAMEN_7);
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            if (isDie()) {
this.setDie(plAtt);
die(plAtt);
}
            return damage;
        } else {
            return 0;
        }
    }

    @Override
    public void joinMap() {
        super.joinMap();
    }

    @Override
    public void leaveMap() {
        super.leaveMap();
        BossManager.gI().removeBoss(this);
        this.dispose();
    }
}