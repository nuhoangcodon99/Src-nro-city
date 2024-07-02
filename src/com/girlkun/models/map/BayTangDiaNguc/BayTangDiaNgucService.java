package com.girlkun.models.map.BayTangDiaNguc;
import com.girlkun.models.boss.list_boss.BayTangDiaNguc.Mihac;
import com.girlkun.models.boss.list_boss.BayTangDiaNguc.Minuong;
import com.girlkun.models.player.Player;
import com.girlkun.services.Service;
import com.girlkun.utils.Logger;

/**
 *
 * @author BTH
 *
 */
public class BayTangDiaNgucService {

    private static BayTangDiaNgucService i;

    private BayTangDiaNgucService() {

    }

    public static BayTangDiaNgucService gI() {
        if (i == null) {
            i = new BayTangDiaNgucService();
        }
        return i;
    }
    
    public void openBayTangDiaNguc(Player player, byte level) {
        if (level >= 1 && level <= 110) {
            if (player.clan != null && player.clan.BayTangDiaNguc == null) {
                
                    BayTangDiaNguc bayTangDiaNguc = null;
                    for (BayTangDiaNguc btdn : BayTangDiaNguc.BAY_TANG_DIA_NGUCS) {
                        if (!btdn.isOpened) {
                            bayTangDiaNguc = btdn;
                            break;
                        }
                    }
                    if (bayTangDiaNguc != null) {
                        bayTangDiaNguc.openBayTangDiaNguc(player, player.clan, level);
                        try {
                            long bossDamage = (20 * level);
                            long bossMaxHealth = (2 * level);
                            bossDamage = Math.min(bossDamage, 200000000L);
                            bossMaxHealth = Math.min(bossMaxHealth, 2000000000L);
                            Minuong boss = new Minuong(
                                    player.clan.BayTangDiaNguc.getMapById(183),
                                    player.clan.BayTangDiaNguc.level,
                                    
                                    (int) bossDamage,
                                    (int) bossMaxHealth
                            );
                            Mihac boss2 = new Mihac(
                                    player.clan.BayTangDiaNguc.getMapById(183),
                                    player.clan.BayTangDiaNguc.level,
                                    
                                    (int) bossDamage,
                                    (int) bossMaxHealth
                            );
                        } catch (Exception exception) {
                            Logger.logException(BayTangDiaNgucService.class, exception, "Error initializing boss");
                        }
                    } else {
                        Service.getInstance().sendThongBao(player, "Phó bản mị nương đã đầy, vui lòng quay lại sau");
                    }
                }
            } else {
                Service.getInstance().sendThongBao(player, "Không thể thực hiện");
            }
        } 
    }

