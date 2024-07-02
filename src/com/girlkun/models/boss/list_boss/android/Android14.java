package com.girlkun.models.boss.list_boss.android;

import com.girlkun.consts.ConstPlayer;
import com.girlkun.models.boss.Boss;
import com.girlkun.models.boss.BossID;
import com.girlkun.models.boss.BossManager;
import com.girlkun.models.boss.BossStatus;
import com.girlkun.models.boss.BossesData;
import com.girlkun.models.map.ItemMap;
import com.girlkun.models.player.Player;
import com.girlkun.server.Manager;
import com.girlkun.services.PlayerService;
import com.girlkun.services.Service;
import com.girlkun.services.TaskService;
import com.girlkun.utils.Util;
import java.util.Random;

public class Android14 extends Boss {

    public boolean callApk13;

    Android13 adr13;
    Android15 adr15;

    public Android14() throws Exception {
        super(BossID.ANDROID_14, BossesData.ANDROID_14);
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
    protected void resetBase() {
        super.resetBase();
        this.callApk13 = false;
        this.adr13 = (Android13) this.getBossAppearTogether()[this.getCurrentLevel()][0];
        this.adr15 = (Android15) this.getBossAppearTogether()[this.getCurrentLevel()][1];
    }

    @Override
    public void active() {
        if (this.typePk == ConstPlayer.NON_PK && !this.callApk13) {
            this.changeToTypePK();
        } else if (this.callApk13 && adr13.typePk == ConstPlayer.PK_ALL) {
            this.changeToTypePK();
        }
        this.attack();
    }

    @Override
    public int injured(Player plAtt, int damage, boolean piercing, boolean isMobAttack) {
        if (!this.callApk13 && this.nPoint.hp - damage <= this.nPoint.hpMax / 2) {
            this.callApk13();
            return 0;
        }
        return super.injured(plAtt, damage, piercing, isMobAttack);
    }

    public void callApk13() {
        if (this.getBossAppearTogether() == null || this.getBossAppearTogether()[this.getCurrentLevel()] == null) {
            return;
        }
        this.adr15.changeToTypeNonPK();
        this.changeToTypeNonPK();
        this.adr15.callApk13 = true;
        this.callApk13 = true;
        this.adr15.recoverHP();
        this.recoverHP();
        this.adr13.changeStatus(BossStatus.RESPAWN);
    }

    public void recoverHP() {
        PlayerService.gI().hoiPhuc(this, this.nPoint.hpMax, 0);
    }

    @Override
    public void doneChatS() {
        if (this.getBossAppearTogether() == null || this.getBossAppearTogether()[this.getCurrentLevel()] == null) {
            return;
        }
        for (Boss boss : this.getBossAppearTogether()[this.getCurrentLevel()]) {
            if (boss.id == BossID.ANDROID_15) {
                boss.changeToTypePK();
                break;
            }
        }
    }

}
