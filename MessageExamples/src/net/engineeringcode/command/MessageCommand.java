package net.engineeringcode.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

import net.engineeringcode.mc.MessageExamples;

public class MessageCommand implements CommandExecutor{

		private MessageExamples plugin;
		
		public MessageCommand(MessageExamples plugin) {
			this.plugin = plugin;
			plugin.getCommand("hi").setExecutor(this);
			plugin.getCommand("hello").setExecutor(this);
			plugin.getCommand("helloworld.hello").setExecutor(this);
		}

		@Override
		public boolean onCommand(@Nullable CommandSender sender, @Nullable Command command, @Nullable String label, @Nullable String[] args) {
			if(!(sender instanceof Player)) {
				sender.sendMessage("플레이어만 이 명령어를 실행할 수 있습니다.");
				return true;
			}
			Player player = (Player) sender;
			if(player.hasPermission("helloworld.hello")) {
				player.sendMessage("안녕하세요!");
				return true;
			}else {
				player.sendMessage("이 명령어에 대한 권한을 가지고 있지 않습니다.");
			}
			return false;
		}
}
