
package com.girlkun.server;

import java.time.LocalTime;
import com.girlkun.utils.Logger;
import java.io.IOException;
/**
 *
 * @author nguyenduclong
 */
public class AutoMaintenance extends Thread {
    
    public static boolean AutoMaintenance = true;//Bat/tat bao tri tu dong
    public static final int hours = 21;//Gio bao tri
    public static final int mins = 8;//Phu bao tri
    private static AutoMaintenance instance;
    public static boolean isRunning;
    public static boolean startImmediately;


    public static AutoMaintenance gI(){
        if(instance == null){
            instance = new AutoMaintenance();
        
        }
        return instance;
    }
    @Override
    public void run() {
        while (!Maintenance.isRuning && !isRunning){
            try{
                if(AutoMaintenance){
                    LocalTime currentTime = LocalTime.now();
                    if ( currentTime.getHour() == hours && currentTime.getMinute() == mins){
                        Logger.log(Logger.PURPLE, "Đang tiến hành quá trình bảo trì tự động\n");
                        Maintenance.gI().start(60);
                        isRunning = true;
                        AutoMaintenance = false;
                    }
                }
                Thread.sleep(1000);
                
            } catch (Exception e){
                
            }
            }
        }
        
        public static void runBatchFile(String batchFilePath) throws IOException {
            ProcessBuilder processBuilder = new ProcessBuilder("cmd","/c","start", batchFilePath);
            Process process = processBuilder.start();
            try{
                process.waitFor();
            }catch (Exception e){
            
            }
        
        }
    }

