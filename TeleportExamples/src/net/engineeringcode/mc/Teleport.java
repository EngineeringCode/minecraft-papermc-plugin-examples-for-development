package net.engineeringcode.mc;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Teleport extends JavaPlugin {
	Logger logger = getServer().getLogger();
	
	// 주기적으로 플레이어를 순간이동 시키는지 아닌지를 나타내는 변수
	boolean areAllPlayerTeleportedPeriodically = true;
	
	@Override
	public void onEnable() {
		super.onEnable();
		logger.info("onEnable() 순간이동 예제 플러그인");
		logger.info("onEnable() Teleport Examples Plugin");
		
		// 주기적으로 플레이어를 순간이동 시키는 메서드를 호출하는 서버의 스케쥴러(타이머)
		getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			@Override
			public void run() {
				if(areAllPlayerTeleportedPeriodically) {
					teleportAllPlayer(new Location(getServer().getWorld("world"), 322.5, 130.0, 362.5));
				}				
			}
		}, 0, 60);
	}
	
	@Override
	public void onLoad() {
		super.onLoad();
		logger.info("onLoad() 순간이동 예제 플러그인");
		logger.info("onLoad() Teleport Examples Plugin");
	}
	
	@Override
	public void onDisable() {
		super.onDisable();
		logger.info("onDisable() 순간이동 예제 플러그인");
		logger.info("onDisable() Teleport Examples Plugin");
	}
	
	/**
	 * 메시지를 하나 뽑아서 공지하는 플러그인입니다.
	 * Pick one message for announcement 
	 */
	public void teleportAllPlayer(Location location) {
		getServer().broadcastMessage("§0메세지1");
		List<Player> playerList = (List<Player>) getServer().getOnlinePlayers();
		
		// 서버에 사람이 없으면 동작을 중단한다.
		if(playerList==null||playerList.size()==0) {
			return;
		}
		
		// 모든 플레이어를 순간이동 시킨다.
		for (Player player : playerList) {
			if(player.teleport(location)) {
				player.sendMessage("서버가 당신을 순간이동 시켰습니다.");
			}
		}
	}
	
	public boolean teleport(String targetName, Double x, Double y, Double z) {
		// 목표 플레이어 정보를 이름으로 가져온다.
		Player targetPlayer = getServer().getPlayer(targetName);
		
		// 해당 이름의 플레이어가 없으면 false로 반환하고 teleport 메서드를 종료한다.
		if(targetPlayer == null) {
			return false;
		}		
		// 목표 플레이어가 있는 세계에서 입력한 좌표(X,Y,Z) 정보를 생성한다.
		Location destincation = new org.bukkit.Location(targetPlayer.getWorld(), x, y, z);	
		
		// 목표 플레이어를 입력한 좌표로 이동시킨다. 성공하면 true를 반환하고 실패하면 false를 반환한다.
		return targetPlayer.teleport(destincation);
	}
}
