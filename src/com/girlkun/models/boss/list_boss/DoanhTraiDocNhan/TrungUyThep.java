package com.girlkun.models.boss.list_boss.DoanhTraiDocNhan;;
import java.util.Random;
import com.girlkun.server.Manager;
import com.girlkun.models.boss.BossID;
import com.girlkun.models.boss.Boss;
import com.girlkun.models.boss.BossManager;
import com.girlkun.models.boss.BossData;
import com.girlkun.consts.ConstPlayer;
import com.girlkun.models.map.ItemMap;
import com.girlkun.models.map.Zone;
import com.girlkun.models.player.Player;
import com.girlkun.models.skill.Skill;
import com.girlkun.services.Service;
import com.girlkun.utils.Util;

/**
 * @author BTH sieu cap vippr0
 */
public class TrungUyThep extends Boss {
    private static final int[][] FULL_DEMON = new int[][]{{Skill.DEMON, 1}, {Skill.DEMON, 2}, {Skill.DEMON, 3}, {Skill.DEMON, 4}, {Skill.DEMON, 5}, {Skill.DEMON, 6}, {Skill.DEMON, 7}};

    public TrungUyThep(Zone zone , int dame, int hp) throws Exception {
        super(BossID.TRUNG_UY_THEP, new BossData(
                "Trung úy thép", //name
                ConstPlayer.TRAI_DAT, //gender
                new short[] { 129, 130, 131, -1, -1, -1 }, // outfit {head, body, leg, bag, aura, eff}
                ((1 + dame)), //dame
                new int[]{((1 + hp))}, //hp
                new int[]{55}, //map join
                (int[][]) Util.addArray(FULL_DEMON), //skill
                new String[]{}, //text chat 1
                new String[]{"|-1|Nhóc con"}, //text chat 2
                new String[]{}, //text chat 3
                60
        ));
        this.zone = zone;
    }
    @Override
    public void reward(Player plKill) {
        byte randomNR = (byte) new Random().nextInt(Manager.itemIds_NR.length);
        if (Util.isTrue(15, 100)) {
            if (Util.isTrue(100, 100)) 
            Service.gI().dropItemMap(this.zone,new ItemMap(zone, 611, 1, this.location.x, this.location.y, plKill.id));   
        } else {
            Service.gI().dropItemMap(this.zone, new ItemMap(zone, Manager.itemIds_NR[randomNR], 1, this.location.x, this.location.y, plKill.id));
        }
    }
    @Override
    public void active() {
        super.active();
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





