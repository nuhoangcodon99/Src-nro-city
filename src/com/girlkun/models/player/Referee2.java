package com.girlkun.models.player;//nguyen the anh
//nguyen the anh
import com.girlkun.models.shop.ShopServiceNew;//nguyen the anh
import com.girlkun.services.MapService;//nguyen the anh
import com.girlkun.consts.ConstMap;//nguyen the anh
import com.girlkun.consts.ConstPlayer;//nguyen the anh
import com.girlkun.models.map.Map;
import com.girlkun.models.map.Zone;
import com.girlkun.server.Manager;
import com.girlkun.services.MapService;
import com.girlkun.services.PlayerService;
import com.girlkun.services.Service;
import com.girlkun.services.SkillService;
import com.girlkun.utils.SkillUtil;
import com.girlkun.utils.Util;
// đây
import java.util.ArrayList;
import java.util.List;

/**
 * @author Duy Béo
 */
public class Referee2 extends Player {

    private long lastTimeChat;
    private Player playerTarget;

    private long lastTimeTargetPlayer;
    private long timeTargetPlayer = 5000;
    private long lastZoneSwitchTime;
    private long zoneSwitchInterval;
    private List<Zone> availableZones;

    public void initReferee2() {
        init();
    }

    @Override
    public short getHead() {
        return 114;
    }

    @Override
    public short getBody() {
        return 115;
    }

    @Override
    public short getLeg() {
        return 116;
    }

    public void joinMap(Zone z, Player player) {
        MapService.gI().goToMap(player, z);
        z.load_Me_To_Another(player);
    }
    public void changeToTypePK() {
        PlayerService.gI().changeAndSendTypePK(this, ConstPlayer.PK_ALL);
    }
    public void active() {
        if (this.typePk == ConstPlayer.NON_PK) {
            this.changeToTypePK();
        }
    }

    protected long lastTimeAttack;
    //nguyen the anh

    @Override
    public void update() {
        active();
        if(this.isDie()){
            Service.getInstance().sendMoney(this);
            PlayerService.gI().hoiSinh(this);
            Service.getInstance().hsChar(this, this.nPoint.hpMax, this.nPoint.mpMax);
            PlayerService.gI().sendInfoHpMp(this);
        }
    }

    private void init() {
        int id = -1000000;
        for (Map m : Manager.MAPS) {
            if (m.mapId == 5) {
               for (Zone z : m.zones) {
                    Referee2 pl = new Referee2();
                    pl.name = "Test Dame";
                    pl.gender = 0;
                    pl.id = id++;
                    pl.nPoint.hpMax = 2000000000;
                    pl.nPoint.hpg = 2000000000;
                    pl.nPoint.hp = 2000000000;
                    pl.nPoint.setFullHpMp();
                    pl.location.x = 240;
                    pl.location.y = 288;
                    pl.cFlag = (byte) Util.nextInt(1, 8);
                    Service.gI().changeFlag(pl, pl.cFlag);
                    joinMap(z, pl);
                    z.setReferee(pl);
              }
            }
        }
    }
}