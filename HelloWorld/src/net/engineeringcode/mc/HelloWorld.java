package net.engineeringcode.mc;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;

import net.engineeringcode.command.HelloCommand;

public class HelloWorld extends JavaPlugin {
	Logger logger = getServer().getLogger();
	Timer timer = new Timer();
	
	@Override
	public void onEnable() {
		super.onEnable();
		logger.info("onEnable() Example Plugins");
		new HelloCommand(this);
		
		timer.schedule(new TimerTask() {			
			@Override
			public void run() {
				sendAnnouncement();
			}
		}, 5000, 30000);
	}
	
	@Override
	public void onLoad() {
		super.onLoad();
		logger.info("onLoad() Example Plugins");
	}
	
	@Override
	public void onDisable() {
		super.onDisable();
		logger.info("onDisable() Example Plugins");
	}
	
	public void sendAnnouncement() {
		Random random = new Random(System.currentTimeMillis());
		switch (random.nextInt(5)) {
		case 0:
			getServer().broadcastMessage("본 서버는 --이며 홈페이지 주소는 https://--입니다.");
			break;
		case 1:
			getServer().broadcastMessage("현재 서버는 PaperMC를 기반으로 구성되었습니다.");
			break;
		case 2:
			getServer().broadcastMessage("본 관리자는 플러그인 개발을 직접 합니다.");
			break;
		case 3:
			getServer().broadcastMessage("이 메시지가 신경쓰인다면 저에게 메일을 보내주세요. 꺼드릴게요.");
			break;
		case 4:
			getServer().broadcastMessage("즐거운 하루 되세요.");
			break;
		default:
			getServer().broadcastMessage("예상 밖의 숫자가 나타났군요.");
			break;
		}
		
	}
}
