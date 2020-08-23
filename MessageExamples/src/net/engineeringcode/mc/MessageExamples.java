package net.engineeringcode.mc;

import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class MessageExamples extends JavaPlugin {
	Logger logger = getServer().getLogger();
	Timer timerForAnnouncement = new Timer();
	Timer timeForWhisper = new Timer();
	
	@Override
	public void onEnable() {
		super.onEnable();
		logger.info("onEnable() 메세지 예제 플러그인");
		logger.info("onEnable() Message Examples Plugin");
		
		// 일정 주기로 공지사항을 전파하기 위한 타이머. 타이머 시작 후 5초 후 부터 실행되며 그 이후는 30초 마다 실행된다.
		timerForAnnouncement.schedule(new TimerTask() {
			@Override
			public void run() {
				sendAnnouncement();
			}
		}, 5000, 30000);
		timeForWhisper.schedule(new TimerTask() {
			@Override
			public void run() {
				sendWhisper();
			}
		}, 5000, 10000);
	}
	
	@Override
	public void onLoad() {
		super.onLoad();
		logger.info("onLoad() 메세지 예제 플러그인");
		logger.info("onLoad() Message Examples Plugin");
	}
	
	@Override
	public void onDisable() {
		super.onDisable();
		logger.info("onDisable() 메세지 예제 플러그인");
		logger.info("onDisable() Message Examples Plugin");
	}
	
	/**
	 * 메시지를 하나 뽑아서 공지하는 플러그인입니다.
	 * Pick one message for announcement 
	 */
	public void sendAnnouncement() {
		// 랜덤 숫자를 뽑기 위한 Random 객체 생성
		Random random = new Random(System.currentTimeMillis());
		// 랜덤 숫자를 뽑아서 숫자에 해당하는 메시지를 공지(Broadcast)한다. 
		switch (random.nextInt(3)) {
		case 0:
			getServer().broadcastMessage("§0메세지1"); // §16진수숫자 는 마인크래프트 채팅 색 코드이다.
			getServer().broadcastMessage("§0Message1");
			break;
		case 1:
			getServer().broadcastMessage("§1메세지2");
			getServer().broadcastMessage("§1Message2");
			break;
		case 2:
			getServer().broadcastMessage("§2메세지3");
			getServer().broadcastMessage("§2Message3");
			break;
		default:
			getServer().broadcastMessage("§f예상하지 못 했던 값이 나왔습니다.");
			getServer().broadcastMessage("§fUnexpected value.");
			break;
		}
	}
	
	public void sendWhisper() {
		List<Player> playerList = (List<Player>) getServer().getOnlinePlayers();
		
		// 서버에 사람이 없으면 동작을 중단한다.
		if(playerList==null||playerList.size()==0) {
			return;
		}
		
		// 랜덤 숫자를 뽑기 위한 Random 객체 생성
		Random random = new Random(System.currentTimeMillis());
		
		// 랜덤 숫자를 뽑아서 숫자에 해당하는 메시지를 공지(Broadcast)한다. 
		int playerNumber = random.nextInt(playerList.size());
		playerList.get(playerNumber).sendMessage("축하합니다. "+playerList.size()+"명 중 1명에게 주어지는 행운! 서버의 귓속말!");
		playerList.get(playerNumber).sendMessage("Congraturation. This is an opportunity for only one of "+playerList.size()+" people! Server's whisper!");
	}
}
