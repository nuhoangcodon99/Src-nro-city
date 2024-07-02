package com.girlkun.models.boss.list_boss.android;

import com.girlkun.consts.ConstPlayer;
import com.girlkun.models.boss.Boss;
import com.girlkun.models.boss.BossID;
import com.girlkun.models.boss.BossManager;
import com.girlkun.models.boss.BossesData;
import com.girlkun.models.map.ItemMap;
import com.girlkun.models.player.Player;
import com.girlkun.server.Manager;
import com.girlkun.services.PlayerService;
import com.girlkun.services.Service;
import com.girlkun.services.TaskService;
import com.girlkun.utils.Util;
import java.util.Random;

public class Android15 extends Boss {

    public boolean callApk13;
    
    public Boss adr14;
    public Boss adr13;

    public Android15() throws Exception {
        super(BossID.ANDROID_15, BossesData.ANDROID_15);
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
        this.adr14 = this.getParentBoss();
        this.adr13 = this.getParentBoss().getBossAppearTogether()[this.getCurrentLevel()][0];
    }

    @Override
    public void active() {
        if (!this.callApk13 && adr14.typePk == ConstPlayer.PK_ALL) {
            this.changeToTypePK();
        }else if(this.callApk13 && adr13.typePk == ConstPlayer.PK_ALL){
            this.changeToTypePK();
        }
        this.attack();
    }

    @Override
    public int injured(Player plAtt, int damage, boolean piercing, boolean isMobAttack) {
        if (!this.callApk13 && this.nPoint.hp - damage <= this.nPoint.hpMax / 2) {
            if (this.getParentBoss() != null) {
                ((Android14) this.getParentBoss()).callApk13();
            }
            return 0;
        }
        return super.injured(plAtt, damage, piercing, isMobAttack);
    }

    public void recoverHP() {
        PlayerService.gI().hoiPhuc(this, this.nPoint.hpMax, 0);
    }
}

/**
 * Vui lòng không sao chép mã nguồn này dưới mọi hình thức. Hãy tôn trọng tác
 * giả của mã nguồn này. Xin cảm ơn! - GirlBeo
 */
