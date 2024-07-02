package com.girlkun.models.map.BayTangDiaNguc;

import com.girlkun.models.clan.Clan;
import com.girlkun.models.map.TrapMap;
import com.girlkun.models.map.Zone;
import com.girlkun.models.mob.Mob;
import com.girlkun.models.player.Player;
import com.girlkun.services.ItemTimeService;
import com.girlkun.services.MapService;
import com.girlkun.services.Service;
import com.girlkun.services.func.ChangeMapService;
import com.girlkun.utils.Util;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BTH
 */
public class BayTangDiaNguc implements Runnable {

    public static final long POWER_CAN_GO_TO_BTDN = 1;

    public static final List<BayTangDiaNguc> BAY_TANG_DIA_NGUCS;
    public static final int MAX_AVAILABLE = 50;
    public static final int TIME_BAY_TANG_DIA_NGUC = 1800000;

    public static Object gI() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Player player;

    static {
        BAY_TANG_DIA_NGUCS = new ArrayList<>();
        for (int i = 0; i < MAX_AVAILABLE; i++) {
            BAY_TANG_DIA_NGUCS.add(new BayTangDiaNguc(i));
        }
    }

    public int id;
    public byte level;
    public final List<Zone> zones;

    public Clan clan;
    public boolean isOpened;
    private long lastTimeOpen;
    private boolean running;
    private long lastTimeUpdate;

    public BayTangDiaNguc(int id) {
        this.id = id;
        this.zones = new ArrayList<>();
        running = true;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(10000);
                if (Util.canDoWithTime(lastTimeUpdate, 10000)) {
                    update();
                    lastTimeUpdate = System.currentTimeMillis();
                }
            } catch (Exception ignored) {
            }

        }
    }

    public void update() {
        for (BayTangDiaNguc bt : BAY_TANG_DIA_NGUCS) {
            if (bt.isOpened) {
                if (Util.canDoWithTime(lastTimeOpen, TIME_BAY_TANG_DIA_NGUC)) {
                    this.finish();
                }
            }
        }
    }

    public void openBayTangDiaNguc(Player plOpen, Clan clan, byte level) {
        this.level = level;
        this.lastTimeOpen = System.currentTimeMillis();
        this.isOpened = true;
        this.clan = clan;
        this.clan.timeOpenBayTangDiaNguc = this.lastTimeOpen;
        this.clan.playerOpenBayTangDiaNguc = plOpen;
        this.clan.BayTangDiaNguc = this;

        resetBayTang();
        ChangeMapService.gI().goToBTDN(plOpen);
//            ChangeMapService.gI().changeMapBySpaceShip(player, 204, -1, 174);
        sendTextBayTangDiaNguc();
    }

    private void resetBayTang() {
        for (Zone zone : zones) {
            for (TrapMap trap : zone.trapMaps) {
                trap.dame = this.level * 10000;
            }
        }
        for (Zone zone : zones) {
            for (Mob m : zone.mobs) {
                m.initMobBayTangDiaNguc(m, this.level);
                m.hoiSinhMob(m);
                m.hoiSinh();
                m.sendMobHoiSinh();
            }
        }
    }

    //kết thúc Khí Ga Hủy Diệt
    public void finish() {
        List<Player> plOutBTDN = new ArrayList();
        for (Zone zone : zones) {
            List<Player> players = zone.getPlayers();
            for (Player pl : players) {
                plOutBTDN.add(pl);
                kickOutOfBTDN(pl);
            }

        }
        for (Player pl : plOutBTDN) {
            ChangeMapService.gI().changeMapBySpaceShip(pl, 27, -1, 64);
        }


        this.clan.BayTangDiaNguc = null;
        this.clan = null;
        this.isOpened = false;
    }

    private void kickOutOfBTDN(Player player) {
        if (MapService.gI().isMapBayTangDiaNguc(player.zone.map.mapId)) {
            Service.getInstance().sendThongBao(player, "Phó Bản Mị Nương Đã Kết Thúc!");
            ChangeMapService.gI().changeMapBySpaceShip(player, 27, -1, 1038);
            running = false;
            this.clan.BayTangDiaNguc = null;
        }
    }

    public Zone getMapById(int mapId) {
        for (Zone zone : zones) {
            if (zone.map.mapId == mapId) {
                return zone;
            }
        }
        return null;
    }

    public static void addZone(int idBayTang, Zone zone) {
        BAY_TANG_DIA_NGUCS.get(idBayTang).zones.add(zone);
    }

    private void sendTextBayTangDiaNguc() {
        for (Player pl : this.clan.membersInGame) {
            ItemTimeService.gI().sendTextBayTangDiaNguc(pl);
        }
    }
}
