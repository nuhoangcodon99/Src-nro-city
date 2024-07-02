package com.girlkun.models.boss.list_boss.android;

import com.girlkun.models.boss.Boss;
import com.girlkun.models.boss.BossID;
import com.girlkun.models.boss.BossManager;
import com.girlkun.models.boss.BossesData;
import com.girlkun.models.map.ItemMap;
import com.girlkun.models.player.Player;
import com.girlkun.server.Manager;
import com.girlkun.services.Service;
import com.girlkun.services.TaskService;
import com.girlkun.utils.Util;
import java.util.Random;


public class Android13 extends Boss {

    public Android13() throws Exception {
        super(BossID.ANDROID_13, BossesData.ANDROID_13);
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
    public void doneChatS() {
        if (this.getParentBoss() == null) {
            return;
        }
        if (this.getParentBoss().getBossAppearTogether() == null
                || this.getParentBoss().getBossAppearTogether()[getParentBoss().getCurrentLevel()] == null) {
            return;
        }
        for (Boss boss : this.getParentBoss().getBossAppearTogether()[getParentBoss().getCurrentLevel()]) {
            if (boss.id == BossID.ANDROID_15 && !boss.isDie()) {
                boss.changeToTypePK();
                break;
            }
        }
        this.getParentBoss().changeToTypePK();
    }

    @Override
    public int injured(Player plAtt, int damage, boolean piercing, boolean isMobAttack) {
        if (damage >= this.nPoint.hp) {
            boolean flag = true;
            if (this.getParentBoss() != null) {
                if (this.getParentBoss().getBossAppearTogether() != null && getParentBoss().getBossAppearTogether()[this.getParentBoss().getCurrentLevel()] != null) {
                    for (Boss boss : this.getParentBoss().getBossAppearTogether()[this.getParentBoss().getCurrentLevel()]) {
                        if (boss.id == BossID.ANDROID_15 && !boss.isDie()) {
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag && !this.getParentBoss().isDie()) {
                    flag = false;
                }
            }
            if (!flag) {
                return 0;
            }
        }
        return super.injured(plAtt, damage, piercing, isMobAttack);
    }
}

