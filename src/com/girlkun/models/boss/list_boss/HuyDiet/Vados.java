package com.girlkun.models.boss.list_boss.HuyDiet;

import com.girlkun.models.boss.Boss;
import static com.girlkun.models.boss.BossID.THIEN_SU_VADOS;
import com.girlkun.models.boss.BossStatus;
import com.girlkun.models.boss.BossesData;
import com.girlkun.models.map.ItemMap;
import com.girlkun.models.player.Player;
import com.girlkun.server.Manager;
import com.girlkun.services.EffectSkillService;
import com.girlkun.services.Service;
import com.girlkun.utils.Util;
import java.util.Random;


public class Vados extends Boss {

public Vados() throws Exception {
        super(THIEN_SU_VADOS, BossesData.vados,BossesData.champa);
    }

    @Override
    public void reward(Player plKill) {
       int[] itemDos = new int[]{1108};
        int randomDo = new Random().nextInt(itemDos.length);
        if (Util.isTrue(50, 100)) {
            Service.gI().dropItemMap(this.zone, Util.useItem2(zone, itemDos[randomDo], 1, this.location.x, this.location.y, plKill.id));
         }
    }
    
    @Override
    public void moveTo(int x, int y) {
        if (this.currentLevel == 1) {
            return;
        }
        super.moveTo(x, y);
    }


    @Override
    protected void notifyJoinMap() {
        if (this.currentLevel == 1) {
            return;
        }
        super.notifyJoinMap();
    }
    @Override
    public void active() {
        super.active(); //To change body of generated methods, choose Tools | Templates.
        if (Util.canDoWithTime(st, 300000)) {
            this.changeStatus(BossStatus.LEAVE_MAP);
        }
    }

    @Override
    public void joinMap() {
        super.joinMap(); //To change body of generated methods, choose Tools | Templates.
        st = System.currentTimeMillis();
    }
    private long st;
}

/**
 * Vui lòng không sao chép mã nguồn này dưới mọi hình thức. Hãy tôn trọng tác
 * giả của mã nguồn này. Xin cảm ơn! - Girlkun75
 */