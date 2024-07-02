package com.girlkun.models.boss.list_boss.fide;

import com.girlkun.services.EffectSkillService;
import com.girlkun.models.boss.Boss;
import com.girlkun.models.boss.BossID;
import com.girlkun.models.boss.BossManager;
import com.girlkun.models.boss.BossStatus;
import com.girlkun.models.boss.BossesData;
import com.girlkun.models.map.ItemMap;
import com.girlkun.models.player.Player;
import com.girlkun.server.Manager;
import com.girlkun.services.Service;
import com.girlkun.services.TaskService;
import com.girlkun.utils.Util;
import java.util.Random;

import java.util.Calendar;

public class Fide extends Boss {

    public Fide() throws Exception {
        super(BossID.FIDE, BossesData.FIDE_DAI_CA_1, BossesData.FIDE_DAI_CA_2, BossesData.FIDE_DAI_CA_3);
    }
    
    @Override
      public void reward(Player plKill) {
        byte randomDo = (byte) new Random().nextInt(Manager.itemIds_TL.length - 1);
        byte randomNR = (byte) new Random().nextInt(Manager.itemIds_NR_SB.length);
        if (Util.isTrue(BossManager.ratioReward3, 100)) {
            Service.gI().dropItemMap(this.zone, Util.ratiItem(zone, Manager.itemIds_TL[randomDo], 1, this.location.x, this.location.y, plKill.id));
        } else {
            Service.gI().dropItemMap(this.zone, new ItemMap(zone, Manager.itemIds_NR_SB[randomNR], 1, this.location.x, zone.map.yPhysicInTop(this.location.x, this.location.y - 24), plKill.id));
        }
            TaskService.gI().checkDoneTaskKillBoss(plKill, this);
    }
    @Override
    public void active() {
        super.active(); //To change body of generated methods, choose Tools | Templates.
        //    if(Util.canDoWithTime(st,900000)){
        //        this.changeStatus(BossStatus.LEAVE_MAP);
        //    }
    }

    @Override
    public void joinMap() {
        super.joinMap(); //To change body of generated methods, choose Tools | Templates.
        st = System.currentTimeMillis();
    }
    private long st;

    @Override
    public int injured(Player plAtt, int damage, boolean piercing, boolean isMobAttack) {
        if (!this.isDie()) {
            if (!piercing && Util.isTrue(this.nPoint.tlNeDon, 1)) {
                this.chat("Xí hụt");
                return 0;
            }
            damage = this.nPoint.subDameInjureWithDeff(damage);
            if (!piercing && effectSkill.isShielding) {
                if (damage > nPoint.hpMax) {
                    EffectSkillService.gI().breakShield(this);
                }
                damage = 1;
            }

            final Calendar rightNow = Calendar.getInstance();
            int hour = rightNow.get(11);
            if (hour >= 19 && hour < 20) {
                if (plAtt.playerTask.taskMain.id != 21) {
                    if (damage >= 0) {
                        damage = 0;
					Service.getInstance().sendThongBao(plAtt, "Bây giờ là giờ nhiệm vụ, không phải nhiệm vụ hiện tại của bạn, boss miễn nhiễm sát thương");
                    }
                }
                if (this.name.equals("Fide đại ca 1")) {
                    if (plAtt.playerTask.taskMain.id == 21) {
                        if (plAtt.playerTask.taskMain.index != 1) {
                            if (damage >= 0) {
                                damage = 0;
                                Service.getInstance().sendThongBao(plAtt, "Bây giờ là giờ nhiệm vụ, không phải nhiệm vụ hiện tại của bạn, boss miễn nhiễm sát thương");
                            }
                        }
                    }
                }
                if (this.name.equals("Fide đại ca 2")) {
                    if (plAtt.playerTask.taskMain.id == 21) {
                        if (plAtt.playerTask.taskMain.index != 2) {
                            if (damage >= 0) {
                                damage = 0;
                                Service.getInstance().sendThongBao(plAtt, "Bây giờ là giờ nhiệm vụ, không phải nhiệm vụ hiện tại của bạn, boss miễn nhiễm sát thương");
                            }
                        }
                    }
                }
                if (this.name.equals("Fide đại ca 3")) {
                    if (plAtt.playerTask.taskMain.id == 21) {
                        if (plAtt.playerTask.taskMain.index != 3) {
                            if (damage >= 0) {
                                damage = 0;
                                Service.getInstance().sendThongBao(plAtt, "Bây giờ là giờ nhiệm vụ, không phải nhiệm vụ hiện tại của bạn, boss miễn nhiễm sát thương");
                            }
                        }
                    }
                }
            }
            this.nPoint.subHP(damage);
            if (isDie()) {
                this.setDie(plAtt);
                die(plAtt);
            }
            return damage;
        } else {
            return 0;
        }
    }

}	