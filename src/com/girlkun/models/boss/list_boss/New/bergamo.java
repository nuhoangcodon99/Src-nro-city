package com.girlkun.models.boss.list_boss.New;

import com.girlkun.models.boss.Boss;
import com.girlkun.models.boss.BossID;
import com.girlkun.models.boss.BossManager;
import com.girlkun.models.boss.BossStatus;
import com.girlkun.models.boss.BossesData;
import com.girlkun.models.map.ItemMap;
import com.girlkun.models.player.Player;
import com.girlkun.services.EffectSkillService;
import com.girlkun.services.Service;
import com.girlkun.services.TaskService;
import com.girlkun.utils.Util;
import java.util.Random;
import com.girlkun.models.item.Item;
import com.girlkun.server.Manager;
public class bergamo extends Boss {

    public bergamo() throws Exception {
        super(BossID.bergamo, BossesData.bergamo);
    }
   @Override
    public void reward(Player plKill) {
        
        ItemMap itemMap;
        if (Util.isTrue(30, 100)) {
        itemMap = Util.ratiItem(zone,731, 1, this.location.x, this.location.y, plKill.id);
        itemMap.options.add(new Item.ItemOption(50,Util.nextInt(27,30)));
        itemMap.options.add(new Item.ItemOption(77,Util.nextInt(27,30)));
        itemMap.options.add(new Item.ItemOption(103,Util.nextInt(27,30)));
        itemMap.options.add(new Item.ItemOption(93,Util.nextInt(3,30)));
        byte itemc2 = (byte) new Random().nextInt(Manager.itemC2.length - 1);
    } 
    }
    @Override
    public void active() {
        super.active(); //To change body of generated methods, choose Tools | Templates.
        if(Util.canDoWithTime(st,900000)){
            this.changeStatus(BossStatus.LEAVE_MAP);
        }
    }
    @Override
    public void joinMap() {
        super.joinMap(); //To change body of generated methods, choose Tools | Templates.
        st= System.currentTimeMillis();
    }
    private long st;
    
}

/**
 * Vui lòng không sao chép mã nguồn này dưới mọi hình thức. Hãy tôn trọng tác
 * giả của mã nguồn này. Xin cảm ơn! - GirlBeo
 */
